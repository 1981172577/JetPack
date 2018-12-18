package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.*;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Menu;
import io.reactivex.Flowable;

import java.util.List;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/7.
 */
@Dao
public interface MenuDao extends BaseDao<Menu> {

    String SQL_ROLEMENU = "select * from rolemenu where roleId in (:userRoleIds) and df=0 AND menuCode LIKE(:posType||'%') AND length(menuCode) = 6 GROUP BY menuCode";
    String SQL_MENU = "select menu.menuCode as menuCode,menu.menuName as menuName from (" +
            SQL_ROLEMENU +
            ") as a inner " +
            "join menu on " +
            "a.menuCode=menu.menuCode " +
            "where menu.df=0 " +
            "and menu.parentCode=:posType " +
            "order by viewOrder";

    @Query("select * from menu GROUP BY menuName")
    Flowable<List<Menu>> queryAllMenu();

    @Query(SQL_MENU)
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    List<HomeMenu> getHomeMenu(Integer[] userRoleIds, String posType);

    @Query("select * from menu where menuCode in (:menuCodes)")
    List<Menu> listByMenuCodes(List<String> menuCodes);

    class HomeMenu {
        @ColumnInfo(name = "menuCode")
        private String menuCode;
        @ColumnInfo(name = "menuName")
        private String menuName;
        @Ignore
        private int iconRes;

        public int getIconRes() {
            return iconRes;
        }

        public void setIconRes(int iconRes) {
            this.iconRes = iconRes;
        }

        public String getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(String menuCode) {
            this.menuCode = menuCode;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
    }

}
