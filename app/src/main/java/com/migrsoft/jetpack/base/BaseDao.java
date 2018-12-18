package com.migrsoft.jetpack.base;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/17.
 */

public interface BaseDao<T> {
    /**
     * 插入数据
     *
     * @param value
     * @return 返回插入数据的id数组
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insert(@NonNull T... value);

    /**
     * 插入数据
     *
     * @param value
     * @return 返回插入数据的id列表
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(@NonNull List<T> value);


    @Update
    int update(@NonNull T... value);

    @Update
    int update(@NonNull List<T> valueList);

    @Delete
    int delete(@NonNull T... value);

    @Delete
    int delete(@Nonnull List<T> valueList);
}
