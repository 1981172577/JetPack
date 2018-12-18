package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Sku;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface SkuDao extends BaseDao<Sku> {
    /**
     * pluCode码查询
     *
     * @param pluCode
     * @return
     */
    @Query("select * from sku " +
            "where df = 0 " +
            "and ecomStatus = 1 " +
            "and skuStatus IN(0,1,5) " +
            "and pluCode = :pluCode " +
            "limit 1")
    Sku querySkuByPluCode(String pluCode);

    /**
     * 国际条码查询
     *
     * @param barCode
     * @return
     */
    @Query("select sku.* from sku " +
            "where sku.df = 0 " +
            "and sku.ecomStatus = 1 " +
            "and sku.skuStatus IN(0,1,5) " +
            "and sku.barcode = :barCode ")
    List<Sku> queryByNationalBarCode(String barCode);
    /**
     * 无码商品
     * @param barCode
     * @return
     */
    @Query("select sku.* from sku " +
            "where sku.df = 0 " +
            "and sku.ecomStatus = 1 " +
            "and sku.skuStatus IN(0,1,5) " +
            "and sku.barcode = :barCode;")
    List<Sku> queryByNationalNoneCode(String barCode);


    @Query("select * from sku where df = 0 and (plusCode = :plusCode or skuCode = :searchCondition COLLATE NOCASE or barcode = :searchCondition or skuName = :searchCondition or helpCode = :searchCondition)")
    List<Sku> querySkuByHelpCode(String plusCode, String searchCondition);


    @Query("select * from sku where skucode in (:codes)")
    List<Sku> listBySkuCodes(List<String> codes);

    @Query("select * from sku where helpCode like (:searchCondition) or itemCode like (:searchCondition)")
    List<Sku> querySkuByCode(String[] searchCondition);

    @Query("select * from sku where df = 0 and (helpCode like (:code) or barcode like (:code)) limit (:limit) offset (:offset)")
    List<Sku> querySpecialCodeSku(String code, int limit, int offset);

    @Query("select *  from sku where df = 0 limit (:limit) offset (:offset)")
    List<Sku> queryAllSku(int limit, int offset);

    /**
     * skucode码查询
     *
     * @return
     */
    @Query("select * from sku where skuCode = (:skuCode) ")
    Sku querySkubeanBySkuCode(String skuCode);

    @Query("select * from sku order by random() limit 2")
    List<Sku> randomQuery();
}
