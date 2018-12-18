package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：商家用户角色关联表
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "userrole",
        indices = {@Index(value = "userName", name = "idx_venderUserRole_userName"),
                @Index(value = "roleId", name = "idx_venderUserRole_roleId")})
public class UserRole implements Parcelable {
    public static final Creator<UserRole> CREATOR = new Creator<UserRole>() {
        @Override
        public UserRole createFromParcel(Parcel source) {
            return new UserRole(source);
        }

        @Override
        public UserRole[] newArray(int size) {
            return new UserRole[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;           //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private String userName;     //  varchar(32) NOT NULL COMMENT '角色所属商家ID',
    private long roleId;       //  bigint(20) NOT NULL COMMENT '角色名称',
    private int df;           //  int(11) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;   //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;   //  datetime NOT NULL COMMENT '修改日期',
    private long vendorId;     //  bigint(20) NOT NULL,

    private UserRole(Builder builder) {
        userName = builder.userName;
        roleId = builder.roleId;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        vendorId = builder.vendorId;
    }

    public UserRole() {
    }

    protected UserRole(Parcel in) {
        this.id = in.readLong();
        this.userName = in.readString();
        this.roleId = in.readLong();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.vendorId = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.userName);
        dest.writeLong(this.roleId);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeLong(this.vendorId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public static final class Builder {
        private String userName;
        private long roleId;
        private int df;
        private String createDate;
        private String modifyDate;
        private long vendorId;

        public Builder() {
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder roleId(long val) {
            roleId = val;
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

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}
