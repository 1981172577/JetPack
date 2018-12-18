package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.io.Serializable;

/**
 * 简介：终端登记表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "register",
        indices = {@Index(value = {"vendorId", "rcode"}, name = "idx_register_idrcode", unique = true),
                @Index(value = "rcode", name = "idx_register_rcode"),
                @Index(value = "storeCode", name = "idx_register_storeCode"),
                @Index(value = "organCode", name = "idx_register_organCode")})
public class Register implements Parcelable, Serializable {
    public static final Creator<Register> CREATOR = new Creator<Register>() {
        @Override
        public Register createFromParcel(Parcel source) {
            return new Register(source);
        }

        @Override
        public Register[] newArray(int size) {
            return new Register[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;           // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;     // bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String createDate; // datetime DEFAULT NULL COMMENT '创建时间',
    private String modifyDate; // datetime DEFAULT NULL COMMENT '修改时间',
    private int version;       // int(11) DEFAULT '0' COMMENT '版本信息',
    private String creator;    // varchar(32) DEFAULT NULL COMMENT '创建者',
    private String mender;     // varchar(32) DEFAULT NULL COMMENT '修改人',
    private String organCode;  // varchar(16) DEFAULT NULL COMMENT '机构编码',
    private String organName;  // varchar(64) DEFAULT NULL COMMENT '机构名称',
    private String storeCode;  // varchar(16) DEFAULT NULL COMMENT '分店编码',
    private String storeName;  // varchar(64) DEFAULT NULL COMMENT '分店名称',
    private String rcode;      // varchar(32) DEFAULT NULL COMMENT '编号', posCode.
    private String rname;      // varchar(64) DEFAULT NULL COMMENT '名称',
    private String ip;         // varchar(20) DEFAULT NULL COMMENT 'IP地址',
    private String mac;        // varchar(512) DEFAULT NULL COMMENT 'mac地址',
    private int inuse;         // int(11) DEFAULT NULL COMMENT '是否使用1可用,0禁用',
    private int rtype;         // tinyint(4) DEFAULT '0' COMMENT '终端类型 0window端  1andriod端 2ios端 3移动终端设备',
    private int bizType;       // tinyint(4) DEFAULT '0' COMMENT 'pos机业务类型(android pos) 0 生鲜专卖版; 1 自助版; 2.手持收银
    private String posVersion; // varchar(32) DEFAULT NULL COMMENT '前台版本',
    private String updateDate; // datetime DEFAULT NULL COMMENT '更新时间',
    private int isbind;        // tinyint(4) NOT NULL COMMENT '是否绑定 0未绑定 1绑定',
    private String memo;       // varchar(256) DEFAULT NULL COMMENT '备注',
    private int df;            // tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String uid;        // varchar(32) NOT NULL COMMENT '唯一标识',
    private int mainFlag;      // tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是主pos机 1是 0否',
    private String mainIp;     // varchar(20) DEFAULT NULL COMMENT '主POS ip 地址',

    public Register() {
    }

    private Register(Builder builder) {
        vendorId = builder.vendorId;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        creator = builder.creator;
        mender = builder.mender;
        organCode = builder.organCode;
        organName = builder.organName;
        storeCode = builder.storeCode;
        storeName = builder.storeName;
        rcode = builder.rcode;
        rname = builder.rname;
        ip = builder.ip;
        mac = builder.mac;
        inuse = builder.inuse;
        rtype = builder.rtype;
        bizType = builder.bizType;
        posVersion = builder.posVersion;
        updateDate = builder.updateDate;
        isbind = builder.isbind;
        memo = builder.memo;
        df = builder.df;
        uid = builder.uid;
        mainFlag = builder.mainFlag;
        mainIp = builder.mainIp;
    }


    protected Register(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.creator = in.readString();
        this.mender = in.readString();
        this.organCode = in.readString();
        this.organName = in.readString();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.rcode = in.readString();
        this.rname = in.readString();
        this.ip = in.readString();
        this.mac = in.readString();
        this.inuse = in.readInt();
        this.rtype = in.readInt();
        this.bizType = in.readInt();
        this.posVersion = in.readString();
        this.updateDate = in.readString();
        this.isbind = in.readInt();
        this.memo = in.readString();
        this.df = in.readInt();
        this.uid = in.readString();
        this.mainFlag = in.readInt();
        this.mainIp = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeString(this.organCode);
        dest.writeString(this.organName);
        dest.writeString(this.storeCode);
        dest.writeString(this.storeName);
        dest.writeString(this.rcode);
        dest.writeString(this.rname);
        dest.writeString(this.ip);
        dest.writeString(this.mac);
        dest.writeInt(this.inuse);
        dest.writeInt(this.rtype);
        dest.writeInt(this.bizType);
        dest.writeString(this.posVersion);
        dest.writeString(this.updateDate);
        dest.writeInt(this.isbind);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.uid);
        dest.writeInt(this.mainFlag);
        dest.writeString(this.mainIp);
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

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getInuse() {
        return inuse;
    }

    public void setInuse(int inuse) {
        this.inuse = inuse;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public String getPosVersion() {
        return posVersion;
    }

    public void setPosVersion(String posVersion) {
        this.posVersion = posVersion;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getIsbind() {
        return isbind;
    }

    public void setIsbind(int isbind) {
        this.isbind = isbind;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(int mainFlag) {
        this.mainFlag = mainFlag;
    }

    public String getMainIp() {
        return mainIp;
    }

    public void setMainIp(String mainIp) {
        this.mainIp = mainIp;
    }


    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", vendorId=" + vendorId +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", version=" + version +
                ", creator='" + creator + '\'' +
                ", mender='" + mender + '\'' +
                ", organCode='" + organCode + '\'' +
                ", organName='" + organName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", rcode='" + rcode + '\'' +
                ", rname='" + rname + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", inuse=" + inuse +
                ", rtype=" + rtype +
                ", bizType=" + bizType +
                ", posVersion='" + posVersion + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", isbind=" + isbind +
                ", memo='" + memo + '\'' +
                ", df=" + df +
                ", uid='" + uid + '\'' +
                ", mainFlag=" + mainFlag +
                ", mainIp='" + mainIp + '\'' +
                '}';
    }

    public static final class Builder {

        private long vendorId;
        private String createDate;
        private String modifyDate;
        private int version;
        private String creator;
        private String mender;
        private String organCode;
        private String organName;
        private String storeCode;
        private String storeName;
        private String rcode;
        private String rname;
        private String ip;
        private String mac;
        private int inuse;
        private int rtype;
        private int bizType;
        private String posVersion;
        private String updateDate;
        private int isbind;
        private String memo;
        private int df;
        private String uid;
        private int mainFlag;
        private String mainIp;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
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

        public Builder rcode(String val) {
            rcode = val;
            return this;
        }

        public Builder rname(String val) {
            rname = val;
            return this;
        }

        public Builder ip(String val) {
            ip = val;
            return this;
        }

        public Builder mac(String val) {
            mac = val;
            return this;
        }

        public Builder inuse(int val) {
            inuse = val;
            return this;
        }

        public Builder rtype(int val) {
            rtype = val;
            return this;
        }

        public Builder bizType(int val) {
            bizType = val;
            return this;
        }

        public Builder posVersion(String val) {
            posVersion = val;
            return this;
        }

        public Builder updateDate(String val) {
            updateDate = val;
            return this;
        }

        public Builder isbind(int val) {
            isbind = val;
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

        public Builder uid(String val) {
            uid = val;
            return this;
        }

        public Builder mainFlag(int val) {
            mainFlag = val;
            return this;
        }

        public Builder mainIp(String val) {
            mainIp = val;
            return this;
        }

        public Register build() {
            return new Register(this);
        }

    }
}
