package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Store;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/6.
 */
@Dao
public interface StoreDao extends BaseDao<Store> {

    @Query("select * from store where storeCode in (:storeCodes)")
    List<Store> listByStoreCodes(List<String> storeCodes);
}
