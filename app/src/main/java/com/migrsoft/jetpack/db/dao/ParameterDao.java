package com.migrsoft.jetpack.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.base.BaseDao;
import com.migrsoft.jetpack.db.entity.Parameter;
import io.reactivex.Flowable;

/**
 * @author congguangzi (congspark@163.com) 2017/9/14.
 */
@Dao
public interface ParameterDao extends BaseDao<Parameter> {

    @Query("select * from parameter where pcode = :code")
    Flowable<Parameter> getCurrentParameter(String code);


}
