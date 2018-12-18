package com.migrsoft.jetpack.application;

import android.arch.persistence.room.InvalidationTracker;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.migrsoft.jetpack.annotaion.App;
import com.migrsoft.jetpack.db.PosDataBase;
import com.migrsoft.jetpack.db.dao.RegisterDao;
import com.migrsoft.jetpack.db.dao.SparameterDao;
import com.migrsoft.jetpack.db.dao.UserRoleDao;
import com.migrsoft.jetpack.db.entity.Register;
import com.migrsoft.jetpack.db.entity.Sparameter;
import com.migrsoft.jetpack.db.entity.User;
import com.migrsoft.jetpack.repository.impl.CacheRepositoryImpl;
import com.migrsoft.jetpack.http.cache.Editor;
import com.migrsoft.jetpack.repository.CacheRepository;
import com.migrsoft.jetpack.utils.AmountUtil;
import com.migrsoft.jetpack.utils.FileUtils;
import com.migrsoft.jetpack.utils.LogUtils;
import com.migrsoft.jetpack.utils.encrypt.MD5Utils;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

import javax.inject.Named;
import java.io.*;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 简介：Application module
 *
 * @author 王强（249346528@qq.com） 2017/8/3.
 */
@Module
public class PosModule {

    public PosModule(PosApplication application) {
        CrashInterceptor.inject(application);
    }

    @App
    @Provides
    public PosDataBase provideDataBase(PosApplication application, CacheRepository cache) {
        PosDataBase dataBase = PosDataBase.getInstance(application.getApplicationContext());
        dataBase.getInvalidationTracker()
                .addObserver(new SparameterTracker(cache, dataBase.getSparameterDao()));
        dataBase.getInvalidationTracker()
                .addObserver(new RegisterTracker(cache, dataBase.getRegisterDao()));
        dataBase.getInvalidationTracker()
                .addObserver(new UserRuleTracker(cache, dataBase.getUserRoleDao()));
        return dataBase;
    }

    @App
    @Provides
    public CacheRepository provideCacheRepository() {
//        String cachePath = app.getCacheDir().getAbsolutePath();
        return new CacheRepositoryImpl(FileUtils.getCachePath());
    }


    @App
    @Provides
    @Named("GET")
    Interceptor provideIntercept() {
        return new InterceptForGET();
    }


    public static class InterceptForPOST extends InterceptForGET {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            if (TextUtils.equals("POST", originalRequest.method())) {
                long vendorId = getPostVendorId(originalRequest);
                if (vendorId == 0) {
                    vendorId = getVendorId(originalRequest);
                }
                HttpUrl url = originalRequest.url().newBuilder()
                        .addQueryParameter("stype", "1")
                        .addQueryParameter("rtype", "1")
                        .addQueryParameter("sign", getSign(originalRequest, vendorId))
                        .build();
                Request request = originalRequest.newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            } else {
                return super.intercept(chain);
            }
        }

        private long getPostVendorId(Request request) {
            String url = request.url().toString();
            if (TextUtils.equals("POST", request.method())) {
                url += "?" + getPostBodyData(request);
            }
            Uri uri = Uri.parse(url);
            String vendorId = uri.getQueryParameter("vendorId");
            if (TextUtils.isEmpty(vendorId)) {
                return 0;
            } else {
                return Long.parseLong(vendorId);
            }
        }

