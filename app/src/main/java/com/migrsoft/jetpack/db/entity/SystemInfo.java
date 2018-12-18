package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：系统信息设置表
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "systeminfo",
        indices = {@Index(value = "vendorId", name = "idx_systemInfo_vendorId")})
public class SystemInfo implements Parcelable {
    public static final Creator<SystemInfo> CREATOR = new Creator<SystemInfo>() {
        @Override
        public SystemInfo createFromParcel(Parcel source) {
            return new SystemInfo(source);
        }

        @Override
        public SystemInfo[] newArray(int size) {
            return new SystemInfo[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                         //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;                   //  bigint(20) unsigned NOT NULL COMMENT '商家ID 0表示平台全局默认参数',
    private String backLoginLogo;            //  varchar(128) DEFAULT NULL COMMENT '后台登陆logo url',
    private String backSysLogo;              //  varchar(128) DEFAULT NULL COMMENT '后台系统logoURL',
    private String backIco;                  //  varchar(128) DEFAULT NULL COMMENT '后台ico图 URL',
    private String mobileLoginLogo;          //  varchar(128) DEFAULT NULL COMMENT '移动端登陆logo URL',
    private String mobileSysLogo;            //  varchar(128) DEFAULT NULL COMMENT '移动端系统logoURL',
    private String posLoginLogo;             //  varchar(128) DEFAULT NULL COMMENT 'pos登陆logo URL',
    private String posSysLogo;               //  varchar(128) DEFAULT NULL COMMENT 'pos系统logo url',
    private String backName;                 //  varchar(64) DEFAULT NULL COMMENT '运营后台名称',
    private String vendorBackName;           //  varchar(64) DEFAULT NULL COMMENT '商家后台名称',
    private String coNet;                    //  varchar(128) DEFAULT NULL COMMENT '公司网址',
    private String telNo;                    //  varchar(32) DEFAULT NULL COMMENT '联系电话',
    private String coFax;                    //  varchar(32) DEFAULT NULL COMMENT '公司传真',
    private String postCode;                 //  varchar(16) DEFAULT NULL COMMENT '邮编',
    private String email;                    //  varchar(64) DEFAULT NULL COMMENT '邮箱',
    private String addr;                     //  varchar(128) DEFAULT NULL COMMENT '地址',
    private String posServiceTel;            //  varchar(32) DEFAULT NULL COMMENT 'pos端客服电话',
    private String backServiceTel;           //  varchar(32) DEFAULT NULL COMMENT '后台客服电话',
    private String copyRight;                //  varchar(128) DEFAULT NULL COMMENT '版权信息',
    private String coName;                   //  varchar(64) DEFAULT NULL COMMENT '公司名称',
    private int usable;                      //  tinyint(4) DEFAULT NULL COMMENT '是否生效 1是 0收',
    private int df;                          //  tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;               //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;               //  datetime NOT NULL COMMENT '修改日期',
    private int isDown;                      //  int(2) DEFAULT NULL,
    private String posPrintLogo;             //  varchar(64) DEFAULT NULL COMMENT '打印机的logo',
    private String qrcodePath;               //  varchar(128) DEFAULT NULL COMMENT '平台二维码图片路径',
    private String posExtendLogo;            // 平台二维码新添路径.

    private SystemInfo(Builder builder) {
        vendorId = builder.vendorId;
        backLoginLogo = builder.backLoginLogo;
        backSysLogo = builder.backSysLogo;
        backIco = builder.backIco;
        mobileLoginLogo = builder.mobileLoginLogo;
        mobileSysLogo = builder.mobileSysLogo;
        posLoginLogo = builder.posLoginLogo;
        posSysLogo = builder.posSysLogo;
        backName = builder.backName;
        vendorBackName = builder.vendorBackName;
        coNet = builder.coNet;
        telNo = builder.telNo;
        coFax = builder.coFax;
        postCode = builder.postCode;
        email = builder.email;
        addr = builder.addr;
        posServiceTel = builder.posServiceTel;
        backServiceTel = builder.backServiceTel;
        copyRight = builder.copyRight;
        coName = builder.coName;
        usable = builder.usable;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        isDown = builder.isDown;
        posPrintLogo = builder.posPrintLogo;
        qrcodePath = builder.qrcodePath;
        posExtendLogo = builder.posExtendLogo;
    }

    public SystemInfo() {
    }

    protected SystemInfo(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.backLoginLogo = in.readString();
        this.backSysLogo = in.readString();
        this.backIco = in.readString();
        this.mobileLoginLogo = in.readString();
        this.mobileSysLogo = in.readString();
        this.posLoginLogo = in.readString();
        this.posSysLogo = in.readString();
        this.backName = in.readString();
        this.vendorBackName = in.readString();
        this.coNet = in.readString();
        this.telNo = in.readString();
        this.coFax = in.readString();
        this.postCode = in.readString();
        this.email = in.readString();
        this.addr = in.readString();
        this.posServiceTel = in.readString();
        this.backServiceTel = in.readString();
        this.copyRight = in.readString();
        this.coName = in.readString();
        this.usable = in.readInt();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.isDown = in.readInt();
        this.posPrintLogo = in.readString();
        this.qrcodePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.backLoginLogo);
        dest.writeString(this.backSysLogo);
        dest.writeString(this.backIco);
        dest.writeString(this.mobileLoginLogo);
        dest.writeString(this.mobileSysLogo);
        dest.writeString(this.posLoginLogo);
        dest.writeString(this.posSysLogo);
        dest.writeString(this.backName);
        dest.writeString(this.vendorBackName);
        dest.writeString(this.coNet);
        dest.writeString(this.telNo);
        dest.writeString(this.coFax);
        dest.writeString(this.postCode);
        dest.writeString(this.email);
        dest.writeString(this.addr);
        dest.writeString(this.posServiceTel);
        dest.writeString(this.backServiceTel);
        dest.writeString(this.copyRight);
        dest.writeString(this.coName);
        dest.writeInt(this.usable);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.isDown);
        dest.writeString(this.posPrintLogo);
        dest.writeString(this.qrcodePath);
        dest.writeString(this.posExtendLogo);
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

    public String getBackLoginLogo() {
        return backLoginLogo;
    }

    public void setBackLoginLogo(String backLoginLogo) {
        this.backLoginLogo = backLoginLogo;
    }

    public String getBackSysLogo() {
        return backSysLogo;
    }

    public void setBackSysLogo(String backSysLogo) {
        this.backSysLogo = backSysLogo;
    }

    public String getBackIco() {
        return backIco;
    }

    public void setBackIco(String backIco) {
        this.backIco = backIco;
    }

    public String getMobileLoginLogo() {
        return mobileLoginLogo;
    }

    public void setMobileLoginLogo(String mobileLoginLogo) {
        this.mobileLoginLogo = mobileLoginLogo;
    }

    public String getMobileSysLogo() {
        return mobileSysLogo;
    }

    public void setMobileSysLogo(String mobileSysLogo) {
        this.mobileSysLogo = mobileSysLogo;
    }

    public String getPosLoginLogo() {
        return posLoginLogo;
    }

    public void setPosLoginLogo(String posLoginLogo) {
        this.posLoginLogo = posLoginLogo;
    }

    public String getPosSysLogo() {
        return posSysLogo;
    }

    public void setPosSysLogo(String posSysLogo) {
        this.posSysLogo = posSysLogo;
    }

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
    }

    public String getVendorBackName() {
        return vendorBackName;
    }

    public void setVendorBackName(String vendorBackName) {
        this.vendorBackName = vendorBackName;
    }

    public String getCoNet() {
        return coNet;
    }

    public void setCoNet(String coNet) {
        this.coNet = coNet;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getCoFax() {
        return coFax;
    }

    public void setCoFax(String coFax) {
        this.coFax = coFax;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPosServiceTel() {
        return posServiceTel;
    }

    public void setPosServiceTel(String posServiceTel) {
        this.posServiceTel = posServiceTel;
    }

    public String getBackServiceTel() {
        return backServiceTel;
    }

    public void setBackServiceTel(String backServiceTel) {
        this.backServiceTel = backServiceTel;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public int getUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
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

    public int getIsDown() {
        return isDown;
    }

    public void setIsDown(int isDown) {
        this.isDown = isDown;
    }

    public String getPosPrintLogo() {
        return posPrintLogo;
    }

    public void setPosPrintLogo(String posPrintLogo) {
        this.posPrintLogo = posPrintLogo;
    }

    public String getQrcodePath() {
        return qrcodePath;
    }

    public void setQrcodePath(String qrcodePath) {
        this.qrcodePath = qrcodePath;
    }

    public String getPosExtendLogo() {
        return posExtendLogo;
    }

    public void setPosExtendLogo(String posExtendLogo) {
        this.posExtendLogo = posExtendLogo;
    }

    public static final class Builder {
        private long vendorId;
        private String backLoginLogo;
        private String backSysLogo;
        private String backIco;
        private String mobileLoginLogo;
        private String mobileSysLogo;
        private String posLoginLogo;
        private String posSysLogo;
        private String backName;
        private String vendorBackName;
        private String coNet;
        private String telNo;
        private String coFax;
        private String postCode;
        private String email;
        private String addr;
        private String posServiceTel;
        private String backServiceTel;
        private String copyRight;
        private String coName;
        private int usable;
        private int df;
        private String createDate;
        private String modifyDate;
        private int isDown;
        private String posPrintLogo;
        private String qrcodePath;
        private String posExtendLogo;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder backLoginLogo(String val) {
            backLoginLogo = val;
            return this;
        }

        public Builder backSysLogo(String val) {
            backSysLogo = val;
            return this;
        }

        public Builder backIco(String val) {
            backIco = val;
            return this;
        }

        public Builder mobileLoginLogo(String val) {
            mobileLoginLogo = val;
            return this;
        }

        public Builder mobileSysLogo(String val) {
            mobileSysLogo = val;
            return this;
        }

        public Builder posLoginLogo(String val) {
            posLoginLogo = val;
            return this;
        }

        public Builder posSysLogo(String val) {
            posSysLogo = val;
            return this;
        }

        public Builder backName(String val) {
            backName = val;
            return this;
        }

        public Builder vendorBackName(String val) {
            vendorBackName = val;
            return this;
        }

        public Builder coNet(String val) {
            coNet = val;
            return this;
        }

        public Builder telNo(String val) {
            telNo = val;
            return this;
        }

        public Builder coFax(String val) {
            coFax = val;
            return this;
        }

        public Builder postCode(String val) {
            postCode = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder addr(String val) {
            addr = val;
            return this;
        }

        public Builder posServiceTel(String val) {
            posServiceTel = val;
            return this;
        }

        public Builder backServiceTel(String val) {
            backServiceTel = val;
            return this;
        }

        public Builder copyRight(String val) {
            copyRight = val;
            return this;
        }

        public Builder coName(String val) {
            coName = val;
            return this;
        }

        public Builder usable(int val) {
            usable = val;
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

        public Builder isDown(int val) {
            isDown = val;
            return this;
        }

        public Builder posPrintLogo(String val) {
            posPrintLogo = val;
            return this;
        }

        public Builder qrcodePath(String val) {
            qrcodePath = val;
            return this;
        }

        public Builder posExtendLogo(String val) {
            posExtendLogo = val;
            return this;
        }

        public SystemInfo build() {
            return new SystemInfo(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "vendorId=" + vendorId +
                    ", backLoginLogo='" + backLoginLogo + '\'' +
                    ", backSysLogo='" + backSysLogo + '\'' +
                    ", backIco='" + backIco + '\'' +
                    ", mobileLoginLogo='" + mobileLoginLogo + '\'' +
                    ", mobileSysLogo='" + mobileSysLogo + '\'' +
                    ", posLoginLogo='" + posLoginLogo + '\'' +
                    ", posSysLogo='" + posSysLogo + '\'' +
                    ", backName='" + backName + '\'' +
                    ", vendorBackName='" + vendorBackName + '\'' +
                    ", coNet='" + coNet + '\'' +
                    ", telNo='" + telNo + '\'' +
                    ", coFax='" + coFax + '\'' +
                    ", postCode='" + postCode + '\'' +
                    ", email='" + email + '\'' +
                    ", addr='" + addr + '\'' +
                    ", posServiceTel='" + posServiceTel + '\'' +
                    ", backServiceTel='" + backServiceTel + '\'' +
                    ", copyRight='" + copyRight + '\'' +
                    ", coName='" + coName + '\'' +
                    ", usable=" + usable +
                    ", df=" + df +
                    ", createDate='" + createDate + '\'' +
                    ", modifyDate='" + modifyDate + '\'' +
                    ", isDown=" + isDown +
                    ", posPrintLogo='" + posPrintLogo + '\'' +
                    ", qrcodePath='" + qrcodePath + '\'' +
                    ", posExtendLogo" + posExtendLogo + '\'' +
                    '}';
        }
    }
}
