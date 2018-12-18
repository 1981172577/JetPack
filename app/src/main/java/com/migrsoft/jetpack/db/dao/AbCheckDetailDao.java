package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.*;
import com.migrsoft.jetpack.db.entity.AbCheckDetail;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/14.
 */
@Dao
public interface AbCheckDetailDao {

    @Insert
    long[] insert(AbCheckDetail... values);

    @Delete
    int delete(AbCheckDetail value);

    @Update
    int update(AbCheckDetail value);

    @Query("select * from abcheckdetail")
    List<AbCheckDetail> getAll();
}