        private String getPostBodyData(Request request) {
            Buffer buffer = new Buffer();
            try {
                request.body().writeTo(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buffer.readUtf8();
        }
    }

    /**
     * @author 王强 on 2017/12/14 249346528@qq.com
     */
    public static class InterceptForGET implements Interceptor {
        protected String patStr = "http://.*\\?"
                + "|[\\u4E00-\\u9FA5]+"
                + "|[\\u3000-\\u301e\\ufe10-\\ufe19\\ufe30-\\ufe44\\ufe50-\\ufe6b\\uff01-\\uffee]+";

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            HttpUrl url = originalRequest.url().newBuilder()
                    .addQueryParameter("stype", "1")
                    .addQueryParameter("rtype", "1")
                    .addQueryParameter("sign", getSign(originalRequest, getVendorId(originalRequest)))
                    .build();
            LogUtils.i("url:" + url);
            Request request = originalRequest.newBuilder()
                    .url(url)
                    .build();
            return chain.proceed(request);
        }

        protected long getVendorId(Request request) {
            Uri uri = Uri.parse(request.url().toString());
            String vendorId = uri.getQueryParameter("vendorId");
            if (TextUtils.isEmpty(vendorId)) {
                return 0;
            } else {
                return Long.parseLong(vendorId);
            }
        }


        protected String getSign(Request request, long vendorId) {
            Pattern pat = Pattern.compile(patStr);
            String url = "";
            try {
                url = URLDecoder.decode(request.url().toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String urlString = pat.matcher(url).replaceAll("");
            String vendorIdStr = MD5Utils.md5(MD5Utils.md5(vendorId + ""));// 商家ID的2次MD加密
            String sign = MD5Utils.md5(urlString + "&stype=1" + "&rtype=" + 1 + vendorIdStr);

            return sign;
        }
    }

    private static class CrashInterceptor implements Thread.UncaughtExceptionHandler {
        private Context mContext;
        private Thread.UncaughtExceptionHandler mDefaultHandler;

        private CrashInterceptor(Context context) {
            this.mContext = context;
            this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        public static void inject(Context context) {
            new CrashInterceptor(context);
        }

        private static String getFileName() {
            DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
            return sdf.format(Calendar.getInstance().getTime()) + ".crash";
        }

        public static void main(String arg[]) {
            System.out.println(getFileName());
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            handleException(e);
            if (mDefaultHandler != null) {
                mDefaultHandler.uncaughtException(t, e);
            }
            e.printStackTrace();
        }

        private void handleException(Throwable ex) {
            if (ex == null) {
                return;
            }
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ex.printStackTrace(printWriter);
            Throwable cause = ex.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            String result = writer.toString();
            StringBuffer sb = new StringBuffer(collectDeviceInfo(mContext));
            sb.append(result);
            String dirPath = FileUtils.getCrashPath();
            File cacheDir = new File(dirPath);
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            try {
                File logFile = new File(cacheDir, getFileName());
                if (!logFile.exists()) {
                    logFile.createNewFile();
                }
                FileWriter fw = new FileWriter(logFile);
                fw.write(sb.toString());
                fw.flush();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String collectDeviceInfo(Context ctx) {
            ContentValues value = new ContentValues();
            try {
                PackageManager packageManager = ctx.getPackageManager();
                PackageInfo packInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
                value.put("APP_version:", packInfo.versionName);
                value.put("Model:", Build.MODEL);
                value.put("SDK_INT:", Build.VERSION.SDK_INT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return value.toString();
        }
    }

    public static class UserRuleTracker extends InvalidationTracker.Observer {
        private static final String TABLENAME = "userrole";
        private CacheRepository cacheRepository;
        private UserRoleDao dao;

        protected UserRuleTracker(CacheRepository cache, UserRoleDao dao) {
            super(TABLENAME);
            this.cacheRepository = cache;
            this.dao = dao;
        }

        @Override
        public void onInvalidated(@NonNull Set<String> tables) {
            initLoginUserRoleIds(cacheRepository, dao);
        }

        public static void initLoginUserRoleIds(CacheRepository c, UserRoleDao dao) {
            User loginedUser = c.getLoginedUser();
            Integer[] loginedUserRoleIds;
            if (loginedUser.getUserType() == 2) {
                loginedUserRoleIds = dao.pickSuperUserRoles();
            } else {
                loginedUserRoleIds = dao.pickUserRolesByUserName(loginedUser.getUserName());
            }
            c.put(CacheRepository.USER_ROLES_ID_KEY, loginedUserRoleIds).commit();
        }
    }

    private static class RegisterTracker extends InvalidationTracker.Observer {
        private static final String TABLENAME = "register";
        private CacheRepository cacheRepository;
        private RegisterDao dao;

        protected RegisterTracker(CacheRepository cache, RegisterDao dao) {
            super(TABLENAME);
            this.cacheRepository = cache;
            this.dao = dao;
        }

        @Override
        public void onInvalidated(@NonNull Set<String> tables) {
            Register bindRegister = cacheRepository.getBindRegister();
            if (bindRegister == null) {
                return;
            }
            Register register = dao.takeByPosCode(bindRegister.getRcode());
            cacheRepository.put(Register.class.getName(), register);
        }
    }

    private static class SparameterTracker extends InvalidationTracker.Observer {
        private static final String TABLENAME = "saprameter";
        private CacheRepository cacheRepository;
        private SparameterDao sparameterDao;

        protected SparameterTracker(CacheRepository cache, SparameterDao dao) {
            super(TABLENAME);
            this.cacheRepository = cache;
            this.sparameterDao = dao;
        }

        @Override
        public void onInvalidated(@NonNull Set<String> tables) {
            Editor<Sparameter> editor = null;
            for (Sparameter sparameter : sparameterDao.getAll()) {
                if (editor == null) {
                    editor = cacheRepository.put(sparameter.getParamCode(), sparameter);
                } else {
                    editor.put(sparameter.getParamCode(), sparameter);
                }
            }
            AmountUtil.init(cacheRepository);
            if (editor != null) {
                editor.commit();
            }
        }
    }
}
