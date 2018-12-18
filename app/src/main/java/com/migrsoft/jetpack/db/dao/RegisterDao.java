package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Register;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/31.
 */
@Dao
public interface RegisterDao extends BaseDao<Register> {
    @Query("select * from register where rcode=:posCode")
    Register takeByPosCode(String posCode);
}
