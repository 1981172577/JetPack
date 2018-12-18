package com.migrsoft.jetpack.application;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;
import com.facebook.stetho.Stetho;
import com.migrsoft.jetpack.BuildConfig;
import com.migrsoft.jetpack.db.PosDataBase;
import com.migrsoft.jetpack.repository.CacheRepository;

import javax.inject.Inject;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/3.
 */

public class PosApplication extends MultiDexApplication {
    private static PosApplication INSTANCE = null;
    @Inject
    PosDataBase db;
    @Inject
    CacheRepository cacheRepository;
    private PosComponent posComponent;

    public static PosApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
        if (BuildConfig.DEBUG) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog();
            threadPolicyBuilder.penaltyDeathOnNetwork();
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
        }

        posComponent = DaggerPosComponent.builder()
                .posModule(new PosModule(this))
                .bindApplication(this)
                .build();
        posComponent.inject(this);
        INSTANCE = this;
    }

    public PosComponent getPosComponent() {
        return posComponent;
    }

    public CacheRepository getCacheRepository(){
        return cacheRepository;
    }

    /**
     * 最小化App
     */
    public void homeApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public int getMemoryCacheSize() {
        final int memSize = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        return 1024 * 1024 * memSize / 8;
    }

}
