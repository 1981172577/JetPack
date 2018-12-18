package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.User;
import io.reactivex.Flowable;

import java.util.List;

/**
 * 简介：User表操作封装
 *
 * @author 王强（249346528@qq.com） 2017/8/9.
 */
@Dao
public interface UserDao extends BaseDao<User> {
    String LOCAL_LOGIN_VERIFY_SQL = "SELECT * FROM User WHERE pwd = :psw " +
            "and (userName = :userName or (cellPhone = :userName and bindFlag = 1)) LIMIT 1";

    @Query("SELECT * FROM USER")
    Flowable<User> observeAll();

    @Query("SELECT * FROM User LIMIT :count OFFSET :offset")
    List<User> pick(int offset, int count);

    @Query(LOCAL_LOGIN_VERIFY_SQL)
    User verifyLogin(String userName, String psw);

    @Query("select * from user where userName = :name limit 1")
    User takeUserByName(String name);


    @Query("select * from user where userName = :userName limit 1")
    Flowable<User> queryUserByName(String userName);

    @Query("select * from user where userName in (:userNames)")
    List<User> listByUserNames(List<String> userNames);

    @Query("select * from user where df = 0 and userStatus = 0 and storeCode = :storeCode")
    List<User> getCasherUserList(String storeCode);
}
