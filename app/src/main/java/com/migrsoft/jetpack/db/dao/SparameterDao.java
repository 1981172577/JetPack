package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Sparameter;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/13.
 */
@Dao
public interface SparameterDao extends BaseDao<Sparameter> {

    @Query("SELECT * FROM saprameter")
    List<Sparameter> getAll();

    @Query("select * from saprameter where paramcode in (:codes)")
    List<Sparameter> listByCodes(List<String> codes);

    @Query("select * from saprameter where paramcode = :code limit 1")
    Sparameter takeByCode(String code);
}
