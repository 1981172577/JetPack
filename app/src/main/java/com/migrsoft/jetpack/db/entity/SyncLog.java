package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：数据同步日志
 * <p>
 * 记录哪些表的数据需要被同步
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "synclog")
public class SyncLog implements Parcelable {
    public static final Creator<SyncLog> CREATOR = new Creator<SyncLog>() {
        @Override
        public SyncLog createFromParcel(Parcel source) {
            return new SyncLog(source);
        }

        @Override
        public SyncLog[] newArray(int size) {
            return new SyncLog[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;          //  bigint(20) DEFAULT NULL COMMENT '商家ID',
    private String organCode;       //  varchar(16) DEFAULT NULL COMMENT '机构编码',
    private String storeCode;       //  varchar(16) NOT NULL COMMENT '门店编码',
    private String posCode;         //  varchar(16) NOT NULL COMMENT '销售点设备编码 例:pos机编码 手持编码',
    private int dbtype;             //  int(11) DEFAULT NULL
    private String syncTime;        //  同步开始时间,
    private String endTime;         //  同步结束时间 -- 增量更新
    private String endTime2;        //  同步结束时间 -- 全量更新
    private int syncTimeCount;      //  增量更新 - 分页标志
    private int syncTimeCount2;     //  全量更新 - 分页标志
    private String createDate;      //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;      //  datetime NOT NULL COMMENT '修改日期',
    @Ignore
    private int sflag;              //  本次处理结果 1成功  （0失败 后台主动结束传输）
    @Ignore
    private int needDeal;           //

    public SyncLog() {
    }

    private SyncLog(Builder builder) {
        setId(builder.id);
        setVendorId(builder.vendorId);
        setOrganCode(builder.organCode);
        setStoreCode(builder.storeCode);
        setPosCode(builder.posCode);
        setDbtype(builder.dbtype);
        setSyncTime(builder.syncTime);
        setEndTime(builder.endTime);
        setEndTime2(builder.endTime2);
        setSyncTimeCount(builder.syncTimeCount);
        setSyncTimeCount2(builder.syncTimeCount2);
        setCreateDate(builder.createDate);
        setModifyDate(builder.modifyDate);
        setSflag(builder.sflag);
        setNeedDeal(builder.needDeal);
    }

    protected SyncLog(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.organCode = in.readString();
        this.storeCode = in.readString();
        this.posCode = in.readString();
        this.dbtype = in.readInt();
        this.syncTime = in.readString();
        this.endTime = in.readString();
        this.endTime2 = in.readString();
        this.syncTimeCount = in.readInt();
        this.syncTimeCount2 = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.sflag = in.readInt();
        this.needDeal = in.readInt();
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

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public int getDbtype() {
        return dbtype;
    }

    public void setDbtype(int dbtype) {
        this.dbtype = dbtype;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime2() {
        return endTime2;
    }

    public void setEndTime2(String endTime2) {
        this.endTime2 = endTime2;
    }

    public int getSyncTimeCount() {
        return syncTimeCount;
    }

    public void setSyncTimeCount(int syncTimeCount) {
        this.syncTimeCount = syncTimeCount;
    }

    public int getSyncTimeCount2() {
        return syncTimeCount2;
    }

    public void setSyncTimeCount2(int syncTimeCount2) {
        this.syncTimeCount2 = syncTimeCount2;
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

    public int getSflag() {
        return sflag;
    }

    public void setSflag(int sflag) {
        this.sflag = sflag;
    }

    public int getNeedDeal() {
        return needDeal;
    }

    public void setNeedDeal(int needDeal) {
        this.needDeal = needDeal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.organCode);
        dest.writeString(this.storeCode);
        dest.writeString(this.posCode);
        dest.writeInt(this.dbtype);
        dest.writeString(this.syncTime);
        dest.writeString(this.endTime);
        dest.writeString(this.endTime2);
        dest.writeInt(this.syncTimeCount);
        dest.writeInt(this.syncTimeCount2);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.sflag);
        dest.writeInt(this.needDeal);
    }

    public static final class Builder {
        private long id;
        private long vendorId;
        private String organCode;
        private String storeCode;
        private String posCode;
        private int dbtype;
        private String syncTime;
        private String endTime;
        private String endTime2;
        private int syncTimeCount;
        private int syncTimeCount2;
        private String createDate;
        private String modifyDate;
        private int sflag;
        private int needDeal;

        public Builder() {
        }

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder organCode(String val) {
            organCode = val;
            return this;
        }

        public Builder storeCode(String val) {
            storeCode = val;
            return this;
        }

        public Builder posCode(String val) {
            posCode = val;
            return this;
        }

        public Builder dbtype(int val) {
            dbtype = val;
            return this;
        }

        public Builder syncTime(String val) {
            syncTime = val;
            return this;
        }

        public Builder endTime(String val) {
            endTime = val;
            return this;
        }

        public Builder endTime2(String val) {
            endTime2 = val;
            return this;
        }

        public Builder syncTimeCount(int val) {
            syncTimeCount = val;
            return this;
        }

        public Builder syncTimeCount2(int val) {
            syncTimeCount2 = val;
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

        public Builder sflag(int val) {
            sflag = val;
            return this;
        }

        public Builder needDeal(int val) {
            needDeal = val;
            return this;
        }

        public SyncLog build() {
            return new SyncLog(this);
        }
    }
}
