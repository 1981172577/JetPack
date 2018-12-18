package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：SKU商品属性
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "skuattr",
        indices = {@Index(value = {"vendorId", "skuCode"}, name = "idx_itemAttr_idcode")})
public class SkuAttr implements Parcelable {
    public static final Creator<SkuAttr> CREATOR = new Creator<SkuAttr>() {
        @Override
        public SkuAttr createFromParcel(Parcel source) {
            return new SkuAttr(source);
        }

        @Override
        public SkuAttr[] newArray(int size) {
            return new SkuAttr[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;               //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;         //  bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String skuCode;        //  varchar(16) DEFAULT NULL COMMENT 'sku商品编码',
    private long tempId;           //  bigint(20) DEFAULT NULL COMMENT '属性模板id',
    private long dicId;            //  bigint(20) DEFAULT NULL COMMENT '属性字典ID',
    private long attrId;           //  bigint(20) DEFAULT NULL COMMENT '属性ID',
    private String attrName;       //  varchar(32) DEFAULT NULL COMMENT '属性名称',
    private String attrValue;      //  varchar(64) DEFAULT NULL COMMENT '属性值',
    private int attrFlag;          //  tinyint(4) NOT NULL COMMENT '属性标记 1规格属性 0通用属性',
    private int df;                //  tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;     //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;     //  datetime NOT NULL COMMENT '修改日期',
    private int version;           //  int(10) unsigned DEFAULT '0' COMMENT '数据版本',
    private String creator;        //  varchar(32) DEFAULT NULL COMMENT '记录创建人用户名',
    private String mender;         //  varchar(32) DEFAULT NULL COMMENT '最后修改人用户名',
    private long sattrid;          //  bigint(20) NOT NULL COMMENT '属性ID',

    private SkuAttr(Builder builder) {
        vendorId = builder.vendorId;
        skuCode = builder.skuCode;
        tempId = builder.tempId;
        dicId = builder.dicId;
        attrId = builder.attrId;
        attrName = builder.attrName;
        attrValue = builder.attrValue;
        attrFlag = builder.attrFlag;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        creator = builder.creator;
        mender = builder.mender;
        sattrid = builder.sattrid;
    }

    public SkuAttr() {
    }

    protected SkuAttr(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.skuCode = in.readString();
        this.tempId = in.readLong();
        this.dicId = in.readLong();
        this.attrId = in.readLong();
        this.attrName = in.readString();
        this.attrValue = in.readString();
        this.attrFlag = in.readInt();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.creator = in.readString();
        this.mender = in.readString();
        this.sattrid = in.readLong();
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
        dest.writeLong(this.tempId);
        dest.writeLong(this.dicId);
        dest.writeLong(this.attrId);
        dest.writeString(this.attrName);
        dest.writeString(this.attrValue);
        dest.writeInt(this.attrFlag);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeLong(this.sattrid);
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

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public long getDicId() {
        return dicId;
    }

    public void setDicId(long dicId) {
        this.dicId = dicId;
    }

    public long getAttrId() {
        return attrId;
    }

    public void setAttrId(long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public int getAttrFlag() {
        return attrFlag;
    }

    public void setAttrFlag(int attrFlag) {
        this.attrFlag = attrFlag;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public long getSattrid() {
        return sattrid;
    }

    public void setSattrid(long sattrid) {
        this.sattrid = sattrid;
    }

    public static final class Builder {
        private long vendorId;
        private String skuCode;
        private long tempId;
        private long dicId;
        private long attrId;
        private String attrName;
        private String attrValue;
        private int attrFlag;
        private int df;
        private String createDate;
        private String modifyDate;
        private int version;
        private String creator;
        private String mender;
        private long sattrid;

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

        public Builder tempId(long val) {
            tempId = val;
            return this;
        }

        public Builder dicId(long val) {
            dicId = val;
            return this;
        }

        public Builder attrId(long val) {
            attrId = val;
            return this;
        }

        public Builder attrName(String val) {
            attrName = val;
            return this;
        }

        public Builder attrValue(String val) {
            attrValue = val;
            return this;
        }

        public Builder attrFlag(int val) {
            attrFlag = val;
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

        public Builder version(int val) {
            version = val;
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

        public Builder sattrid(long val) {
            sattrid = val;
            return this;
        }

        public SkuAttr build() {
            return new SkuAttr(this);
        }
    }
}
