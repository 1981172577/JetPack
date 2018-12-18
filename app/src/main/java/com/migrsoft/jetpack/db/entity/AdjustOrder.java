package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：调价单主信息表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "adjustorder",
        indices = {@Index(value = {"vendorId", "orderNo"}, unique = true)})
public class AdjustOrder implements Parcelable {
    public static final Creator<AdjustOrder> CREATOR = new Creator<AdjustOrder>() {
        @Override
        public AdjustOrder createFromParcel(Parcel source) {
            return new AdjustOrder(source);
        }

        @Override
        public AdjustOrder[] newArray(int size) {
            return new AdjustOrder[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long vendorId;//所属商家ID
    private String orderNo;//分店编码
    private String startDate;//生效时间
    private int adjusted;//是否已改价 1是 0否
    private int status;//单据状态 0-新建 1待审核 2已审核
    private int scopeFlag;//范围0-全部分店 1指定机构区域 2指定门店
    private String finalApprover;//最终审核人
    private String finalApproveTime;//最终审核时间
    private String memo;//备注
    private int df;//是否已删除1删除 0正常
    private String createDate;// 创建日期
    private String modifyDate;//修改日期
    private String creator;//记录创建人用户名
    private String mender;//最后修改人用户名
    private int version;//数据版本
    private String organCode;//创建者机构编码
    private String storeCode;//创建者门店编码
    private String adjustPrices;//调价价格选择，10个数字对应10个价格，1要显示 0不显示
    private int isupload;//是否上传 0未 1是


    private AdjustOrder(Builder builder) {
        vendorId = builder.vendorId;
        orderNo = builder.orderNo;
        startDate = builder.startDate;
        adjusted = builder.adjusted;
        status = builder.status;
        scopeFlag = builder.scopeFlag;
        finalApprover = builder.finalApprover;
        finalApproveTime = builder.finalApproveTime;
        memo = builder.memo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        creator = builder.creator;
        mender = builder.mender;
        version = builder.version;
        organCode = builder.organCode;
        storeCode = builder.storeCode;
        adjustPrices = builder.adjustPrices;
    }

    public AdjustOrder() {
    }

    protected AdjustOrder(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.orderNo = in.readString();
        this.startDate = in.readString();
        this.adjusted = in.readInt();
        this.status = in.readInt();
        this.scopeFlag = in.readInt();
        this.finalApprover = in.readString();
        this.finalApproveTime = in.readString();
        this.memo = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.creator = in.readString();
        this.mender = in.readString();
        this.version = in.readInt();
        this.organCode = in.readString();
        this.storeCode = in.readString();
        this.adjustPrices = in.readString();
        this.isupload = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.orderNo);
        dest.writeString(this.startDate);
        dest.writeInt(this.adjusted);
        dest.writeInt(this.status);
        dest.writeInt(this.scopeFlag);
        dest.writeString(this.finalApprover);
        dest.writeString(this.finalApproveTime);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeInt(this.version);
        dest.writeString(this.organCode);
        dest.writeString(this.storeCode);
        dest.writeString(this.adjustPrices);
        dest.writeInt(this.isupload);
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(int adjusted) {
        this.adjusted = adjusted;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getScopeFlag() {
        return scopeFlag;
    }

    public void setScopeFlag(int scopeFlag) {
        this.scopeFlag = scopeFlag;
    }

    public String getFinalApprover() {
        return finalApprover;
    }

    public void setFinalApprover(String finalApprover) {
        this.finalApprover = finalApprover;
    }

    public String getFinalApproveTime() {
        return finalApproveTime;
    }

    public void setFinalApproveTime(String finalApproveTime) {
        this.finalApproveTime = finalApproveTime;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getAdjustPrices() {
        return adjustPrices;
    }

    public void setAdjustPrices(String adjustPrices) {
        this.adjustPrices = adjustPrices;
    }

    public int getIsupload() {
        return isupload;
    }

    public void setIsupload(int isupload) {
        this.isupload = isupload;
    }

    public static final class Builder {
        private long vendorId;
        private String orderNo;
        private String startDate;
        private int adjusted;
        private int status;
        private int scopeFlag;
        private String finalApprover;
        private String finalApproveTime;
        private String memo;
        private int df;
        private String createDate;
        private String modifyDate;
        private String creator;
        private String mender;
        private int version;
        private String organCode;
        private String storeCode;
        private String adjustPrices;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder orderNo(String val) {
            orderNo = val;
            return this;
        }

        public Builder startDate(String val) {
            startDate = val;
            return this;
        }

        public Builder adjusted(int val) {
            adjusted = val;
            return this;
        }

        public Builder status(int val) {
            status = val;
            return this;
        }

        public Builder scopeFlag(int val) {
            scopeFlag = val;
            return this;
        }

        public Builder finalApprover(String val) {
            finalApprover = val;
            return this;
        }

        public Builder finalApproveTime(String val) {
            finalApproveTime = val;
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

        public Builder creator(String val) {
            creator = val;
            return this;
        }

        public Builder mender(String val) {
            mender = val;
            return this;
        }

        public Builder version(int val) {
            version = val;
            return this;
        }

        public Builder organCode(String val) {
            organCode = val;
            return this;
        }

        public Builder storeCode(String val) {
            storeCode = val;
            return this;
        }

        public Builder adjustPrices(String val) {
            adjustPrices = val;
            return this;
        }

        public AdjustOrder build() {
            return new AdjustOrder(this);
        }
    }
}
