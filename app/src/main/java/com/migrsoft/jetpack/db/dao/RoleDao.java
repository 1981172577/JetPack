package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Role;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/6.
 */
@Dao
public interface RoleDao extends BaseDao<Role> {

    @Query("select * from role where roleId in (:roleIds)")
    List<Role> listByRoleIds(List<Long> roleIds);

    @Query("select role.id from role where role.df=0 and role.id in(:roleIds)")
    List<Long> queryRoleIds(List<Long> roleIds);
}
