package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SystemInfo;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface SystemInfoDao extends BaseDao<SystemInfo> {

    @Query("SELECT * FROM SystemInfo where vendorId = :vendorId order by createDate desc limit 1")
    SystemInfo takeByVendorId(long vendorId);

    @Query("delete from systeminfo")
    void deleteAll();
}
