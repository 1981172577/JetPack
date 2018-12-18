package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SyncLog;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/4.
 */
@Dao
public interface SyncLogDao extends BaseDao<SyncLog> {
    @Query("SELECT * FROM synclog")
    List<SyncLog> listAll();

    @Query("SELECT * FROM synclog WHERE dbtype = :dataType order by createDate desc LIMIT 1")
    SyncLog takeSyncLogByDataType(int dataType);

    @Query("update synclog set syncTimeCount = 0 , syncTimeCount2 = 0")
    void resetSyncCount();

    @Query("DELETE FROM synclog")
    void deleteAll();
}
