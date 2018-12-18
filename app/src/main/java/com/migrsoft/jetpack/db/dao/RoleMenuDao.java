package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.RoleMenu;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface RoleMenuDao extends BaseDao<RoleMenu> {

    @Query("select * from rolemenu where menuCode = :menuCode and  roleId = :roleId")
    List<RoleMenu> getRoleMenuList(String menuCode, long roleId);

    @Query("select menuCode from rolemenu " +
            "where df=0 " +
            "AND menuCode LIKE(:posType||'%') " +
            "AND length(menuCode)=10 " +
            "and roleId in (select id from role where df=0 and id in(:roleIds))")
    List<String> getRoleMenuCode(String posType, List<Integer> roleIds);

    @Query("SELECT menu.menuCode FROM rolemenu INNER JOIN menu " +
            "ON rolemenu.menuCode = menu.menuCode " +
            "AND rolemenu.menuCode  LIKE (:posType||'%') " +
            "AND length(rolemenu.menuCode) = :menuCodeLength " +
            "AND rolemenu.roleId IN (:roleIds) " +
            "AND rolemenu.df = 0 " +
            "GROUP BY menu.menuCode " +
            "ORDER BY menu.viewOrder ASC;")
    List<String> queryPermissionMenuName(String posType, int menuCodeLength, List<Integer> roleIds);
}
