package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：分店信息表
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "store",
        indices = {@Index(value = {"vendorId", "storeCode"}, name = "idx_store_idCode"),
                @Index(value = "organCode", name = "idx_store_organCode")})
public class Store implements Parcelable {
    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            return new Store(source);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                 // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;           // bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String storeCode;          // varchar(16) DEFAULT NULL COMMENT '机构编码',
    private String storeName;          // varchar(64) DEFAULT NULL COMMENT '机构名称',
    private String organCode;          // varchar(16) DEFAULT NULL COMMENT '品类父级编码',
    private int storeType;          // tinyint(4) DEFAULT NULL COMMENT '门店类型 0仓库 1自营店 2加盟店 3虚拟店 4微店',
    private String provinceCode;       // varchar(32) DEFAULT NULL COMMENT '省级编码',
    private String cityCode;           // varchar(32) DEFAULT NULL COMMENT '市级编码',
    private String regionCode;         // varchar(32) DEFAULT NULL COMMENT '地区编码',
    private String address;            // varchar(128) DEFAULT NULL COMMENT '地址',
    private String linkman;            // varchar(16) DEFAULT NULL COMMENT '联系人',
    private String cellPhone;          // varchar(16) DEFAULT NULL COMMENT '手机号',
    private String email;              // varchar(32) DEFAULT NULL COMMENT '邮箱',
    private String postcode;           // varchar(8) DEFAULT NULL COMMENT '邮政编码',
    private String tel;                // varchar(16) DEFAULT NULL COMMENT '电话',
    private String fax;                // varchar(16) DEFAULT NULL COMMENT '传真',
    private int usable;             // tinyint(4) DEFAULT '1' COMMENT '可用状态 1是 0否',
    private double rental;             // double(16,5) DEFAULT NULL COMMENT '租金',
    private double area;               // double(16,5) DEFAULT NULL COMMENT '营业面积',
    private int df;                 // tinyint(4) DEFAULT NULL COMMENT '是否已删除1删除 0正常',
    private String memo;               // varchar(32) DEFAULT NULL COMMENT '备注',
    private String createDate;         // datetime DEFAULT NULL COMMENT '创建日期',
    private String modifyDate;         // datetime DEFAULT NULL COMMENT '修改日期',
    private int version;            // int(10) unsigned DEFAULT '0' COMMENT '数据版本',
    private String creator;            // varchar(32) DEFAULT NULL COMMENT '记录创建人用户名',
    private String mender;             // varchar(32) DEFAULT NULL COMMENT '最后修改人用户名',
    private String organName;          // varchar(64) DEFAULT NULL COMMENT '机构名称',

    private Store(Builder builder) {
        vendorId = builder.vendorId;
        storeCode = builder.storeCode;
        storeName = builder.storeName;
        organCode = builder.organCode;
        storeType = builder.storeType;
        provinceCode = builder.provinceCode;
        cityCode = builder.cityCode;
        regionCode = builder.regionCode;
        address = builder.address;
        linkman = builder.linkman;
        cellPhone = builder.cellPhone;
        email = builder.email;
        postcode = builder.postcode;
        tel = builder.tel;
        fax = builder.fax;
        usable = builder.usable;
        rental = builder.rental;
        area = builder.area;
        df = builder.df;
        memo = builder.memo;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        creator = builder.creator;
        mender = builder.mender;
        organName = builder.organName;
    }

    public Store() {
    }

    protected Store(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.organCode = in.readString();
        this.storeType = in.readInt();
        this.provinceCode = in.readString();
        this.cityCode = in.readString();
        this.regionCode = in.readString();
        this.address = in.readString();
        this.linkman = in.readString();
        this.cellPhone = in.readString();
        this.email = in.readString();
        this.postcode = in.readString();
        this.tel = in.readString();
        this.fax = in.readString();
        this.usable = in.readInt();
        this.rental = in.readDouble();
        this.area = in.readDouble();
        this.df = in.readInt();
        this.memo = in.readString();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.creator = in.readString();
        this.mender = in.readString();
        this.organName = in.readString();
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
        dest.writeString(this.organCode);
        dest.writeInt(this.storeType);
        dest.writeString(this.provinceCode);
        dest.writeString(this.cityCode);
        dest.writeString(this.regionCode);
        dest.writeString(this.address);
        dest.writeString(this.linkman);
        dest.writeString(this.cellPhone);
        dest.writeString(this.email);
        dest.writeString(this.postcode);
        dest.writeString(this.tel);
        dest.writeString(this.fax);
        dest.writeInt(this.usable);
        dest.writeDouble(this.rental);
        dest.writeDouble(this.area);
        dest.writeInt(this.df);
        dest.writeString(this.memo);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeString(this.organName);
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

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public int getStoreType() {
        return storeType;
    }

    public void setStoreType(int storeType) {
        this.storeType = storeType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

    public double getRental() {
        return rental;
    }

    public void setRental(double rental) {
        this.rental = rental;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public static final class Builder {
        private long vendorId;
        private String storeCode;
        private String storeName;
        private String organCode;
        private int storeType;
        private String provinceCode;
        private String cityCode;
        private String regionCode;
        private String address;
        private String linkman;
        private String cellPhone;
        private String email;
        private String postcode;
        private String tel;
        private String fax;
        private int usable;
        private double rental;
        private double area;
        private int df;
        private String memo;
        private String createDate;
        private String modifyDate;
        private int version;
        private String creator;
        private String mender;
        private String organName;

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

        public Builder organCode(String val) {
            organCode = val;
            return this;
        }

        public Builder storeType(int val) {
            storeType = val;
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

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder linkman(String val) {
            linkman = val;
            return this;
        }

        public Builder cellPhone(String val) {
            cellPhone = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder postcode(String val) {
            postcode = val;
            return this;
        }

        public Builder tel(String val) {
            tel = val;
            return this;
        }

        public Builder fax(String val) {
            fax = val;
            return this;
        }

        public Builder usable(int val) {
            usable = val;
            return this;
        }

        public Builder rental(double val) {
            rental = val;
            return this;
        }

        public Builder area(double val) {
            area = val;
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

        public Builder organName(String val) {
            organName = val;
            return this;
        }

        public Store build() {
            return new Store(this);
        }
    }
}
