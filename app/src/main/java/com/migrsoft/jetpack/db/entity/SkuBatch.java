package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：商品SKU批次号
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "skubatch",
        indices = {@Index(value = {"vendorId", "skuCode"}, name = "idx_skuBatch_idCode")})
public class SkuBatch implements Parcelable {
    public static final Creator<SkuBatch> CREATOR = new Creator<SkuBatch>() {
        @Override
        public SkuBatch createFromParcel(Parcel source) {
            return new SkuBatch(source);
        }

        @Override
        public SkuBatch[] newArray(int size) {
            return new SkuBatch[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;              // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;        // bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String skuCode;       // varchar(16) DEFAULT NULL COMMENT '商品编码',
    private String batchNo;       // varchar(32) DEFAULT NULL COMMENT '批次号',
    private String memo;          // varchar(32) DEFAULT NULL COMMENT '备注',
    private int df;               // tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;    // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;    // datetime NOT NULL COMMENT '修改日期',
    private long batchid;         // bigint(20) DEFAULT NULL,

    private SkuBatch(Builder builder) {
        vendorId = builder.vendorId;
        skuCode = builder.skuCode;
        batchNo = builder.batchNo;
        memo = builder.memo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        batchid = builder.batchid;
    }

    public SkuBatch() {
    }

    protected SkuBatch(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.skuCode = in.readString();
        this.batchNo = in.readString();
        this.memo = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.batchid = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.skuCode);
        dest.writeString(this.batchNo);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeLong(this.batchid);
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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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

    public long getBatchid() {
        return batchid;
    }

    public void setBatchid(long batchid) {
        this.batchid = batchid;
    }

    public static final class Builder {
        private long vendorId;
        private String skuCode;
        private String batchNo;
        private String memo;
        private int df;
        private String createDate;
        private String modifyDate;
        private long batchid;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public Builder batchNo(String val) {
            batchNo = val;
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

        public Builder batchid(long val) {
            batchid = val;
            return this;
        }

        public SkuBatch build() {
            return new SkuBatch(this);
        }
    }
}
