package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.*;
import com.migrsoft.jetpack.db.entity.AdjustOrder;

import java.util.List;

/**
 * @author congguangzi (congspark@163.com) 2017/8/16.
 */
@Dao
public interface AdjustOrderDao {

    @Insert
    long[] insert(AdjustOrder... values);

    @Delete
    int delete(AdjustOrder values);

    @Update
    int update(AdjustOrder values);

    @Query("SELECT * FROM adjustorder")
    List<AdjustOrder> getAll();
}
