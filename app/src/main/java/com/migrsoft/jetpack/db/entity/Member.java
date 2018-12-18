package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：会员信息表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "member",
        indices = {@Index(value = "memPin", name = "idx_member_memPin", unique = true),
                @Index(value = "memNo", name = "idx_member_memNo"),
                @Index(value = "cardNo", name = "idx_member_cardNo"),
                @Index(value = "cardId", name = "idx_member_cardId")})
public class Member implements Parcelable, Cloneable {
    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            return new Member(source);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;          // bigint(20) unsigned NOT NULL COMMENT '会员来源商家ID',
    private String memNo;           // varchar(32) DEFAULT NULL COMMENT '会员号',
    private String memPin;          // varchar(64) DEFAULT NULL COMMENT '会员登录用户名',
    private String memPwd;          // varchar(32) DEFAULT NULL COMMENT '会员登录密码',
    private String organCode;       // varchar(16) DEFAULT NULL COMMENT '会员来源区域编码',
    private String organName;       // varchar(64) DEFAULT NULL COMMENT '会员来源区域名称',
    private String storeCode;       // varchar(16) DEFAULT NULL COMMENT '会员来源门店',
    private String storeName;       // varchar(64) DEFAULT NULL COMMENT '会员来源门店名称',
    private String wdStoreCode;     // varchar(16) DEFAULT NULL COMMENT '会员所属微店名称',
    private String memName;         // varchar(32) DEFAULT NULL COMMENT '会员姓名',
    private String nickName;        // varchar(32) DEFAULT NULL COMMENT '会员昵称',
    private String mobileNo;        // varchar(16) DEFAULT NULL COMMENT '会员手机号',
    private double balance;         // double(16,5) DEFAULT '0.00000' COMMENT '账户余额',
    private double memPoint;        // double(16,5) DEFAULT '0.00000' COMMENT '积分',
    private double consumeAmount;   // double(16,5) DEFAULT '0.00000' COMMENT '累计消费',
    private double presentAmount;   // double(16,5) DEFAULT '0.00000' COMMENT '累计赠送金额',
    private double rechargeAmount;  // double(16,5) DEFAULT '0.00000' COMMENT '累计充值金额',
    private double memPointAmount;  // double(16,5) DEFAULT '0.00000' COMMENT '累计积分',
    private double creditLine;      // double(16,5) DEFAULT '0.00000' COMMENT '信誉额度',
    private int status;             // tinyint(4) DEFAULT '0' COMMENT '0正常1冻结 2过期',
    private int needPwdFlag;        // tinyint(4) DEFAULT '0' COMMENT '0不需要密码 1表示需要密码',
    private int gender;             // tinyint(4) DEFAULT NULL COMMENT '性别 0女 1男',
    private String memCatCode;      // varchar(16) DEFAULT NULL COMMENT '会员类别',
    private String provinceCode;    // varchar(32) DEFAULT NULL COMMENT '省级编码',
    private String cityCode;        // varchar(32) DEFAULT NULL COMMENT '市级编码',
    private String regionCode;      // varchar(32) DEFAULT NULL COMMENT '地区编码',
    private String memAddress;      // varchar(128) DEFAULT NULL COMMENT '详细地址',
    private String birthday;        // datetime DEFAULT NULL COMMENT '会员生日',
    private String headImg;         // varchar(128) DEFAULT NULL COMMENT '头像图片url',
    private String wxAddress;       // varchar(128) DEFAULT NULL COMMENT '微信注册区域',
    private int df;                 // tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String memo;            // varchar(32) DEFAULT NULL COMMENT '备注',
    private String createDate;      // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;      // datetime NOT NULL COMMENT '修改日期',
    private String parentMemPin;    // varchar(64) DEFAULT NULL COMMENT '推荐会员pin',
    private String barCodeUrl;      // varchar(128) DEFAULT NULL COMMENT '会员一维码',
    private String QRCodeUrl;       // varchar(128) DEFAULT NULL COMMENT '会员二维码',
    private String QRCodeValue;     // varchar(32) DEFAULT NULL COMMENT '会员一维码，二维码值',
    private String cardNo;          // varchar(32) DEFAULT NULL COMMENT '储值卡号',
    private String cardId;          // varchar(32) DEFAULT NULL COMMENT '储值卡ID(磁条卡和IC卡可能cardid和cardno不一样)',
    private String unionid;         // varchar(64) DEFAULT NULL COMMENT '微信唯一标识',
    private String reference;       // varchar(16) DEFAULT NULL COMMENT '业务员(推荐人姓名)',
    private String memIDCardNo;     // varchar(32) DEFAULT NULL COMMENT '会员身份证号码',
    @Ignore
    private int onsaleType;
    @Ignore
    private double rate;

