package com.migrsoft.jetpack.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

public class FileUtils {

    /**
     * SD卡文件根目录
     */
    private static final String BASE_PATH = "TerMinal"+File.separator;

    private static final String DB_NAME = "TERMINAL.DB";
    /**
     * 数据库文件目录
     */
    private static final String DATABASE_PATH = BASE_PATH +"DataBase"+File.separator;
    /**
     * 缓存文件目录
     */
    private static final String CACHE_PATH = BASE_PATH + "Cache" + File.separator;
    /**
     * crash日志文件夹
     */
    private static final String CRASH_PATH = BASE_PATH + "Crash" + File.separator;
    /**
     * 日志文件夹
     */
    private static final String SUPER_LOG_PATH = BASE_PATH + "SuperLog" + File.separator;

    public static String getDataBasePath(){
        String dataBasePath = dealFile(DATABASE_PATH);
        LogUtils.i("dataBasePath:"+dataBasePath);
        return dataBasePath + DB_NAME;
    }


    public static String getCachePath(){
        String cachePath = dealFile(CACHE_PATH);
        LogUtils.i("cachePath:"+cachePath);
        return dealFile(CACHE_PATH);
    }

    public static String getCrashPath(){
        String crashPath = dealFile(CRASH_PATH);
        LogUtils.i("crashPath:"+crashPath);
        return crashPath;
    }

    public static String getSuperLogPath(){
        String superLogPath = dealFile(SUPER_LOG_PATH);
        LogUtils.i("superLogPath:"+superLogPath);
        return superLogPath;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static String dealFile(String path){
        boolean sdExist = TextUtils.equals(Environment.MEDIA_MOUNTED,Environment.getExternalStorageState());
        if(!sdExist){
            throw new RuntimeException("SD CARD CAN NOT BE NULL !!!");
        }
        String dbDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String newPath = dbDir + File.separator+ path ;
        File file = new File(newPath);
        if(!file.exists()){
            file.mkdirs();
        }
        return newPath;
    }
}
