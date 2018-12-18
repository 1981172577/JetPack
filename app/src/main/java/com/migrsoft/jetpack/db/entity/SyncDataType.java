package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：数据组类型
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "syncdatatype",
        indices = {@Index(value = "vendorId", name = "idx_syncDataType_vendorId"),
                @Index(value = "dbtype", name = "idx_syncDataType_dbtype")})
public class SyncDataType implements Parcelable {
    public static final Creator<SyncDataType> CREATOR = new Creator<SyncDataType>() {
        @Override
        public SyncDataType createFromParcel(Parcel source) {
            return new SyncDataType(source);
        }

        @Override
        public SyncDataType[] newArray(int size) {
            return new SyncDataType[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;            //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;      //  bigint(20) DEFAULT NULL COMMENT '商家ID',
    private int dbtype;         //  int(11) DEFAULT NULL COMMENT '数据组类型',
    private String dbname;      //  varchar(16) DEFAULT NULL COMMENT '数据组名称',
    private int needflag;       //  tinyint(4) DEFAULT NULL COMMENT '是否需要下载',
    private int syncCount;      //  int(11) DEFAULT NULL COMMENT '每次下载数据量',
    private String createDate;  //  datetime DEFAULT NULL COMMENT '创建日期',
    private String modifyDate;  //  datetime DEFAULT NULL COMMENT '修改日期',
    private String creator;     //  varchar(32) DEFAULT NULL COMMENT '创建人',
    private String mender;      //  varchar(32) DEFAULT NULL COMMENT '最后修改人',

    private SyncDataType(Builder builder) {
        vendorId = builder.vendorId;
        dbtype = builder.dbtype;
        dbname = builder.dbname;
        needflag = builder.needflag;
        syncCount = builder.syncCount;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        creator = builder.creator;
        mender = builder.mender;
    }

    public SyncDataType() {
    }

    protected SyncDataType(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.dbtype = in.readInt();
        this.dbname = in.readString();
        this.needflag = in.readInt();
        this.syncCount = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.creator = in.readString();
        this.mender = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeInt(this.dbtype);
        dest.writeString(this.dbname);
        dest.writeInt(this.needflag);
        dest.writeInt(this.syncCount);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
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

    public int getDbtype() {
        return dbtype;
    }

    public void setDbtype(int dbtype) {
        this.dbtype = dbtype;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public int getNeedflag() {
        return needflag;
    }

    public void setNeedflag(int needflag) {
        this.needflag = needflag;
    }

    public int getSyncCount() {
        return syncCount;
    }

    public void setSyncCount(int syncCount) {
        this.syncCount = syncCount;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getMender() {
        return mender;
    }

    public void setMender(String mender) {
        this.mender = mender;
    }

    public static final class Builder {
        private long vendorId;
        private int dbtype;
        private String dbname;
        private int needflag;
        private int syncCount;
        private String createDate;
        private String modifyDate;
        private String creator;
        private String mender;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder dbtype(int val) {
            dbtype = val;
            return this;
        }

        public Builder dbname(String val) {
            dbname = val;
            return this;
        }

        public Builder needflag(int val) {
            needflag = val;
            return this;
        }

        public Builder syncCount(int val) {
            syncCount = val;
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

        public Builder creator(String val) {
            creator = val;
            return this;
        }

        public Builder mender(String val) {
            mender = val;
            return this;
        }

        public SyncDataType build() {
            return new SyncDataType(this);
        }
    }
}