    public Member() {
    }


    private Member(Builder builder) {
        vendorId = builder.vendorId;
        memNo = builder.memNo;
        memPin = builder.memPin;
        memPwd = builder.memPwd;
        organCode = builder.organCode;
        organName = builder.organName;
        storeCode = builder.storeCode;
        storeName = builder.storeName;
        wdStoreCode = builder.wdStoreCode;
        memName = builder.memName;
        nickName = builder.nickName;
        mobileNo = builder.mobileNo;
        balance = builder.balance;
        memPoint = builder.memPoint;
        consumeAmount = builder.consumeAmount;
        presentAmount = builder.presentAmount;
        rechargeAmount = builder.rechargeAmount;
        memPointAmount = builder.memPointAmount;
        creditLine = builder.creditLine;
        status = builder.status;
        needPwdFlag = builder.needPwdFlag;
        gender = builder.gender;
        memCatCode = builder.memCatCode;
        provinceCode = builder.provinceCode;
        cityCode = builder.cityCode;
        regionCode = builder.regionCode;
        memAddress = builder.memAddress;
        birthday = builder.birthday;
        headImg = builder.headImg;
        wxAddress = builder.wxAddress;
        df = builder.df;
        memo = builder.memo;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        parentMemPin = builder.parentMemPin;
        barCodeUrl = builder.barCodeUrl;
        QRCodeUrl = builder.QRCodeUrl;
        QRCodeValue = builder.QRCodeValue;
        cardNo = builder.cardNo;
        cardId = builder.cardId;
        unionid = builder.unionid;
        reference = builder.reference;
        memIDCardNo = builder.memIDCardNo;
        onsaleType = builder.onsaleType;
        rate = builder.rate;
    }

    protected Member(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.memNo = in.readString();
        this.memPin = in.readString();
        this.memPwd = in.readString();
        this.organCode = in.readString();
        this.organName = in.readString();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.wdStoreCode = in.readString();
        this.memName = in.readString();
        this.nickName = in.readString();
        this.mobileNo = in.readString();
        this.balance = in.readDouble();
        this.memPoint = in.readDouble();
        this.consumeAmount = in.readDouble();
        this.presentAmount = in.readDouble();
        this.rechargeAmount = in.readDouble();
        this.memPointAmount = in.readDouble();
        this.creditLine = in.readDouble();
        this.status = in.readInt();
        this.needPwdFlag = in.readInt();
        this.gender = in.readInt();
        this.memCatCode = in.readString();
        this.provinceCode = in.readString();
        this.cityCode = in.readString();
        this.regionCode = in.readString();
        this.memAddress = in.readString();
        this.birthday = in.readString();
        this.headImg = in.readString();
        this.wxAddress = in.readString();
        this.df = in.readInt();
        this.memo = in.readString();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.parentMemPin = in.readString();
        this.barCodeUrl = in.readString();
        this.QRCodeUrl = in.readString();
        this.QRCodeValue = in.readString();
        this.cardNo = in.readString();
        this.cardId = in.readString();
        this.unionid = in.readString();
        this.reference = in.readString();
        this.memIDCardNo = in.readString();
        this.onsaleType = in.readInt();
        this.rate = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.memNo);
        dest.writeString(this.memPin);
        dest.writeString(this.memPwd);
        dest.writeString(this.organCode);
        dest.writeString(this.organName);
        dest.writeString(this.storeCode);
        dest.writeString(this.storeName);
        dest.writeString(this.wdStoreCode);
        dest.writeString(this.memName);
        dest.writeString(this.nickName);
        dest.writeString(this.mobileNo);
        dest.writeDouble(this.balance);
        dest.writeDouble(this.memPoint);
        dest.writeDouble(this.consumeAmount);
        dest.writeDouble(this.presentAmount);
        dest.writeDouble(this.rechargeAmount);
        dest.writeDouble(this.memPointAmount);
        dest.writeDouble(this.creditLine);
        dest.writeInt(this.status);
        dest.writeInt(this.needPwdFlag);
        dest.writeInt(this.gender);
        dest.writeString(this.memCatCode);
        dest.writeString(this.provinceCode);
        dest.writeString(this.cityCode);
        dest.writeString(this.regionCode);
        dest.writeString(this.memAddress);
        dest.writeString(this.birthday);
        dest.writeString(this.headImg);
        dest.writeString(this.wxAddress);
        dest.writeInt(this.df);
        dest.writeString(this.memo);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeString(this.parentMemPin);
        dest.writeString(this.barCodeUrl);
        dest.writeString(this.QRCodeUrl);
        dest.writeString(this.QRCodeValue);
        dest.writeString(this.cardNo);
        dest.writeString(this.cardId);
        dest.writeString(this.unionid);
        dest.writeString(this.reference);
        dest.writeString(this.memIDCardNo);
        dest.writeInt(this.onsaleType);
        dest.writeDouble(this.rate);
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

