package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：商家角色表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "role",
        indices = {@Index(value = "vendorId", name = "idx_vendorRole_vendorId")})
public class Role implements Parcelable {
    public static final Creator<Role> CREATOR = new Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel source) {
            return new Role(source);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;// bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;// bigint(20) DEFAULT NULL COMMENT '角色所属商家ID',
    private String roleName;// varchar(32) NOT NULL COMMENT '角色名称',
    private int roleFlag;// tinyint(4) DEFAULT NULL,
    private String memo;// varchar(64) DEFAULT NULL COMMENT '备注',
    private int df;// int(11) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;// datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;// datetime NOT NULL COMMENT '修改日期',
    private long roleId;// bigint(20) NOT NULL COMMENT '角色ID',

    public Role() {
    }


    private Role(Builder builder) {
        vendorId = builder.vendorId;
        roleName = builder.roleName;
        roleFlag = builder.roleFlag;
        memo = builder.memo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        roleId = builder.roleId;
    }

    protected Role(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.roleName = in.readString();
        this.roleFlag = in.readInt();
        this.memo = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.roleId = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.roleName);
        dest.writeInt(this.roleFlag);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeLong(this.roleId);
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(int roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public static final class Builder {
        private long vendorId;
        private String roleName;
        private int roleFlag;
        private String memo;
        private int df;
        private String createDate;
        private String modifyDate;
        private long roleId;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder roleName(String val) {
            roleName = val;
            return this;
        }

        public Builder roleFlag(int val) {
            roleFlag = val;
            return this;
        }

        public Builder memo(String val) {
            memo = val;
            return this;
        }

        public Builder df(int val) {
            df = val;
            return this;
        }

        public Builder createDate(String val) {
            createDate = val;
            return this;
        }

        public Builder modifyDate(String val) {
            modifyDate = val;
            return this;
        }

        public Builder roleId(long val) {
            roleId = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
