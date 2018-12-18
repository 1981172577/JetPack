package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.*;
import com.migrsoft.jetpack.db.entity.AbCheckOrder;

import java.util.List;

/**
 * @author congguangzi (congspark@163.com) 2017/8/16.
 */
@Dao
public interface AbCheckOrderDao {

    @Insert
    long[] insert(AbCheckOrder... values);

    @Delete
    int delete(AbCheckOrder value);

    @Update
    int update(AbCheckOrder value);

    @Query("SELECT * from abcheckorder")
    List<AbCheckOrder> getAll();
}
