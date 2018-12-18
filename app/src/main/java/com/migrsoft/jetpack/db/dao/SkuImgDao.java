package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SkuImg;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface SkuImgDao extends BaseDao<SkuImg> {
    @Query("SELECT * from skuimg GROUP BY skuCode;")
    List<SkuImg> querySkuImg();

    @Query("delete from skuimg")
    void deleteAll();
}