    public String getMemNo() {
        return memNo;
    }

    public void setMemNo(String memNo) {
        this.memNo = memNo;
    }

    public String getMemPin() {
        return memPin;
    }

    public void setMemPin(String memPin) {
        this.memPin = memPin;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
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

    public String getWdStoreCode() {
        return wdStoreCode;
    }

    public void setWdStoreCode(String wdStoreCode) {
        this.wdStoreCode = wdStoreCode;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMemPoint() {
        return memPoint;
    }

    public void setMemPoint(double memPoint) {
        this.memPoint = memPoint;
    }

    public double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public double getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(double presentAmount) {
        this.presentAmount = presentAmount;
    }

    public double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public double getMemPointAmount() {
        return memPointAmount;
    }

    public void setMemPointAmount(double memPointAmount) {
        this.memPointAmount = memPointAmount;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNeedPwdFlag() {
        return needPwdFlag;
    }

    public void setNeedPwdFlag(int needPwdFlag) {
        this.needPwdFlag = needPwdFlag;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMemCatCode() {
        return memCatCode;
    }

    public void setMemCatCode(String memCatCode) {
        this.memCatCode = memCatCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getWxAddress() {
        return wxAddress;
    }

    public void setWxAddress(String wxAddress) {
        this.wxAddress = wxAddress;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getParentMemPin() {
        return parentMemPin;
    }

    public void setParentMemPin(String parentMemPin) {
        this.parentMemPin = parentMemPin;
    }

    public String getBarCodeUrl() {
        return barCodeUrl;
    }

    public void setBarCodeUrl(String barCodeUrl) {
        this.barCodeUrl = barCodeUrl;
    }

    public String getQRCodeUrl() {
        return QRCodeUrl;
    }

    public void setQRCodeUrl(String QRCodeUrl) {
        this.QRCodeUrl = QRCodeUrl;
    }

    public String getQRCodeValue() {
        return QRCodeValue;
    }

    public void setQRCodeValue(String QRCodeValue) {
        this.QRCodeValue = QRCodeValue;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMemIDCardNo() {
        return memIDCardNo;
    }

    public void setMemIDCardNo(String memIDCardNo) {
        this.memIDCardNo = memIDCardNo;
    }

    public int getOnsaleType() {
        return onsaleType;
    }

    public void setOnsaleType(int onsaleType) {
        this.onsaleType = onsaleType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", vendorId=" + vendorId +
                ", memNo='" + memNo + '\'' +
                ", memPin='" + memPin + '\'' +
                ", memPwd='" + memPwd + '\'' +
                ", organCode='" + organCode + '\'' +
                ", organName='" + organName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", wdStoreCode='" + wdStoreCode + '\'' +
                ", memName='" + memName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", balance=" + balance +
                ", memPoint=" + memPoint +
                ", consumeAmount=" + consumeAmount +
                ", presentAmount=" + presentAmount +
                ", rechargeAmount=" + rechargeAmount +
                ", memPointAmount=" + memPointAmount +
                ", creditLine=" + creditLine +
                ", status=" + status +
                ", needPwdFlag=" + needPwdFlag +
                ", gender=" + gender +
                ", memCatCode='" + memCatCode + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", memAddress='" + memAddress + '\'' +
                ", birthday='" + birthday + '\'' +
                ", headImg='" + headImg + '\'' +
                ", wxAddress='" + wxAddress + '\'' +
                ", df=" + df +
                ", memo='" + memo + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", parentMemPin='" + parentMemPin + '\'' +
                ", barCodeUrl='" + barCodeUrl + '\'' +
                ", QRCodeUrl='" + QRCodeUrl + '\'' +
                ", QRCodeValue='" + QRCodeValue + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", unionid='" + unionid + '\'' +
                ", reference='" + reference + '\'' +
                ", memIDCardNo='" + memIDCardNo + '\'' +
                ", onsaleType=" + onsaleType +
                ", rate=" + rate +
                '}';
    }

    public static final class Builder {
        private long vendorId;
        private String memNo;
        private String memPin;
        private String memPwd;
        private String organCode;
        private String organName;
        private String storeCode;
        private String storeName;
        private String wdStoreCode;
        private String memName;
        private String nickName;
        private String mobileNo;
        private double balance;
        private double memPoint;
        private double consumeAmount;
        private double presentAmount;
        private double rechargeAmount;
        private double memPointAmount;
        private double creditLine;
        private int status;
        private int needPwdFlag;
        private int gender;
        private String memCatCode;
        private String provinceCode;
        private String cityCode;
        private String regionCode;
        private String memAddress;
        private String birthday;
        private String headImg;
        private String wxAddress;
        private int df;
        private String memo;
        private String createDate;
        private String modifyDate;
        private String parentMemPin;
        private String barCodeUrl;
        private String QRCodeUrl;
        private String QRCodeValue;
        private String cardNo;
        private String cardId;
        private String unionid;
        private String reference;
        private String memIDCardNo;
        private int onsaleType;
        private double rate;

        public Builder() {
        }

        public Builder onsaleType(int val) {
            onsaleType = val;
            return this;
        }

        public Builder rate(double val) {
            rate = val;
            return this;
        }


        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder memNo(String val) {
            memNo = val;
            return this;
        }

        public Builder memPin(String val) {
            memPin = val;
            return this;
        }

        public Builder memPwd(String val) {
            memPwd = val;
            return this;
        }

        public Builder organCode(String val) {
            organCode = val;
            return this;
        }

        public Builder organName(String val) {
            organName = val;
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

        public Builder wdStoreCode(String val) {
            wdStoreCode = val;
            return this;
        }

        public Builder memName(String val) {
            memName = val;
            return this;
        }

        public Builder nickName(String val) {
            nickName = val;
            return this;
        }

        public Builder mobileNo(String val) {
            mobileNo = val;
            return this;
        }

        public Builder balance(double val) {
            balance = val;
            return this;
        }

        public Builder memPoint(double val) {
            memPoint = val;
            return this;
        }

        public Builder consumeAmount(double val) {
            consumeAmount = val;
            return this;
        }

        public Builder presentAmount(double val) {
            presentAmount = val;
            return this;
        }

        public Builder rechargeAmount(double val) {
            rechargeAmount = val;
            return this;
        }

        public Builder memPointAmount(double val) {
            memPointAmount = val;
            return this;
        }

        public Builder creditLine(double val) {
            creditLine = val;
            return this;
        }

        public Builder status(int val) {
            status = val;
            return this;
        }

        public Builder needPwdFlag(int val) {
            needPwdFlag = val;
            return this;
        }

        public Builder gender(int val) {
            gender = val;
            return this;
        }

        public Builder memCatCode(String val) {
            memCatCode = val;
            return this;
        }

        public Builder provinceCode(String val) {
            provinceCode = val;
            return this;
        }

        public Builder cityCode(String val) {
            cityCode = val;
            return this;
        }

        public Builder regionCode(String val) {
            regionCode = val;
            return this;
        }

        public Builder memAddress(String val) {
            memAddress = val;
            return this;
        }

        public Builder birthday(String val) {
            birthday = val;
            return this;
        }

        public Builder headImg(String val) {
            headImg = val;
            return this;
        }

        public Builder wxAddress(String val) {
            wxAddress = val;
            return this;
        }

        public Builder df(int val) {
            df = val;
            return this;
        }

        public Builder memo(String val) {
            memo = val;
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

        public Builder parentMemPin(String val) {
            parentMemPin = val;
            return this;
        }

        public Builder barCodeUrl(String val) {
            barCodeUrl = val;
            return this;
        }

        public Builder QRCodeUrl(String val) {
            QRCodeUrl = val;
            return this;
        }

        public Builder QRCodeValue(String val) {
            QRCodeValue = val;
            return this;
        }

        public Builder cardNo(String val) {
            cardNo = val;
            return this;
        }

        public Builder cardId(String val) {
            cardId = val;
            return this;
        }

        public Builder unionid(String val) {
            unionid = val;
            return this;
        }

        public Builder reference(String val) {
            reference = val;
            return this;
        }

        public Builder memIDCardNo(String val) {
            memIDCardNo = val;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Member member = null;
        try {
            member = (Member) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return member;
    }
}