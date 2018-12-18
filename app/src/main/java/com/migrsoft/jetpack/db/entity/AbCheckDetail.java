package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "abcheckdetail",
        indices = {@Index(value = {"vendorId", "taskNo", "orderNo"})})
public class AbCheckDetail extends BaseEntity implements Parcelable {
    public static final Creator<AbCheckDetail> CREATOR = new Creator<AbCheckDetail>() {
        @Override
        public AbCheckDetail createFromParcel(Parcel source) {
            return new AbCheckDetail(source);
        }

        @Override
        public AbCheckDetail[] newArray(int size) {
            return new AbCheckDetail[size];
        }
    };
    private String taskNo;//盘点任务号
    private String orderNo;//录入单号
    private int orderType;//单据类型 0-条码板  1初盘A盘   2 初盘B盘  3复盘单
    private String shelfNo;//储位号
    private String shelfArea;//储位区域
    private String skuCode;//sku编码
    private String skuName;//sku名称
    @ColumnInfo(name = "barcode")
    private String barCode;//国际条码
    private String pluCode;//plu码
    private String specMemo;//规格
    private String skuUnit;//库存单位
    private double quantity;//盘点数量
    private String brandCode;//品牌编码
    private String brandName;//品牌名称
    private String firstIcatName;//商品部门名称
    private String firstIcatCode;//商品部门编码
    private String secondIcatName;///大类名称
    private String secondIcatCode;//大类编码
    private String checkMan;//盘点人
    private String checkNick;//盘点姓名
    private String version;//数据版本
    private String thirdIcatName;//中类名称 取自商品
    private String thirdIcatCode;//中类编码 取自商品
    private String fourthIcatName;//小类名称 取自商品
    private String fourthIcatcode;//小类编码 取自商品
    private double salePrice;
    private int rowIdx;//


    public AbCheckDetail() {
    }

    private AbCheckDetail(Builder builder) {
        id = builder.id;
        setVendorId(builder.vendorId);
        setTaskNo(builder.taskNo);
        setOrderNo(builder.orderNo);
        setOrderType(builder.orderType);
        setShelfNo(builder.shelfNo);
        setShelfArea(builder.shelfArea);
        setSkuCode(builder.skuCode);
        setSkuName(builder.skuName);
        setBarCode(builder.barCode);
        setPluCode(builder.pluCode);
        setSpecMemo(builder.specMemo);
        setSkuUnit(builder.skuUnit);
        setQuantity(builder.quantity);
        setBrandCode(builder.brandCode);
        setBrandName(builder.brandName);
        setFirstIcatName(builder.firstIcatName);
        setFirstIcatCode(builder.firstIcatCode);
        setSecondIcatName(builder.secondIcatName);
        setSecondIcatCode(builder.secondIcatCode);
        setCheckMan(builder.checkMan);
        setCheckNick(builder.checkNick);
        setDf(builder.df);
        setCreateDate(builder.createDate);
        setModifyDate(builder.modifyDate);
        setVersion(builder.version);
        setThirdIcatName(builder.thirdIcatName);
        setThirdIcatCode(builder.thirdIcatCode);
        setFourthIcatName(builder.fourthIcatName);
        setFourthIcatcode(builder.fourthIcatcode);
        setSalePrice(builder.salePrice);
        setRowIdx(builder.rowIdx);
    }

    protected AbCheckDetail(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.taskNo = in.readString();
        this.orderNo = in.readString();
        this.orderType = in.readInt();
        this.shelfNo = in.readString();
        this.shelfArea = in.readString();
        this.skuCode = in.readString();
        this.skuName = in.readString();
        this.barCode = in.readString();
        this.pluCode = in.readString();
        this.specMemo = in.readString();
        this.skuUnit = in.readString();
        this.quantity = in.readDouble();
        this.brandCode = in.readString();
        this.brandName = in.readString();
        this.firstIcatName = in.readString();
        this.firstIcatCode = in.readString();
        this.secondIcatName = in.readString();
        this.secondIcatCode = in.readString();
        this.checkMan = in.readString();
        this.checkNick = in.readString();
        this.df = in.readInt();
        this.createDate = in.readLong();
        this.modifyDate = in.readLong();
        this.version = in.readString();
        this.thirdIcatName = in.readString();
        this.thirdIcatCode = in.readString();
        this.fourthIcatName = in.readString();
        this.fourthIcatcode = in.readString();
        this.salePrice = in.readDouble();
        this.rowIdx = in.readInt();
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.taskNo);
        dest.writeString(this.orderNo);
        dest.writeInt(this.orderType);
        dest.writeString(this.shelfNo);
        dest.writeString(this.shelfArea);
        dest.writeString(this.skuCode);
        dest.writeString(this.skuName);
        dest.writeString(this.barCode);
        dest.writeString(this.pluCode);
        dest.writeString(this.specMemo);
        dest.writeString(this.skuUnit);
        dest.writeDouble(this.quantity);
        dest.writeString(this.brandCode);
        dest.writeString(this.brandName);
        dest.writeString(this.firstIcatName);
        dest.writeString(this.firstIcatCode);
        dest.writeString(this.secondIcatName);
        dest.writeString(this.secondIcatCode);
        dest.writeString(this.checkMan);
        dest.writeString(this.checkNick);
        dest.writeInt(this.df);
        dest.writeSerializable(this.createDate);
        dest.writeSerializable(this.modifyDate);
        dest.writeString(this.version);
        dest.writeString(this.thirdIcatName);
        dest.writeString(this.thirdIcatCode);
        dest.writeString(this.fourthIcatName);
        dest.writeString(this.fourthIcatcode);
        dest.writeDouble(this.salePrice);
        dest.writeInt(this.rowIdx);
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public String getShelfArea() {
        return shelfArea;
    }

