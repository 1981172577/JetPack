package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：sku单位
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "skuunit",
        indices = {@Index(value = "vendorId", name = "idx_skuUnit_vendorId"),
                @Index(value = "storeCode", name = "idx_skuUnit_storeCode"),
                @Index(value = "plusCode", name = "idx_skuUnit_plusCode"),
                @Index(value = "skuCode", name = "idx_skuUnit_skuCode")})
public class SkuUnit implements Parcelable {
    public static final Creator<SkuUnit> CREATOR = new Creator<SkuUnit>() {
        @Override
        public SkuUnit createFromParcel(Parcel source) {
            return new SkuUnit(source);
        }

        @Override
        public SkuUnit[] newArray(int size) {
            return new SkuUnit[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                 // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;           // bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String storeCode;        // varchar(16) NOT NULL COMMENT '分店编码',
    private String skuCode;          // varchar(16) NOT NULL COMMENT 'SKU编码',
    private String plusCode;         // varchar(128) DEFAULT NULL COMMENT '附加条码',
    private int unitType;            // tinyint(4) NOT NULL COMMENT '单位类型 0库存单位 1辅助单位一 2其他辅助单位',
    private String unit;             // varchar(16) DEFAULT NULL COMMENT '辅助单位名称',
    private double unitNum;          // double(16,5) DEFAULT '1.00000' COMMENT '单位换算系数',
    private double salePrice;        // double(16,5) DEFAULT '0.00000' COMMENT '零售价',
    private double weiPrice;         // double(16,5) DEFAULT '0.00000' COMMENT '微店价',
    private double distPrice;        // double(16,5) DEFAULT '0.00000' COMMENT '分销价',
    private double purchasePrice;    // double(16,5) DEFAULT '0.00000' COMMENT '进货价',
    private double wholesalePrice;   // double(16,5) DEFAULT '0.00000' COMMENT '批发价',
    private double deliverPrice;     // double(16,5) DEFAULT '0.00000' COMMENT '配送价',
    private double vipPrice;         // double(16,5) DEFAULT '0.00000' COMMENT '会员价',
    private double vipPrice1;        // double(16,5) DEFAULT '0.00000' COMMENT '会员价1',
    private double vipPrice2;        // double(16,5) DEFAULT '0.00000' COMMENT '会员价2',
    private double lowPrice;         // double(16,5) DEFAULT '0.00000' COMMENT '最低价',
    private double score;            // double(16,5) DEFAULT NULL COMMENT '积分值 0不积分',
    private int df;                  // tinyint(4) NOT NULL COMMENT '是否已删除 1删除 0正常',
    private String createDate;       // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;       // datetime NOT NULL COMMENT '修改日期',

    private SkuUnit(Builder builder) {
        vendorId = builder.vendorId;
        storeCode = builder.storeCode;
        skuCode = builder.skuCode;
        plusCode = builder.plusCode;
        unitType = builder.unitType;
        unit = builder.unit;
        unitNum = builder.unitNum;
        salePrice = builder.salePrice;
        weiPrice = builder.weiPrice;
        distPrice = builder.distPrice;
        purchasePrice = builder.purchasePrice;
        wholesalePrice = builder.wholesalePrice;
        deliverPrice = builder.deliverPrice;
        vipPrice = builder.vipPrice;
        vipPrice1 = builder.vipPrice1;
        vipPrice2 = builder.vipPrice2;
        lowPrice = builder.lowPrice;
        score = builder.score;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
    }

    public SkuUnit() {
    }

    protected SkuUnit(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.storeCode = in.readString();
        this.skuCode = in.readString();
        this.plusCode = in.readString();
        this.unitType = in.readInt();
        this.unit = in.readString();
        this.unitNum = in.readDouble();
        this.salePrice = in.readDouble();
        this.weiPrice = in.readDouble();
        this.distPrice = in.readDouble();
        this.purchasePrice = in.readDouble();
        this.wholesalePrice = in.readDouble();
        this.deliverPrice = in.readDouble();
        this.vipPrice = in.readDouble();
        this.vipPrice1 = in.readDouble();
        this.vipPrice2 = in.readDouble();
        this.lowPrice = in.readDouble();
        this.score = in.readDouble();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.storeCode);
        dest.writeString(this.skuCode);
        dest.writeString(this.plusCode);
        dest.writeInt(this.unitType);
        dest.writeString(this.unit);
        dest.writeDouble(this.unitNum);
        dest.writeDouble(this.salePrice);
        dest.writeDouble(this.weiPrice);
        dest.writeDouble(this.distPrice);
        dest.writeDouble(this.purchasePrice);
        dest.writeDouble(this.wholesalePrice);
        dest.writeDouble(this.deliverPrice);
        dest.writeDouble(this.vipPrice);
        dest.writeDouble(this.vipPrice1);
        dest.writeDouble(this.vipPrice2);
        dest.writeDouble(this.lowPrice);
        dest.writeDouble(this.score);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
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

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(String plusCode) {
        this.plusCode = plusCode;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(double unitNum) {
        this.unitNum = unitNum;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getWeiPrice() {
        return weiPrice;
    }

    public void setWeiPrice(double weiPrice) {
        this.weiPrice = weiPrice;
    }

    public double getDistPrice() {
        return distPrice;
    }

    public void setDistPrice(double distPrice) {
        this.distPrice = distPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public double getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(double deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public double getVipPrice1() {
        return vipPrice1;
    }

    public void setVipPrice1(double vipPrice1) {
        this.vipPrice1 = vipPrice1;
    }

    public double getVipPrice2() {
        return vipPrice2;
    }

    public void setVipPrice2(double vipPrice2) {
        this.vipPrice2 = vipPrice2;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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

    public static final class Builder {
        private long vendorId;
        private String storeCode;
        private String skuCode;
        private String plusCode;
        private int unitType;
        private String unit;
        private double unitNum;
        private double salePrice;
        private double weiPrice;
        private double distPrice;
        private double purchasePrice;
        private double wholesalePrice;
        private double deliverPrice;
        private double vipPrice;
        private double vipPrice1;
        private double vipPrice2;
        private double lowPrice;
        private double score;
        private int df;
        private String createDate;
        private String modifyDate;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder storeCode(String val) {
            storeCode = val;
            return this;
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public Builder plusCode(String val) {
            plusCode = val;
            return this;
        }

        public Builder unitType(int val) {
            unitType = val;
            return this;
        }

        public Builder unit(String val) {
            unit = val;
            return this;
        }

        public Builder unitNum(double val) {
            unitNum = val;
            return this;
        }

        public Builder salePrice(double val) {
            salePrice = val;
            return this;
        }

        public Builder weiPrice(double val) {
            weiPrice = val;
            return this;
        }

        public Builder distPrice(double val) {
            distPrice = val;
            return this;
        }

        public Builder purchasePrice(double val) {
            purchasePrice = val;
            return this;
        }

        public Builder wholesalePrice(double val) {
            wholesalePrice = val;
            return this;
        }

        public Builder deliverPrice(double val) {
            deliverPrice = val;
            return this;
        }

        public Builder vipPrice(double val) {
            vipPrice = val;
            return this;
        }

        public Builder vipPrice1(double val) {
            vipPrice1 = val;
            return this;
        }

        public Builder vipPrice2(double val) {
            vipPrice2 = val;
            return this;
        }

        public Builder lowPrice(double val) {
            lowPrice = val;
            return this;
        }

        public Builder score(double val) {
            score = val;
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

        public SkuUnit build() {
            return new SkuUnit(this);
        }
    }
}
