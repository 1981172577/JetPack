package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SkuUnit;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface SkuUnitDao extends BaseDao<SkuUnit> {
//    @Query("select * from skuunit where plusCode like :plusCode AND DF = 0")
//    Flowable<List<SkuUnit>> getSkuListByPlusCode(String plusCode);

    @Query("delete from skuunit")
    void deleteAll();

    @Query("SELECT * FROM skuunit;")
    List<SkuUnit> queryAllSkuUnit();
}
