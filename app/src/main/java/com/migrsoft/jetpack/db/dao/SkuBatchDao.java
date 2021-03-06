package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.SkuBatch;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface SkuBatchDao extends BaseDao<SkuBatch> {

    /**
     * @param codes
     * @param nos
     * @return
     */
    @Query("select * from skubatch where skucode in(:codes) and batchno in (:nos)")
    List<SkuBatch> listByCodesAndNos(List<String> codes, List<String> nos);

}
