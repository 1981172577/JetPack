package com.migrsoft.jetpack.utils;

import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 简介：网络状态帮助类
 *
 * @author 王强（249346528@qq.com） 2017/9/12.
 */

public class NetStatusHelper extends LiveData<Boolean> {
    private Context context;
    private NetListener netListener = new NetListener();

    public NetStatusHelper(Context context) {
        this.context = context;
    }

    /**
     * 获取当前的网络状态
     *
     * @param ctx
     * @return true 网络可用
     */
    public static boolean isNetAvailable(Context ctx) {
        if (ctx == null) {
            return false;
        }
        ConnectivityManager connectivityManager =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 当前的网络是否已连接可用网络
     *
     * @param ctx
     * @return true 网络已连接
     */
    public static boolean isNetConnected(Context ctx) {
        if (ctx == null) {
            return false;
        }
        ConnectivityManager connectivityManager =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    protected void onActive() {
        super.onActive();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(netListener, filter);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(netListener);
    }

    private class NetListener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            setValue(isNetAvailable(context));
        }
    }
}
