package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SyncDataType;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/30.
 */
@Dao
public interface SyncDataTypeDao extends BaseDao<SyncDataType> {
    @Query("select * from syncdatatype where needflag = :needflag and dbtype not in (:excludeDbTypes)")
    List<SyncDataType> listByNeedFlag(int needflag, int[] excludeDbTypes);

    @Query("select * from syncdatatype")
    List<SyncDataType> listAll();

    @Query("DELETE FROM syncdatatype")
    void deleteAll();

    @Query("SELECT * FROM SyncDataType WHERE dbtype = :dbtype")
    SyncDataType getSyncDataByType(int dbtype);
}