    public void setShelfArea(String shelfArea) {
        this.shelfArea = shelfArea;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPluCode() {
        return pluCode;
    }

    public void setPluCode(String pluCode) {
        this.pluCode = pluCode;
    }

    public String getSpecMemo() {
        return specMemo;
    }

    public void setSpecMemo(String specMemo) {
        this.specMemo = specMemo;
    }

    public String getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(String skuUnit) {
        this.skuUnit = skuUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFirstIcatName() {
        return firstIcatName;
    }

    public void setFirstIcatName(String firstIcatName) {
        this.firstIcatName = firstIcatName;
    }

    public String getFirstIcatCode() {
        return firstIcatCode;
    }

    public void setFirstIcatCode(String firstIcatCode) {
        this.firstIcatCode = firstIcatCode;
    }

    public String getSecondIcatName() {
        return secondIcatName;
    }

    public void setSecondIcatName(String secondIcatName) {
        this.secondIcatName = secondIcatName;
    }

    public String getSecondIcatCode() {
        return secondIcatCode;
    }

    public void setSecondIcatCode(String secondIcatCode) {
        this.secondIcatCode = secondIcatCode;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    public String getCheckNick() {
        return checkNick;
    }

    public void setCheckNick(String checkNick) {
        this.checkNick = checkNick;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getThirdIcatName() {
        return thirdIcatName;
    }

    public void setThirdIcatName(String thirdIcatName) {
        this.thirdIcatName = thirdIcatName;
    }

    public String getThirdIcatCode() {
        return thirdIcatCode;
    }

    public void setThirdIcatCode(String thirdIcatCode) {
        this.thirdIcatCode = thirdIcatCode;
    }

    public String getFourthIcatName() {
        return fourthIcatName;
    }

    public void setFourthIcatName(String fourthIcatName) {
        this.fourthIcatName = fourthIcatName;
    }

    public String getFourthIcatcode() {
        return fourthIcatcode;
    }

    public void setFourthIcatcode(String fourthIcatcode) {
        this.fourthIcatcode = fourthIcatcode;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public void setRowIdx(int rowIdx) {
        this.rowIdx = rowIdx;
    }


    public static final class Builder {
        private long id;
        private long vendorId;
        private String taskNo;
        private String orderNo;
        private int orderType;
        private String shelfNo;
        private String shelfArea;
        private String skuCode;
        private String skuName;
        private String barCode;
        private String pluCode;
        private String specMemo;
        private String skuUnit;
        private double quantity;
        private String brandCode;
        private String brandName;
        private String firstIcatName;
        private String firstIcatCode;
        private String secondIcatName;
        private String secondIcatCode;
        private String checkMan;
        private String checkNick;
        private int df;
        private long createDate;
        private long modifyDate;
        private String version;
        private String thirdIcatName;
        private String thirdIcatCode;
        private String fourthIcatName;
        private String fourthIcatcode;
        private double salePrice;
        private int rowIdx;

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

        public Builder taskNo(String val) {
            taskNo = val;
            return this;
        }

        public Builder orderNo(String val) {
            orderNo = val;
            return this;
        }

        public Builder orderType(int val) {
            orderType = val;
            return this;
        }

        public Builder shelfNo(String val) {
            shelfNo = val;
            return this;
        }

        public Builder shelfArea(String val) {
            shelfArea = val;
            return this;
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public Builder skuName(String val) {
            skuName = val;
            return this;
        }

        public Builder barCode(String val) {
            barCode = val;
            return this;
        }

        public Builder pluCode(String val) {
            pluCode = val;
            return this;
        }

        public Builder specMemo(String val) {
            specMemo = val;
            return this;
        }

        public Builder skuUnit(String val) {
            skuUnit = val;
            return this;
        }

        public Builder quantity(double val) {
            quantity = val;
            return this;
        }

        public Builder brandCode(String val) {
            brandCode = val;
            return this;
        }

        public Builder brandName(String val) {
            brandName = val;
            return this;
        }

        public Builder firstIcatName(String val) {
            firstIcatName = val;
            return this;
        }

        public Builder firstIcatCode(String val) {
            firstIcatCode = val;
            return this;
        }

        public Builder secondIcatName(String val) {
            secondIcatName = val;
            return this;
        }

        public Builder secondIcatCode(String val) {
            secondIcatCode = val;
            return this;
        }

        public Builder checkMan(String val) {
            checkMan = val;
            return this;
        }

        public Builder checkNick(String val) {
            checkNick = val;
            return this;
        }

        public Builder df(int val) {
            df = val;
            return this;
        }

        public Builder createDate(long val) {
            createDate = val;
            return this;
        }

        public Builder modifyDate(long val) {
            modifyDate = val;
            return this;
        }

        public Builder version(String val) {
            version = val;
            return this;
        }

        public Builder thirdIcatName(String val) {
            thirdIcatName = val;
            return this;
        }

        public Builder thirdIcatCode(String val) {
            thirdIcatCode = val;
            return this;
        }

        public Builder fourthIcatName(String val) {
            fourthIcatName = val;
            return this;
        }

        public Builder fourthIcatcode(String val) {
            fourthIcatcode = val;
            return this;
        }

        public Builder salePrice(double val) {
            salePrice = val;
            return this;
        }

        public Builder rowIdx(int val) {
            rowIdx = val;
            return this;
        }

        public AbCheckDetail build() {
            return new AbCheckDetail(this);
        }
    }
}
