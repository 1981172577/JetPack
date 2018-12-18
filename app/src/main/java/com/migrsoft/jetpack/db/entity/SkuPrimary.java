package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：分店SKU预选商品
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "skuprimary")
public class SkuPrimary implements Parcelable {
    public static final Creator<SkuPrimary> CREATOR = new Creator<SkuPrimary>() {
        @Override
        public SkuPrimary createFromParcel(Parcel source) {
            return new SkuPrimary(source);
        }

        @Override
        public SkuPrimary[] newArray(int size) {
            return new SkuPrimary[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;          // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private String skuCode;     // varchar(16) DEFAULT NULL COMMENT 'SKU编码',

    private SkuPrimary(Builder builder) {
        skuCode = builder.skuCode;
    }

    public SkuPrimary() {
    }

    protected SkuPrimary(Parcel in) {
        this.id = in.readLong();
        this.skuCode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.skuCode);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkuCode() {

        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public static final class Builder {
        private String skuCode;

        public Builder() {
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public SkuPrimary build() {
            return new SkuPrimary(this);
        }
    }
}
