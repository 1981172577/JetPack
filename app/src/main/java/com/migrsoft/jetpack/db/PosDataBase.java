package com.migrsoft.jetpack.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.migrsoft.jetpack.db.dao.*;
import com.migrsoft.jetpack.db.entity.*;
import com.migrsoft.jetpack.utils.FileUtils;

/**
 *
 * @author 王强（249346528@qq.com） 2017/8/8.
 */
@Database(entities = {
        AbCheckDetail.class,
        AbCheckOrder.class,
        AdjustDetail.class,
        AdjustOrder.class,
        CheckTask.class,
        CheckTaskDetail.class,
        Member.class,
        MemCat.class,
        Menu.class,
        Parameter.class,
        Register.class,
        Role.class,
        RoleMenu.class,
        Sparameter.class,
        Sku.class,
        SkuAttr.class,
        SkuBatch.class,
        SkuImg.class,
        SkuPrimary.class,//陈瑞华
        SkuUnit.class,
        Store.class,
        SyncDataType.class,
        SyncLog.class,
        SystemInfo.class,
        User.class,
        UserRole.class,
}, version = 1, exportSchema = true)
@TypeConverters(DateConverter.class)
public abstract class PosDataBase extends RoomDatabase {


    private static final Object LOCK_OBJ = new Object();
    private static PosDataBase INSTANCE;

    public static PosDataBase getInstance(Context ctx) {
        synchronized (LOCK_OBJ) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(ctx, PosDataBase.class,FileUtils.getDataBasePath())
                        .build();
            }
            return INSTANCE;
        }
    }


    public abstract UserDao getUserDao();

    public abstract AbCheckDetailDao getAbCheckDetailDao();

    public abstract AbCheckOrderDao getAbCheckOrderDao();

    public abstract AdjustDetailDao getAdjustDetailDao();

    public abstract AdjustOrderDao getAdjustOrderDao();

    public abstract SyncDataTypeDao getSyncDataTypeDao();

    public abstract RegisterDao getRegisterDao();

    public abstract SyncLogDao getSyncLogDao();

    public abstract StoreDao getStoreDao();

    public abstract RoleDao getRoleDao();

    public abstract UserRoleDao getUserRoleDao();

    public abstract MenuDao getMenuDao();

    public abstract RoleMenuDao getRoleMenuDao();

    public abstract SkuDao getSkuDao();

    public abstract SystemInfoDao getSystemInfoDao();

    public abstract SkuAttrDao getSkuAttrDao();

    public abstract SkuImgDao getSkuImgDao();

    public abstract SkuBatchDao getSkuBatchDao();

    public abstract SkuUnitDao getSkuUnitDao();

    public abstract SparameterDao getSparameterDao();

    public abstract ParameterDao getParameterDao();

}
