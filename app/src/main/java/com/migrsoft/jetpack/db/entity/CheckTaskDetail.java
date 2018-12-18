package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：盘点任务详细表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "checktaskdetail",
        indices = {@Index(value = {"vendorId", "taskNo", "objectCode"}, name = "idx_checktaskdetail_ids", unique = true)})
public class CheckTaskDetail implements Parcelable {
    public static final Creator<CheckTaskDetail> CREATOR = new Creator<CheckTaskDetail>() {
        @Override
        public CheckTaskDetail createFromParcel(Parcel source) {
            return new CheckTaskDetail(source);
        }

        @Override
        public CheckTaskDetail[] newArray(int size) {
            return new CheckTaskDetail[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;          // bigint(20) unsigned NOT NULL COMMENT '商家ID',
    private String taskNo;          // varchar(16) NOT NULL COMMENT '盘点任务号',
    private int checkType;          // tinyint(4) NOT NULL COMMENT '盘点类型 0 全场 1单品 2品牌 3品类',
    private String objectCode;      // varchar(16) DEFAULT NULL COMMENT '盘点目标编码 根据类型决定品牌 品类 商品',
    private String objectName;      // varchar(64) DEFAULT NULL COMMENT '盘点目标名称 根据类型决定品牌 品类 商品',
    private String parentObjectCode;// varchar(16) DEFAULT NULL COMMENT '盘点目标父级编码 根据类型决定品牌 品类 商品',
    private String parentObjectName;// varchar(64) DEFAULT NULL COMMENT '盘点目标父级名称 根据类型决定品牌 品类 商品',
    private String topObjectCode;   // varchar(16) DEFAULT NULL COMMENT '盘点目标顶级编码 根据类型决定品牌 品类 商品',
    private String topObjectName;   // varchar(64) DEFAULT NULL COMMENT '盘点目标顶级名称 根据类型决定品牌 品类 商品',
    private String level;           // varchar(16) DEFAULT NULL COMMENT '级别',
    private String barcode;         // varchar(16) DEFAULT NULL COMMENT '国际条形码',
    private String memo;            // varchar(512) DEFAULT NULL COMMENT '备注',
    private String specMemo;        // varchar(64) DEFAULT NULL COMMENT '规格描述',
    private String creator;         // varchar(32) NOT NULL COMMENT '创建者',
    private String mender;          // varchar(32) DEFAULT NULL COMMENT '最后修改人',
    private int df;                 // tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除1删除 0正常',
    private String createDate;      // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;      // datetime NOT NULL COMMENT '修改日期',
    private int version;            // int(10) unsigned NOT NULL DEFAULT '0' COMMENT '数据版本',
    private String stockUnit;       // varchar(16) DEFAULT NULL COMMENT '库存单位',
    private String icatCode;        // varchar(16) DEFAULT NULL COMMENT '商家品类编码',
    private String icatName;        // varchar(64) DEFAULT NULL COMMENT '商家品类名称',

    public CheckTaskDetail() {
    }

    private CheckTaskDetail(Builder builder) {
        vendorId = builder.vendorId;
        taskNo = builder.taskNo;
        checkType = builder.checkType;
        objectCode = builder.objectCode;
        objectName = builder.objectName;
        parentObjectCode = builder.parentObjectCode;
        parentObjectName = builder.parentObjectName;
        topObjectCode = builder.topObjectCode;
        topObjectName = builder.topObjectName;
        level = builder.level;
        barcode = builder.barcode;
        memo = builder.memo;
        specMemo = builder.specMemo;
        creator = builder.creator;
        mender = builder.mender;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        stockUnit = builder.stockUnit;
        icatCode = builder.icatCode;
        icatName = builder.icatName;
    }

    protected CheckTaskDetail(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.taskNo = in.readString();
        this.checkType = in.readInt();
        this.objectCode = in.readString();
        this.objectName = in.readString();
        this.parentObjectCode = in.readString();
        this.parentObjectName = in.readString();
        this.topObjectCode = in.readString();
        this.topObjectName = in.readString();
        this.level = in.readString();
        this.barcode = in.readString();
        this.memo = in.readString();
        this.specMemo = in.readString();
        this.creator = in.readString();
        this.mender = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.stockUnit = in.readString();
        this.icatCode = in.readString();
        this.icatName = in.readString();
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getParentObjectCode() {
        return parentObjectCode;
    }

    public void setParentObjectCode(String parentObjectCode) {
        this.parentObjectCode = parentObjectCode;
    }

    public String getParentObjectName() {
        return parentObjectName;
    }

    public void setParentObjectName(String parentObjectName) {
        this.parentObjectName = parentObjectName;
    }

    public String getTopObjectCode() {
        return topObjectCode;
    }

    public void setTopObjectCode(String topObjectCode) {
        this.topObjectCode = topObjectCode;
    }

    public String getTopObjectName() {
        return topObjectName;
    }

    public void setTopObjectName(String topObjectName) {
        this.topObjectName = topObjectName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.taskNo);
        dest.writeInt(this.checkType);
        dest.writeString(this.objectCode);
        dest.writeString(this.objectName);
        dest.writeString(this.parentObjectCode);
        dest.writeString(this.parentObjectName);
        dest.writeString(this.topObjectCode);
        dest.writeString(this.topObjectName);
        dest.writeString(this.level);
        dest.writeString(this.barcode);
        dest.writeString(this.memo);
        dest.writeString(this.specMemo);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeString(this.stockUnit);
        dest.writeString(this.icatCode);
        dest.writeString(this.icatName);
    }

    public static final class Builder {
        private long vendorId;
        private String taskNo;
        private int checkType;
        private String objectCode;
        private String objectName;
        private String parentObjectCode;
        private String parentObjectName;
        private String topObjectCode;
        private String topObjectName;
        private String level;
        private String barcode;
        private String memo;
        private String specMemo;
        private String creator;
        private String mender;
        private int df;
        private String createDate;
        private String modifyDate;
        private int version;
        private String stockUnit;
        private String icatCode;
        private String icatName;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder taskNo(String val) {
            taskNo = val;
            return this;
        }

        public Builder checkType(int val) {
            checkType = val;
            return this;
        }

        public Builder objectCode(String val) {
            objectCode = val;
            return this;
        }

        public Builder objectName(String val) {
            objectName = val;
            return this;
        }

        public Builder parentObjectCode(String val) {
            parentObjectCode = val;
            return this;
        }

        public Builder parentObjectName(String val) {
            parentObjectName = val;
            return this;
        }

        public Builder topObjectCode(String val) {
            topObjectCode = val;
            return this;
        }

        public Builder topObjectName(String val) {
            topObjectName = val;
            return this;
        }

        public Builder level(String val) {
            level = val;
            return this;
        }

        public Builder barcode(String val) {
            barcode = val;
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

        public Builder creator(String val) {
            creator = val;
            return this;
        }

        public Builder mender(String val) {
            mender = val;
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

        public Builder stockUnit(String val) {
            stockUnit = val;
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

        public CheckTaskDetail build() {
            return new CheckTaskDetail(this);
        }
    }
}
