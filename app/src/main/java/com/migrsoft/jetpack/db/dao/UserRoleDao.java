package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.UserRole;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface UserRoleDao extends BaseDao<UserRole> {
    String SQL_NORMAL_USERROLE = "select roleId from userrole where userName=:userName and df=0";
    String SQL_SUPER_USERROLE = "select roleId from userrole where df=0 group by roleId";

    @Query(SQL_NORMAL_USERROLE)
    Integer[] pickUserRolesByUserName(String userName);

    @Query(SQL_SUPER_USERROLE)
    Integer[] pickSuperUserRoles();

    @Query("select * from userrole where userName = :userName and  roleId = :roleId")
    List<UserRole> getUserRoleList(String userName, long roleId);


    @Query("select userrole.roleId from userrole where userrole.df=0 and userrole.userName= :userName")
    List<Long> getUserRoleId(String userName);
}
