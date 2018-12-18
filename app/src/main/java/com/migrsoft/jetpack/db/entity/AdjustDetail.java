package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：调价单明细表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "adjustdetail",
        indices = {@Index(value = "vendorId"),
                @Index(value = "orderNo")})
public class AdjustDetail implements Parcelable {
    public static final Creator<AdjustDetail> CREATOR = new Creator<AdjustDetail>() {
        @Override
        public AdjustDetail createFromParcel(Parcel source) {
            return new AdjustDetail(source);
        }

        @Override
        public AdjustDetail[] newArray(int size) {
            return new AdjustDetail[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;//记录ID
    private long uid;
    private long vendorId;//所属商家ID
    private String orderNo;//总部编码
    private String skuCode;//商品编码
    private String skuName;//商品名称
    private String unit;//单位
    private int unitType;//单位类型 0库存单位 1辅助单位一 2其他辅助单位
    private double purchasePrice;//进货价
    private double salePrice;//零售价
    private double deliverPrice;//配送价
    private double wholesalePrice;//批发价
    private double distPrice;//分销价
    private double lowPrice;//最低价
    private double vipPrice;//会员价
    private double vipPrice1;//会员价1
    private double vipPrice2;//会员价2
    private double purchasePriceNew;//新进货价
    private double salePriceNew;//新零售价
    private double deliverPriceNew;//新配送价
    private double wholesalePriceNew;//新批发价
    private double lowPriceNew;//新最低价
    private double vipPriceNew;//新会员价
    private double vipPrice1New;//新会员价1
    private double vipPrice2New;//新会员价2
    private int viewOrder;//显示顺序
    private String memo;//备注
    private int df;//是否已删除1删除 0正常
    private String createDate;//创建日期
    private String modifyDate;//修改日期
    private String barcode;//国际条形码
    private double weiPrice;//微店价
    private double weiPriceNew;//新微店价
    private double distPriceNew;//新分销价
    private String pluCode;//PLU码
    private String shortName;//商品简称
    private String location;//产地
    private String brandCode;//品牌编码
    private String brandName;//品牌名称
    private String icatCode;//商家品类编码
    private String icatName;//
    private int saleType;// 计价方式0普通 1记重 2记时 3记数
    private int skuStatus;//生命周期：0正常 1停购 2停售 3淘汰 4归档 5新品 6建档
    private double oldPrice;//旧价格
    private double newPrice;//新价格

    private AdjustDetail(Builder builder) {
        uid = builder.uid;
        vendorId = builder.vendorId;
        orderNo = builder.orderNo;
        skuCode = builder.skuCode;
        skuName = builder.skuName;
        unit = builder.unit;
        unitType = builder.unitType;
        purchasePrice = builder.purchasePrice;
        salePrice = builder.salePrice;
        deliverPrice = builder.deliverPrice;
        wholesalePrice = builder.wholesalePrice;
        distPrice = builder.distPrice;
        lowPrice = builder.lowPrice;
        vipPrice = builder.vipPrice;
        vipPrice1 = builder.vipPrice1;
        vipPrice2 = builder.vipPrice2;
        purchasePriceNew = builder.purchasePriceNew;
        salePriceNew = builder.salePriceNew;
        deliverPriceNew = builder.deliverPriceNew;
        wholesalePriceNew = builder.wholesalePriceNew;
        lowPriceNew = builder.lowPriceNew;
        vipPriceNew = builder.vipPriceNew;
        vipPrice1New = builder.vipPrice1New;
        vipPrice2New = builder.vipPrice2New;
        viewOrder = builder.viewOrder;
        memo = builder.memo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        barcode = builder.barcode;
        weiPrice = builder.weiPrice;
        weiPriceNew = builder.weiPriceNew;
        distPriceNew = builder.distPriceNew;
        pluCode = builder.pluCode;
        shortName = builder.shortName;
        location = builder.location;
        brandCode = builder.brandCode;
        brandName = builder.brandName;
        icatCode = builder.icatCode;
        icatName = builder.icatName;
        saleType = builder.saleType;
        skuStatus = builder.skuStatus;
        oldPrice = builder.oldPrice;
        newPrice = builder.newPrice;
    }

    public AdjustDetail() {
    }

    protected AdjustDetail(Parcel in) {
        this.id = in.readLong();
        this.uid = in.readLong();
        this.vendorId = in.readLong();
        this.orderNo = in.readString();
        this.skuCode = in.readString();
        this.skuName = in.readString();
        this.unit = in.readString();
        this.unitType = in.readInt();
        this.purchasePrice = in.readDouble();
        this.salePrice = in.readDouble();
        this.deliverPrice = in.readDouble();
        this.wholesalePrice = in.readDouble();
        this.distPrice = in.readDouble();
        this.lowPrice = in.readDouble();
        this.vipPrice = in.readDouble();
        this.vipPrice1 = in.readDouble();
        this.vipPrice2 = in.readDouble();
        this.purchasePriceNew = in.readDouble();
        this.salePriceNew = in.readDouble();
        this.deliverPriceNew = in.readDouble();
        this.wholesalePriceNew = in.readDouble();
        this.lowPriceNew = in.readDouble();
        this.vipPriceNew = in.readDouble();
        this.vipPrice1New = in.readDouble();
        this.vipPrice2New = in.readDouble();
        this.viewOrder = in.readInt();
        this.memo = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.barcode = in.readString();
        this.weiPrice = in.readDouble();
        this.weiPriceNew = in.readDouble();
        this.distPriceNew = in.readDouble();
        this.pluCode = in.readString();
        this.shortName = in.readString();
        this.location = in.readString();
        this.brandCode = in.readString();
        this.brandName = in.readString();
        this.icatCode = in.readString();
        this.icatName = in.readString();
        this.saleType = in.readInt();
        this.skuStatus = in.readInt();
        this.oldPrice = in.readDouble();
        this.newPrice = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.uid);
        dest.writeLong(this.vendorId);
        dest.writeString(this.orderNo);
        dest.writeString(this.skuCode);
        dest.writeString(this.skuName);
        dest.writeString(this.unit);
        dest.writeInt(this.unitType);
        dest.writeDouble(this.purchasePrice);
        dest.writeDouble(this.salePrice);
        dest.writeDouble(this.deliverPrice);
        dest.writeDouble(this.wholesalePrice);
        dest.writeDouble(this.distPrice);
        dest.writeDouble(this.lowPrice);
        dest.writeDouble(this.vipPrice);
        dest.writeDouble(this.vipPrice1);
        dest.writeDouble(this.vipPrice2);
        dest.writeDouble(this.purchasePriceNew);
        dest.writeDouble(this.salePriceNew);
        dest.writeDouble(this.deliverPriceNew);
        dest.writeDouble(this.wholesalePriceNew);
        dest.writeDouble(this.lowPriceNew);
        dest.writeDouble(this.vipPriceNew);
        dest.writeDouble(this.vipPrice1New);
        dest.writeDouble(this.vipPrice2New);
        dest.writeInt(this.viewOrder);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeString(this.barcode);
        dest.writeDouble(this.weiPrice);
        dest.writeDouble(this.weiPriceNew);
        dest.writeDouble(this.distPriceNew);
        dest.writeString(this.pluCode);
        dest.writeString(this.shortName);
        dest.writeString(this.location);
        dest.writeString(this.brandCode);
        dest.writeString(this.brandName);
        dest.writeString(this.icatCode);
        dest.writeString(this.icatName);
        dest.writeInt(this.saleType);
        dest.writeInt(this.skuStatus);
        dest.writeDouble(this.oldPrice);
        dest.writeDouble(this.newPrice);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {

        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(double deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public double getDistPrice() {
        return distPrice;
    }

    public void setDistPrice(double distPrice) {
        this.distPrice = distPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
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

    public double getPurchasePriceNew() {
        return purchasePriceNew;
    }

    public void setPurchasePriceNew(double purchasePriceNew) {
        this.purchasePriceNew = purchasePriceNew;
    }

    public double getSalePriceNew() {
        return salePriceNew;
    }

    public void setSalePriceNew(double salePriceNew) {
        this.salePriceNew = salePriceNew;
    }

    public double getDeliverPriceNew() {
        return deliverPriceNew;
    }

    public void setDeliverPriceNew(double deliverPriceNew) {
        this.deliverPriceNew = deliverPriceNew;
    }

    public double getWholesalePriceNew() {
        return wholesalePriceNew;
    }

    public void setWholesalePriceNew(double wholesalePriceNew) {
        this.wholesalePriceNew = wholesalePriceNew;
    }

    public double getLowPriceNew() {
        return lowPriceNew;
    }

    public void setLowPriceNew(double lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    public double getVipPriceNew() {
        return vipPriceNew;
    }

    public void setVipPriceNew(double vipPriceNew) {
        this.vipPriceNew = vipPriceNew;
    }

    public double getVipPrice1New() {
        return vipPrice1New;
    }

    public void setVipPrice1New(double vipPrice1New) {
        this.vipPrice1New = vipPrice1New;
    }

    public double getVipPrice2New() {
        return vipPrice2New;
    }

    public void setVipPrice2New(double vipPrice2New) {
        this.vipPrice2New = vipPrice2New;
    }

    public int getViewOrder() {
        return viewOrder;
    }

    public void setViewOrder(int viewOrder) {
        this.viewOrder = viewOrder;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getWeiPrice() {
        return weiPrice;
    }

    public void setWeiPrice(double weiPrice) {
        this.weiPrice = weiPrice;
    }

    public double getWeiPriceNew() {
        return weiPriceNew;
    }

    public void setWeiPriceNew(double weiPriceNew) {
        this.weiPriceNew = weiPriceNew;
    }

    public double getDistPriceNew() {
        return distPriceNew;
    }

    public void setDistPriceNew(double distPriceNew) {
        this.distPriceNew = distPriceNew;
    }

    public String getPluCode() {
        return pluCode;
    }

    public void setPluCode(String pluCode) {
        this.pluCode = pluCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getIcatCode() {
        return icatCode;
    }

    public void setIcatCode(String icatCode) {
        this.icatCode = icatCode;
    }

    public String getIcatName() {
        return icatName;
    }

    public void setIcatName(String icatName) {
        this.icatName = icatName;
    }

    public int getSaleType() {
        return saleType;
    }

    public void setSaleType(int saleType) {
        this.saleType = saleType;
    }

    public int getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(int skuStatus) {
        this.skuStatus = skuStatus;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public static final class Builder {
        private long uid;
        private long vendorId;
        private String orderNo;
        private String skuCode;
        private String skuName;
        private String unit;
        private int unitType;
        private double purchasePrice;
        private double salePrice;
        private double deliverPrice;
        private double wholesalePrice;
        private double distPrice;
        private double lowPrice;
        private double vipPrice;
        private double vipPrice1;
        private double vipPrice2;
        private double purchasePriceNew;
        private double salePriceNew;
        private double deliverPriceNew;
        private double wholesalePriceNew;
        private double lowPriceNew;
        private double vipPriceNew;
        private double vipPrice1New;
        private double vipPrice2New;
        private int viewOrder;
        private String memo;
        private int df;
        private String createDate;
        private String modifyDate;
        private String barcode;
        private double weiPrice;
        private double weiPriceNew;
        private double distPriceNew;
        private String pluCode;
        private String shortName;
        private String location;
        private String brandCode;
        private String brandName;
        private String icatCode;
        private String icatName;
        private int saleType;
        private int skuStatus;
        private double oldPrice;
        private double newPrice;

        public Builder() {
        }

        public Builder uid(long val) {
            uid = val;
            return this;
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder orderNo(String val) {
            orderNo = val;
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

        public Builder unit(String val) {
            unit = val;
            return this;
        }

        public Builder unitType(int val) {
            unitType = val;
            return this;
        }

        public Builder purchasePrice(double val) {
            purchasePrice = val;
            return this;
        }

        public Builder salePrice(double val) {
            salePrice = val;
            return this;
        }

        public Builder deliverPrice(double val) {
            deliverPrice = val;
            return this;
        }

        public Builder wholesalePrice(double val) {
            wholesalePrice = val;
            return this;
        }

        public Builder distPrice(double val) {
            distPrice = val;
            return this;
        }

        public Builder lowPrice(double val) {
            lowPrice = val;
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

        public Builder purchasePriceNew(double val) {
            purchasePriceNew = val;
            return this;
        }

        public Builder salePriceNew(double val) {
            salePriceNew = val;
            return this;
        }

        public Builder deliverPriceNew(double val) {
            deliverPriceNew = val;
            return this;
        }

        public Builder wholesalePriceNew(double val) {
            wholesalePriceNew = val;
            return this;
        }

        public Builder lowPriceNew(double val) {
            lowPriceNew = val;
            return this;
        }

        public Builder vipPriceNew(double val) {
            vipPriceNew = val;
            return this;
        }

        public Builder vipPrice1New(double val) {
            vipPrice1New = val;
            return this;
        }

        public Builder vipPrice2New(double val) {
            vipPrice2New = val;
            return this;
        }

        public Builder viewOrder(int val) {
            viewOrder = val;
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

        public Builder barcode(String val) {
            barcode = val;
            return this;
        }

        public Builder weiPrice(double val) {
            weiPrice = val;
            return this;
        }

        public Builder weiPriceNew(double val) {
            weiPriceNew = val;
            return this;
        }

        public Builder distPriceNew(double val) {
            distPriceNew = val;
            return this;
        }

        public Builder pluCode(String val) {
            pluCode = val;
            return this;
        }

        public Builder shortName(String val) {
            shortName = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
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

        public Builder icatCode(String val) {
            icatCode = val;
            return this;
        }

        public Builder icatName(String val) {
            icatName = val;
            return this;
        }

        public Builder saleType(int val) {
            saleType = val;
            return this;
        }

        public Builder skuStatus(int val) {
            skuStatus = val;
            return this;
        }

        public Builder oldPrice(double val) {
            oldPrice = val;
            return this;
        }

        public Builder newPrice(double val) {
            newPrice = val;
            return this;
        }

        public AdjustDetail build() {
            return new AdjustDetail(this);
        }
    }
}
