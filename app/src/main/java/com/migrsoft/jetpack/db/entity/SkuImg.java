package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：SKU商品图片
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "skuimg",
        indices = {@Index(value = {"vendorId", "skuCode"}, name = "idx_skuImg_idCode")})
public class SkuImg implements Parcelable {
    public static final Creator<SkuImg> CREATOR = new Creator<SkuImg>() {
        @Override
        public SkuImg createFromParcel(Parcel source) {
            return new SkuImg(source);
        }

        @Override
        public SkuImg[] newArray(int size) {
            return new SkuImg[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;            // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;      // bigint(20) unsigned NOT NULL COMMENT '所属商家ID',
    private String itemCode;    // varchar(16) DEFAULT NULL COMMENT '商品编码',
    private String skuCode;     // varchar(16) DEFAULT NULL COMMENT '所属商家ID',
    private String imgPath;     // varchar(128) DEFAULT NULL COMMENT '图片访问地址',
    private int imgFlag;        // tinyint(4) DEFAULT NULL COMMENT '尺码  0小 1中 2 大',
    private int viewOrder;      // tinyint(4) DEFAULT NULL COMMENT '显示顺序',
    private int usable;         // tinyint(4) DEFAULT '1' COMMENT '可用状态 1是 0否',
    private int df;             // tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String memo;        // varchar(32) DEFAULT NULL COMMENT '备注',
    private String createDate;  // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;  // datetime NOT NULL COMMENT '修改日期',
    private int version;        // int(10) unsigned DEFAULT '0' COMMENT '数据版本',
    private long imgid;         // bigint(20) DEFAULT NULL,
    private int isDown;         // int(2) DEFAULT '0',

    private SkuImg(Builder builder) {
        vendorId = builder.vendorId;
        itemCode = builder.itemCode;
        skuCode = builder.skuCode;
        imgPath = builder.imgPath;
        imgFlag = builder.imgFlag;
        viewOrder = builder.viewOrder;
        usable = builder.usable;
        df = builder.df;
        memo = builder.memo;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        imgid = builder.imgid;
        isDown = builder.isDown;
    }

    public SkuImg() {
    }

    protected SkuImg(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.itemCode = in.readString();
        this.skuCode = in.readString();
        this.imgPath = in.readString();
        this.imgFlag = in.readInt();
        this.viewOrder = in.readInt();
        this.usable = in.readInt();
        this.df = in.readInt();
        this.memo = in.readString();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.imgid = in.readLong();
        this.isDown = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.itemCode);
        dest.writeString(this.skuCode);
        dest.writeString(this.imgPath);
        dest.writeInt(this.imgFlag);
        dest.writeInt(this.viewOrder);
        dest.writeInt(this.usable);
        dest.writeInt(this.df);
        dest.writeString(this.memo);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeLong(this.imgid);
        dest.writeInt(this.isDown);
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(int imgFlag) {
        this.imgFlag = imgFlag;
    }

    public int getViewOrder() {
        return viewOrder;
    }

    public void setViewOrder(int viewOrder) {
        this.viewOrder = viewOrder;
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

    public long getImgid() {
        return imgid;
    }

    public void setImgid(long imgid) {
        this.imgid = imgid;
    }

    public int getIsDown() {
        return isDown;
    }

    public void setIsDown(int isDown) {
        this.isDown = isDown;
    }

    public static final class Builder {
        private long vendorId;
        private String itemCode;
        private String skuCode;
        private String imgPath;
        private int imgFlag;
        private int viewOrder;
        private int usable;
        private int df;
        private String memo;
        private String createDate;
        private String modifyDate;
        private int version;
        private long imgid;
        private int isDown;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder itemCode(String val) {
            itemCode = val;
            return this;
        }

        public Builder skuCode(String val) {
            skuCode = val;
            return this;
        }

        public Builder imgPath(String val) {
            imgPath = val;
            return this;
        }

        public Builder imgFlag(int val) {
            imgFlag = val;
            return this;
        }

        public Builder viewOrder(int val) {
            viewOrder = val;
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

        public Builder imgid(long val) {
            imgid = val;
            return this;
        }

        public Builder isDown(int val) {
            isDown = val;
            return this;
        }

        public SkuImg build() {
            return new SkuImg(this);
        }
    }
}
