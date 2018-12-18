package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.PrimaryKey;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/16.
 */

public class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    protected long id; //记录ID
    protected long vendorId;//商家ID
    protected int df;//是否已删除1删除 0正常
    protected long createDate;//创建日期
    protected long modifyDate;//修改日期

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
}
