package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.*;
import com.migrsoft.jetpack.db.entity.AdjustDetail;

import java.util.List;

/**
 * @author congguangzi (congspark@163.com) 2017/8/16.
 */
@Dao
public interface AdjustDetailDao {
    @Insert
    long[] insert(AdjustDetail... values);

    @Delete
    int delete(AdjustDetail value);

    @Update
    int update(AdjustDetail value);

    @Query("SELECT * FROM adjustdetail")
    List<AdjustDetail> getAll();
}
