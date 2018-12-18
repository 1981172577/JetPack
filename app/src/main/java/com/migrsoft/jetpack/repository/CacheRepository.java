package com.migrsoft.jetpack.repository;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.migrsoft.jetpack.db.entity.Register;
import com.migrsoft.jetpack.db.entity.Sparameter;
import com.migrsoft.jetpack.db.entity.User;
import com.migrsoft.jetpack.http.cache.Editor;

import java.io.Serializable;

/**
 * 简介：缓存数据（同步）
 *
 * @author 王强（249346528@qq.com） 2017/8/9.
 */

public interface CacheRepository {
    String USER_ROLES_ID_KEY = "UserRoleIdsForCurrentUser";
    /**
     * 保存当前登录用户信息
     *
     * @param user
     * @return
     */
    Editor<Serializable> put(User user);

    /**
     * 获取当前登陆账号的信息,从内存中读取同步返回，无IO操作
     *
     * @return 当前登陆账号的信息
     */
    User getLoginedUser();

    /**
     * 当前登陆用户的RoleIds
     * @return
     */
    Integer[] getUserRoleIds();

    /**
     * 保存绑定的POS机信息
     *
     * @param register Register
     * @return
     */
    Editor<Serializable> put(Register register);

    /**
     * 获取当前绑定的POS机，从内存中读取同步返回，无IO操作
     *
     * @return 当前绑定的pos机
     */
    Register getBindRegister();

    /**
     * 保存Sparameter 调用 {@link Editor#apply()}
     * 或者 {@link Editor#commit()}完成数据的保存 注意：非持久化存储
     *
     * @param key
     * @param p
     * @return
     */
    Editor<Sparameter> put(String key, Sparameter p);

    /**
     * 从内存中获取Sparameter,同步返回，无IO操作
     *
     * @param key
     * @return
     */
    @Nullable
    Sparameter getAsSparameter(String key);

    /**
     * 保存{@link Serializable} 对象 调用 {@link Editor#apply()}
     * 或者 {@link Editor#commit()}完成数据的持久化保存
     *
     * @param key
     * @param value
     * @return 返回编辑器
     */
    Editor<Serializable> put(String key, Serializable value);

    /**
     * 获取缓存对象
     *
     * @param key
     * @return
     */
    Serializable getAsSerializable(String key);

    /**
     * 删除-异步方式删除不会阻塞主线程
     *
     * @param key
     * @return true 成功
     */
    @WorkerThread
    boolean remove(String key);

    /**
     * 删除 - 同步方式删除会阻塞主线程
     *
     * @param key
     * @return true成功
     */
    @WorkerThread
    boolean removeImmediately(String key);

    /**
     * 释放内存资源但是不会释放SD卡空间
     */
    void release();
}
