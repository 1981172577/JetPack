package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import com.migrsoft.jetpack.BuildConfig;
import com.migrsoft.jetpack.utils.AmountUtil;


/**
 * 简介：分店SKU商品价格表 分店商品
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "sku",
        indices = {@Index(value = "vendorId", name = "idx_storeSku_vendorId"),
                @Index(value = "skuCode", name = "idx_storeSku_skuCode"),
                @Index(value = "storeCode", name = "idx_storeSku_storeCode"),
                @Index(value = "barcode", name = "idx_storeSku_barcode"),
                @Index(value = {"firstIcatCode", "secondIcatCode", "thirdIcatCode", "fourthIcatCode"}, name = "idx_storeSku_catcode")})
public class Sku implements Parcelable, Cloneable {
    public static final Parcelable.Creator<Sku> CREATOR = new Parcelable.Creator<Sku>() {
        @Override
        public Sku createFromParcel(Parcel source) {
            return new Sku(source);
        }

        @Override
        public Sku[] newArray(int size) {
            return new Sku[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                   //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;             //  bigint(20) unsigned DEFAULT NULL COMMENT '所属商家ID',
    private String storeCode;          //  varchar(16) DEFAULT NULL COMMENT '分店编码',
    private String storeName;          //  varchar(64) DEFAULT NULL COMMENT '分店名称',
    private String skuCode;            //  varchar(16) DEFAULT NULL COMMENT 'SKU编码',
    private String skuName;            //  varchar(64) DEFAULT NULL COMMENT '商品名称',
    private String barcode;            //  varchar(16) DEFAULT NULL COMMENT '国际条形码',
    private String helpCode;           //  varchar(64) DEFAULT NULL COMMENT '助记码',
    private String stockUnit;          //  varchar(16) DEFAULT NULL COMMENT '库存单位',
    private int otherUnit;             //  tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有辅助单位 1是 0否',
    private String plusCode;           //  varchar(512) DEFAULT NULL COMMENT '库存单位的附加条码',
    private long firstCatCode;         //  bigint(16) DEFAULT NULL COMMENT '平台一级品类编码',
    private long secondCatCode;        //  bigint(16) DEFAULT NULL COMMENT '平台二级品类编码',
    private long thirdCatCode;         //  bigint(16) DEFAULT NULL COMMENT '平台三级品类编码',
    private long catCode;              //  bigint(20) NOT NULL COMMENT '所属平台品类编码',
    private String catName;            //  varchar(64) DEFAULT NULL COMMENT '平台品类名称',
    private String brandName;          //  varchar(64) DEFAULT NULL COMMENT '品牌名称',
    private String supName;            //  varchar(64) DEFAULT NULL COMMENT '供应商名称',
    private String icatName;           //  varchar(64) DEFAULT NULL COMMENT '商家品类名称',
    private String firstBrandCode;     //  varchar(16) DEFAULT NULL COMMENT '一级品牌编码',
    private String secondBrandCode;    //  varchar(16) DEFAULT NULL COMMENT '二级品牌编码',
    private String thirdBrandCode;     //  varchar(16) DEFAULT NULL COMMENT '三级品牌编码',
    private String brandCode;          //  varchar(16) NOT NULL COMMENT '所属品牌编码',
    private String supCode;            //  varchar(16) DEFAULT NULL COMMENT '供应商编码',
    private String firstIcatCode;      //  varchar(16) DEFAULT NULL COMMENT '商家一级品类编码',
    private String secondIcatCode;     //  varchar(16) DEFAULT NULL COMMENT '商家二级品类编码',
    private String thirdIcatCode;      //  varchar(16) DEFAULT NULL COMMENT '商家三级品类编码',
    private String fourthIcatCode;     //  varchar(16) DEFAULT NULL COMMENT '商家四级品类编码',
    private String fiveIcatCode;       //  varchar(16) DEFAULT NULL COMMENT '商家五级品类编码',
    private String icatCode;           //  varchar(16) DEFAULT NULL COMMENT '商家品类编码',
    private double purchasePrice;      //  double(16,5) DEFAULT NULL COMMENT '进货价',
    private double salePrice;          //  double(16,5) DEFAULT NULL COMMENT '零售价',
    private double deliverPrice;       //  double(16,5) DEFAULT NULL COMMENT '配送价',
    private double weiPrice;           //  double(16,5) DEFAULT NULL COMMENT '微店价',
    private double distPrice;          //  double(16,5) DEFAULT NULL COMMENT '分销价',
    private double wholesalePrice;     //  double(16,5) DEFAULT NULL COMMENT '批发价',
    private double lowPrice;           //  double(16,5) DEFAULT NULL COMMENT '最低价',
    private double vipPrice;           //  double(16,5) DEFAULT NULL COMMENT '会员价',
    private double vipPrice1;          //  double(16,5) DEFAULT NULL COMMENT '会员价1',
    private double vipPrice2;          //  double(16,5) DEFAULT NULL COMMENT '会员价2',
    private int doBargain;             //  tinyint(4) DEFAULT NULL COMMENT '前台议价1是 0否',
    private int doDiscount;            //  tinyint(4) DEFAULT NULL COMMENT '前台打折1是 0否',
    private int doPresent;             //  tinyint(4) DEFAULT NULL COMMENT '前台赠送1是 0否',
    private int skuStatus;             //  tinyint(4) DEFAULT '0' COMMENT '商品状态：0正常 1停购 2停售 3淘汰 4禁用 5新品',
    private int ecomStatus;            //  tinyint(4) DEFAULT NULL COMMENT '是否允许销售 1表示允许 0表示不允许',
    private String memo;               //  varchar(32) DEFAULT NULL COMMENT '备注',
    private String specMemo;           //  varchar(64) DEFAULT NULL COMMENT '规格描述',
    private int validDays;             //  int(20) DEFAULT NULL COMMENT '保质期',
    private String location;           //  varchar(32) DEFAULT NULL,
    private int df;                    //  tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;         //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;         //  datetime NOT NULL COMMENT '修改日期',
    private int version;               //  int(10) unsigned DEFAULT '0' COMMENT '数据版本',
    private int doScore;               //  tinyint(4) DEFAULT NULL COMMENT '是否积分 1是 0否',
    private double score;              //  double(16,5) DEFAULT NULL COMMENT '积分值',
    private int feeType;               //  tinyint(4) DEFAULT NULL COMMENT '0按百分比扣点 1按单品扣款',
    private double fee;                //  double(16,5) DEFAULT NULL COMMENT '佣金扣点/扣款 扣点 % 按商品价格百分比 扣款按商品单价扣固\r\n\r\n定金额',
    private int chargeType;            //  tinyint(4) DEFAULT NULL COMMENT '0按百分比扣点 1按单品扣款',
    private double charge;             //  double(16,5) DEFAULT NULL COMMENT '与佣金计算类似',
    private String itemCode;           //  varchar(16) DEFAULT NULL COMMENT '商品编码',
    private int itemType;              //  tinyint(4) DEFAULT '0' COMMENT '商品类型：0普通商品 1制单组合 2制单拆分 3捆绑 4自动转货 5自动加工',
    private int bizType;               //  int(10) DEFAULT NULL COMMENT '0购销 1联营 2代销 3租赁 4扣率代销',
    private int saleType;              //  tinyint(4) DEFAULT NULL COMMENT '计价方式0普通 1记重 2记时 3记数',
    private String attrOne;            //  varchar(32) DEFAULT NULL COMMENT '属性名称1',
    private String attrTwo;            //  varchar(32) DEFAULT NULL COMMENT '属性名称2',
    private String attrThree;          //  varchar(32) DEFAULT NULL COMMENT '属性名称3',
    private String attrOneValue;       //  varchar(64) DEFAULT NULL COMMENT '属性值1',
    private String attrTwoValue;       //  varchar(64) DEFAULT NULL COMMENT '属性值2',
    private String attrThreeValue;     //  varchar(64) DEFAULT NULL COMMENT '属性值2',
    private String imgPathOne;         //  varchar(128) DEFAULT NULL COMMENT '图片访问地址1',
    private String imgPathTwo;         //  varchar(128) DEFAULT NULL COMMENT '图片访问地址2',
    private String imgPathThree;       //  varchar(128) DEFAULT NULL COMMENT '图片访问地址3',
    private String pluCode;            //  varchar(16) DEFAULT NULL,
    private double purchaseTax;        //  double(16,5) DEFAULT NULL COMMENT '进价税',
    private double saleTax;            //  double(16,5) DEFAULT NULL COMMENT '销价税',
    private double discount;           //  double(16,5) DEFAULT '0.00000' COMMENT '联营扣率(%)',
    private int mangeStock;            //  tinyint(4) NOT NULL DEFAULT '0',

    @Ignore
    private double count;  //mobile手持收银选商品数量
    @Ignore
    private boolean show; //mobile手持收银选商品是否显示
    private String posCatCode;//mobile手持收银类别

    private Sku(Builder builder) {
        vendorId = builder.vendorId;
        storeCode = builder.storeCode;
        storeName = builder.storeName;
        skuCode = builder.skuCode;
        skuName = builder.skuName;
        barcode = builder.barcode;
        helpCode = builder.helpCode;
        stockUnit = builder.stockUnit;
        otherUnit = builder.otherUnit;
        plusCode = builder.plusCode;
        firstCatCode = builder.firstCatCode;
        secondCatCode = builder.secondCatCode;
        thirdCatCode = builder.thirdCatCode;
        catCode = builder.catCode;
        catName = builder.catName;
        brandName = builder.brandName;
        supName = builder.supName;
        icatName = builder.icatName;
        firstBrandCode = builder.firstBrandCode;
        secondBrandCode = builder.secondBrandCode;
        thirdBrandCode = builder.thirdBrandCode;
        brandCode = builder.brandCode;
        supCode = builder.supCode;
        firstIcatCode = builder.firstIcatCode;
        secondIcatCode = builder.secondIcatCode;
        thirdIcatCode = builder.thirdIcatCode;
        fourthIcatCode = builder.fourthIcatCode;
        fiveIcatCode = builder.fiveIcatCode;
        icatCode = builder.icatCode;
        purchasePrice = builder.purchasePrice;
        salePrice = builder.salePrice;
        deliverPrice = builder.deliverPrice;
        weiPrice = builder.weiPrice;
        distPrice = builder.distPrice;
        wholesalePrice = builder.wholesalePrice;
        lowPrice = builder.lowPrice;
        vipPrice = builder.vipPrice;
        vipPrice1 = builder.vipPrice1;
        vipPrice2 = builder.vipPrice2;
        doBargain = builder.doBargain;
        doDiscount = builder.doDiscount;
        doPresent = builder.doPresent;
        skuStatus = builder.skuStatus;
        ecomStatus = builder.ecomStatus;
        memo = builder.memo;
        specMemo = builder.specMemo;
        validDays = builder.validDays;
        location = builder.location;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        doScore = builder.doScore;
        score = builder.score;
        feeType = builder.feeType;
        fee = builder.fee;
        chargeType = builder.chargeType;
        charge = builder.charge;
        itemCode = builder.itemCode;
        itemType = builder.itemType;
        bizType = builder.bizType;
        saleType = builder.saleType;
        attrOne = builder.attrOne;
        attrTwo = builder.attrTwo;
        attrThree = builder.attrThree;
        attrOneValue = builder.attrOneValue;
        attrTwoValue = builder.attrTwoValue;
        attrThreeValue = builder.attrThreeValue;
        imgPathOne = builder.imgPathOne;
        imgPathTwo = builder.imgPathTwo;
        imgPathThree = builder.imgPathThree;
        pluCode = builder.pluCode;
        purchaseTax = builder.purchaseTax;
        saleTax = builder.saleTax;
        discount = builder.discount;
        mangeStock = builder.mangeStock;
        count = builder.count;
        posCatCode = builder.posCatCode;
        show = builder.show;
    }

    public Sku() {
    }

    protected Sku(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.skuCode = in.readString();
        this.skuName = in.readString();
        this.barcode = in.readString();
        this.helpCode = in.readString();
        this.stockUnit = in.readString();
        this.otherUnit = in.readInt();
        this.plusCode = in.readString();
        this.firstCatCode = in.readLong();
        this.secondCatCode = in.readLong();
        this.thirdCatCode = in.readLong();
        this.catCode = in.readLong();
        this.catName = in.readString();
        this.brandName = in.readString();
        this.supName = in.readString();
        this.icatName = in.readString();
        this.firstBrandCode = in.readString();
        this.secondBrandCode = in.readString();
        this.thirdBrandCode = in.readString();
        this.brandCode = in.readString();
        this.supCode = in.readString();
        this.firstIcatCode = in.readString();
        this.secondIcatCode = in.readString();
        this.thirdIcatCode = in.readString();
        this.fourthIcatCode = in.readString();
        this.fiveIcatCode = in.readString();
        this.icatCode = in.readString();
        this.purchasePrice = in.readDouble();
        this.salePrice = in.readDouble();
        this.deliverPrice = in.readDouble();
        this.weiPrice = in.readDouble();
        this.distPrice = in.readDouble();
        this.wholesalePrice = in.readDouble();
        this.lowPrice = in.readDouble();
        this.vipPrice = in.readDouble();
        this.vipPrice1 = in.readDouble();
        this.vipPrice2 = in.readDouble();
        this.doBargain = in.readInt();
        this.doDiscount = in.readInt();
        this.doPresent = in.readInt();
        this.skuStatus = in.readInt();
        this.ecomStatus = in.readInt();
        this.memo = in.readString();
        this.specMemo = in.readString();
        this.validDays = in.readInt();
        this.location = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.doScore = in.readInt();
        this.score = in.readDouble();
        this.feeType = in.readInt();
        this.fee = in.readDouble();
        this.chargeType = in.readInt();
        this.charge = in.readDouble();
        this.itemCode = in.readString();
        this.itemType = in.readInt();
        this.bizType = in.readInt();
        this.saleType = in.readInt();
        this.attrOne = in.readString();
        this.attrTwo = in.readString();
        this.attrThree = in.readString();
        this.attrOneValue = in.readString();
        this.attrTwoValue = in.readString();
        this.attrThreeValue = in.readString();
        this.imgPathOne = in.readString();
        this.imgPathTwo = in.readString();
        this.imgPathThree = in.readString();
        this.pluCode = in.readString();
        this.purchaseTax = in.readDouble();
        this.saleTax = in.readDouble();
        this.discount = in.readDouble();
        this.mangeStock = in.readInt();
        this.count = in.readDouble();
        this.posCatCode = in.readString();
        this.show = in.readByte() != 0;
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
        dest.writeString(this.storeName);
        dest.writeString(this.skuCode);
        dest.writeString(this.skuName);
        dest.writeString(this.barcode);
        dest.writeString(this.helpCode);
        dest.writeString(this.stockUnit);
        dest.writeInt(this.otherUnit);
        dest.writeString(this.plusCode);
        dest.writeLong(this.firstCatCode);
        dest.writeLong(this.secondCatCode);
        dest.writeLong(this.thirdCatCode);
        dest.writeLong(this.catCode);
        dest.writeString(this.catName);
        dest.writeString(this.brandName);
        dest.writeString(this.supName);
        dest.writeString(this.icatName);
        dest.writeString(this.firstBrandCode);
        dest.writeString(this.secondBrandCode);
        dest.writeString(this.thirdBrandCode);
        dest.writeString(this.brandCode);
        dest.writeString(this.supCode);
        dest.writeString(this.firstIcatCode);
        dest.writeString(this.secondIcatCode);
        dest.writeString(this.thirdIcatCode);
        dest.writeString(this.fourthIcatCode);
        dest.writeString(this.fiveIcatCode);
        dest.writeString(this.icatCode);
        dest.writeDouble(this.purchasePrice);
        dest.writeDouble(this.salePrice);
        dest.writeDouble(this.deliverPrice);
        dest.writeDouble(this.weiPrice);
        dest.writeDouble(this.distPrice);
        dest.writeDouble(this.wholesalePrice);
        dest.writeDouble(this.lowPrice);
        dest.writeDouble(this.vipPrice);
        dest.writeDouble(this.vipPrice1);
        dest.writeDouble(this.vipPrice2);
        dest.writeInt(this.doBargain);
        dest.writeInt(this.doDiscount);
        dest.writeInt(this.doPresent);
        dest.writeInt(this.skuStatus);
        dest.writeInt(this.ecomStatus);
        dest.writeString(this.memo);
        dest.writeString(this.specMemo);
        dest.writeInt(this.validDays);
        dest.writeString(this.location);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeInt(this.doScore);
        dest.writeDouble(this.score);
        dest.writeInt(this.feeType);
        dest.writeDouble(this.fee);
        dest.writeInt(this.chargeType);
        dest.writeDouble(this.charge);
        dest.writeString(this.itemCode);
        dest.writeInt(this.itemType);
        dest.writeInt(this.bizType);
        dest.writeInt(this.saleType);
        dest.writeString(this.attrOne);
        dest.writeString(this.attrTwo);
        dest.writeString(this.attrThree);
        dest.writeString(this.attrOneValue);
        dest.writeString(this.attrTwoValue);
        dest.writeString(this.attrThreeValue);
        dest.writeString(this.imgPathOne);
        dest.writeString(this.imgPathTwo);
        dest.writeString(this.imgPathThree);
        dest.writeString(this.pluCode);
        dest.writeDouble(this.purchaseTax);
        dest.writeDouble(this.saleTax);
        dest.writeDouble(this.discount);
        dest.writeInt(this.mangeStock);
        dest.writeDouble(this.count);
        dest.writeString(this.posCatCode);
        dest.writeByte(this.show ? (byte) 1 : (byte) 0);
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public int getOtherUnit() {
        return otherUnit;
    }

    public void setOtherUnit(int otherUnit) {
        this.otherUnit = otherUnit;
    }

    public String getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(String plusCode) {
        this.plusCode = plusCode;
    }

    public long getFirstCatCode() {
        return firstCatCode;
    }

    public void setFirstCatCode(long firstCatCode) {
        this.firstCatCode = firstCatCode;
    }

    public long getSecondCatCode() {
        return secondCatCode;
    }

    public void setSecondCatCode(long secondCatCode) {
        this.secondCatCode = secondCatCode;
    }

    public long getThirdCatCode() {
        return thirdCatCode;
    }

    public void setThirdCatCode(long thirdCatCode) {
        this.thirdCatCode = thirdCatCode;
    }

    public long getCatCode() {
        return catCode;
    }

    public void setCatCode(long catCode) {
        this.catCode = catCode;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getIcatName() {
        return icatName;
    }

    public void setIcatName(String icatName) {
        this.icatName = icatName;
    }

    public String getFirstBrandCode() {
        return firstBrandCode;
    }

    public void setFirstBrandCode(String firstBrandCode) {
        this.firstBrandCode = firstBrandCode;
    }

    public String getSecondBrandCode() {
        return secondBrandCode;
    }

    public void setSecondBrandCode(String secondBrandCode) {
        this.secondBrandCode = secondBrandCode;
    }

    public String getThirdBrandCode() {
        return thirdBrandCode;
    }

    public void setThirdBrandCode(String thirdBrandCode) {
        this.thirdBrandCode = thirdBrandCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getFirstIcatCode() {
        return firstIcatCode;
    }

    public void setFirstIcatCode(String firstIcatCode) {
        this.firstIcatCode = firstIcatCode;
    }

    public String getSecondIcatCode() {
        return secondIcatCode;
    }

    public void setSecondIcatCode(String secondIcatCode) {
        this.secondIcatCode = secondIcatCode;
    }

    public String getThirdIcatCode() {
        return thirdIcatCode;
    }

    public void setThirdIcatCode(String thirdIcatCode) {
        this.thirdIcatCode = thirdIcatCode;
    }

    public String getFourthIcatCode() {
        return fourthIcatCode;
    }

    public void setFourthIcatCode(String fourthIcatCode) {
        this.fourthIcatCode = fourthIcatCode;
    }

    public String getFiveIcatCode() {
        return fiveIcatCode;
    }

    public void setFiveIcatCode(String fiveIcatCode) {
        this.fiveIcatCode = fiveIcatCode;
    }

    public String getIcatCode() {
        return icatCode;
    }

    public void setIcatCode(String icatCode) {
        this.icatCode = icatCode;
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

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
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

    public int getDoBargain() {
        return doBargain;
    }

    public void setDoBargain(int doBargain) {
        this.doBargain = doBargain;
    }

    public int getDoDiscount() {
        return doDiscount;
    }

    public void setDoDiscount(int doDiscount) {
        this.doDiscount = doDiscount;
    }

    public int getDoPresent() {
        return doPresent;
    }

    public void setDoPresent(int doPresent) {
        this.doPresent = doPresent;
    }

    public int getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(int skuStatus) {
        this.skuStatus = skuStatus;
    }

    public int getEcomStatus() {
        return ecomStatus;
    }

    public void setEcomStatus(int ecomStatus) {
        this.ecomStatus = ecomStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSpecMemo() {
        return specMemo;
    }

    public void setSpecMemo(String specMemo) {
        this.specMemo = specMemo;
    }

    public int getValidDays() {
        return validDays;
    }

    public void setValidDays(int validDays) {
        this.validDays = validDays;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public int getDoScore() {
        return doScore;
    }

    public void setDoScore(int doScore) {
        this.doScore = doScore;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public int getSaleType() {
        return saleType;
    }

    public void setSaleType(int saleType) {
        this.saleType = saleType;
    }

    public String getAttrOne() {
        return attrOne;
    }

    public void setAttrOne(String attrOne) {
        this.attrOne = attrOne;
    }

    public String getAttrTwo() {
        return attrTwo;
    }

    public void setAttrTwo(String attrTwo) {
        this.attrTwo = attrTwo;
    }

    public String getAttrThree() {
        return attrThree;
    }

    public void setAttrThree(String attrThree) {
        this.attrThree = attrThree;
    }

    public String getAttrOneValue() {
        return attrOneValue;
    }

    public void setAttrOneValue(String attrOneValue) {
        this.attrOneValue = attrOneValue;
    }

    public String getAttrTwoValue() {
        return attrTwoValue;
    }

    public void setAttrTwoValue(String attrTwoValue) {
        this.attrTwoValue = attrTwoValue;
    }

    public String getAttrThreeValue() {
        return attrThreeValue;
    }

    public void setAttrThreeValue(String attrThreeValue) {
        this.attrThreeValue = attrThreeValue;
    }

    public String getImgPathOne() {
        return imgPathOne;
    }

    public void setImgPathOne(String imgPathOne) {
        this.imgPathOne = imgPathOne;
    }

    public String getImgPathTwo() {
        return imgPathTwo;
    }

    public void setImgPathTwo(String imgPathTwo) {
        this.imgPathTwo = imgPathTwo;
    }

    public String getImgPathThree() {
        return imgPathThree;
    }

    public void setImgPathThree(String imgPathThree) {
        this.imgPathThree = imgPathThree;
    }

    public String getPluCode() {
        return pluCode;
    }

    public void setPluCode(String pluCode) {
        this.pluCode = pluCode;
    }

    public double getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(double purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    public double getSaleTax() {
        return saleTax;
    }

    public void setSaleTax(double saleTax) {
        this.saleTax = saleTax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMangeStock() {
        return mangeStock;
    }

    public void setMangeStock(int mangeStock) {
        this.mangeStock = mangeStock;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getPosCatCode() {
        return posCatCode;
    }

    public void setPosCatCode(String posCatCode) {
        this.posCatCode = posCatCode;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    @Override
    public Object clone() {
        Sku sku = null;
        try {
            sku = (Sku) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sku;
    }

    public static final class Builder {
        private long vendorId;
        private String storeCode;
        private String storeName;
        private String skuCode;
        private String skuName;
        private String barcode;
        private String helpCode;
        private String stockUnit;
        private int otherUnit;
        private String plusCode;
        private long firstCatCode;
        private long secondCatCode;
        private long thirdCatCode;
        private long catCode;
        private String catName;
        private String brandName;
        private String supName;
        private String icatName;
        private String firstBrandCode;
        private String secondBrandCode;
        private String thirdBrandCode;
        private String brandCode;
        private String supCode;
        private String firstIcatCode;
        private String secondIcatCode;
        private String thirdIcatCode;
        private String fourthIcatCode;
        private String fiveIcatCode;
        private String icatCode;
        private double purchasePrice;
        private double salePrice;
        private double deliverPrice;
        private double weiPrice;
        private double distPrice;
        private double wholesalePrice;
        private double lowPrice;
        private double vipPrice;
        private double vipPrice1;
        private double vipPrice2;
        private int doBargain;
        private int doDiscount;
        private int doPresent;
        private int skuStatus;
        private int ecomStatus;
        private String memo;
        private String specMemo;
        private int validDays;
        private String location;
        private int df;
        private String createDate;
        private String modifyDate;
        private int version;
        private int doScore;
        private double score;
        private int feeType;
        private double fee;
        private int chargeType;
        private double charge;
        private String itemCode;
        private int itemType;
        private int bizType;
        private int saleType;
        private String attrOne;
        private String attrTwo;
        private String attrThree;
        private String attrOneValue;
        private String attrTwoValue;
        private String attrThreeValue;
        private String imgPathOne;
        private String imgPathTwo;
        private String imgPathThree;
        private String pluCode;
        private double purchaseTax;
        private double saleTax;
        private double discount;
        private int mangeStock;
        private double count;
        private String posCatCode;
        private boolean show;

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

        public Builder storeName(String val) {
            storeName = val;
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

        public Builder barcode(String val) {
            barcode = val;
            return this;
        }

        public Builder helpCode(String val) {
            helpCode = val;
            return this;
        }

        public Builder stockUnit(String val) {
            stockUnit = val;
            return this;
        }

        public Builder otherUnit(int val) {
            otherUnit = val;
            return this;
        }

        public Builder plusCode(String val) {
            plusCode = val;
            return this;
        }

        public Builder firstCatCode(long val) {
            firstCatCode = val;
            return this;
        }

        public Builder secondCatCode(long val) {
            secondCatCode = val;
            return this;
        }

        public Builder thirdCatCode(long val) {
            thirdCatCode = val;
            return this;
        }

        public Builder catCode(long val) {
            catCode = val;
            return this;
        }

        public Builder catName(String val) {
            catName = val;
            return this;
        }

        public Builder brandName(String val) {
            brandName = val;
            return this;
        }

        public Builder supName(String val) {
            supName = val;
            return this;
        }

        public Builder icatName(String val) {
            icatName = val;
            return this;
        }

        public Builder firstBrandCode(String val) {
            firstBrandCode = val;
            return this;
        }

        public Builder secondBrandCode(String val) {
            secondBrandCode = val;
            return this;
        }

        public Builder thirdBrandCode(String val) {
            thirdBrandCode = val;
            return this;
        }

        public Builder brandCode(String val) {
            brandCode = val;
            return this;
        }

        public Builder supCode(String val) {
            supCode = val;
            return this;
        }

        public Builder firstIcatCode(String val) {
            firstIcatCode = val;
            return this;
        }

        public Builder secondIcatCode(String val) {
            secondIcatCode = val;
            return this;
        }

        public Builder thirdIcatCode(String val) {
            thirdIcatCode = val;
            return this;
        }

        public Builder fourthIcatCode(String val) {
            fourthIcatCode = val;
            return this;
        }

        public Builder fiveIcatCode(String val) {
            fiveIcatCode = val;
            return this;
        }

        public Builder icatCode(String val) {
            icatCode = val;
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

        public Builder weiPrice(double val) {
            weiPrice = val;
            return this;
        }

        public Builder distPrice(double val) {
            distPrice = val;
            return this;
        }

        public Builder wholesalePrice(double val) {
            wholesalePrice = val;
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

        public Builder doBargain(int val) {
            doBargain = val;
            return this;
        }

        public Builder doDiscount(int val) {
            doDiscount = val;
            return this;
        }

        public Builder doPresent(int val) {
            doPresent = val;
            return this;
        }

        public Builder skuStatus(int val) {
            skuStatus = val;
            return this;
        }

        public Builder ecomStatus(int val) {
            ecomStatus = val;
            return this;
        }

        public Builder memo(String val) {
            memo = val;
            return this;
        }

        public Builder specMemo(String val) {
            specMemo = val;
            return this;
        }

        public Builder validDays(int val) {
            validDays = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
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

        public Builder doScore(int val) {
            doScore = val;
            return this;
        }

        public Builder score(double val) {
            score = val;
            return this;
        }

        public Builder feeType(int val) {
            feeType = val;
            return this;
        }

        public Builder fee(double val) {
            fee = val;
            return this;
        }

        public Builder chargeType(int val) {
            chargeType = val;
            return this;
        }

        public Builder charge(double val) {
            charge = val;
            return this;
        }

        public Builder itemCode(String val) {
            itemCode = val;
            return this;
        }

        public Builder itemType(int val) {
            itemType = val;
            return this;
        }

        public Builder bizType(int val) {
            bizType = val;
            return this;
        }

        public Builder saleType(int val) {
            saleType = val;
            return this;
        }

        public Builder attrOne(String val) {
            attrOne = val;
            return this;
        }

        public Builder attrTwo(String val) {
            attrTwo = val;
            return this;
        }

        public Builder attrThree(String val) {
            attrThree = val;
            return this;
        }

        public Builder attrOneValue(String val) {
            attrOneValue = val;
            return this;
        }

        public Builder attrTwoValue(String val) {
            attrTwoValue = val;
            return this;
        }

        public Builder attrThreeValue(String val) {
            attrThreeValue = val;
            return this;
        }

        public Builder imgPathOne(String val) {
            imgPathOne = val;
            return this;
        }

        public Builder imgPathTwo(String val) {
            imgPathTwo = val;
            return this;
        }

        public Builder imgPathThree(String val) {
            imgPathThree = val;
            return this;
        }

        public Builder pluCode(String val) {
            pluCode = val;
            return this;
        }

        public Builder purchaseTax(double val) {
            purchaseTax = val;
            return this;
        }

        public Builder saleTax(double val) {
            saleTax = val;
            return this;
        }

        public Builder discount(double val) {
            discount = val;
            return this;
        }

        public Builder mangeStock(int val) {
            mangeStock = val;
            return this;
        }

        public Builder count(double val) {
            count = val;
            return this;
        }

        public Builder posCatCode(String val) {
            posCatCode = val;
            return this;
        }

        public Builder show(boolean val) {
            show = val;
            return this;
        }

        public Sku build() {
            return new Sku(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sku sku = (Sku) o;

        if (skuCode != null ? !skuCode.equals(sku.skuCode) : sku.skuCode != null) return false;
        if (stockUnit != null ? !stockUnit.equals(sku.stockUnit) : sku.stockUnit != null) return false;
        if (plusCode != null ? !plusCode.equals(sku.plusCode) : sku.plusCode != null) return false;

        return true;
    }

    // ali pay self
    @Ignore
    private boolean selected;

}
