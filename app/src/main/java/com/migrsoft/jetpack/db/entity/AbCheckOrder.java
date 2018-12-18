package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "abcheckorder",
        indices = {@Index(value = {"vendorId", "taskNo", "orderNo"}, unique = true)})
public class AbCheckOrder implements Parcelable {
    public static final Creator<AbCheckOrder> CREATOR = new Creator<AbCheckOrder>() {
        @Override
        public AbCheckOrder createFromParcel(Parcel source) {
            return new AbCheckOrder(source);
        }

        @Override
        public AbCheckOrder[] newArray(int size) {
            return new AbCheckOrder[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;//记录ID
    private long vendorId;//商家ID
    private String taskNo;//盘点任务号
    private String orderNo;//盘点单据号
    private String shelfNo;//储位号
    private String shelfArea;//储位区域
    private String bizDate;//单据时间
    private String srcPos;//数据来源终端编号
    private String startCheckDate;//盘点开始时间
    private String endCheckDate;//盘点结束时间
    private long timeConsume;//耗时(分)
    private int orderType;//单据类型 0-条码板  1初盘A盘   2 初盘B盘  3复盘单   4漏盘单
    private int firstFlag;//是否有条码板 0否   1 是
    private String organCode;//机构编码
    private String organName;//机构名称
    private String storeCode;//盘点仓库编码
    private String storeName;//仓库名称
    private int status;//单据状态  0已保存 1审核中 2审核通过 3已驳回 4已终止
    private int taskStatus;//任务状态 0未启动  1已启动  2已完成
    private double orderAcount;//单据商品总数
    private double orderKinds;//商品种数
    private String approver;//最后审核人
    private String approverTime;//最后审核时间
    private String memo;//备注
    private String creator;//创建者
    private String checkMan;//盘点人
    private String checkNick;//盘点人姓名
    private String mender;//最后修改人
    private int df;//是否已删除1删除 0正常
    private String createDate;//创建日期
    private String modifyDate;//修改日期
    private int version;//数据版本
    private int checkType;//盘点类型 0 全场 1单品盘点 2品牌盘点 3品类盘点
    private int uploadCount;

    public AbCheckOrder() {
    }


    private AbCheckOrder(Builder builder) {
        setVendorId(builder.vendorId);
        setTaskNo(builder.taskNo);
        setOrderNo(builder.orderNo);
        setShelfNo(builder.shelfNo);
        setShelfArea(builder.shelfArea);
        setBizDate(builder.bizDate);
        setSrcPos(builder.srcPos);
        setStartCheckDate(builder.startCheckDate);
        setEndCheckDate(builder.endCheckDate);
        setTimeConsume(builder.timeConsume);
        setOrderType(builder.orderType);
        setFirstFlag(builder.firstFlag);
        setOrganCode(builder.organCode);
        setOrganName(builder.organName);
        setStoreCode(builder.storeCode);
        setStoreName(builder.storeName);
        setStatus(builder.status);
        setTaskStatus(builder.taskStatus);
        setOrderAcount(builder.orderAcount);
        setOrderKinds(builder.orderKinds);
        setApprover(builder.approver);
        setApproverTime(builder.approverTime);
        setMemo(builder.memo);
        setCreator(builder.creator);
        setCheckMan(builder.checkMan);
        setCheckNick(builder.checkNick);
        setMender(builder.mender);
        setDf(builder.df);
        setCreateDate(builder.createDate);
        setModifyDate(builder.modifyDate);
        setVersion(builder.version);
        setCheckType(builder.checkType);
        setUploadCount(builder.uploadCount);
    }

    protected AbCheckOrder(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.taskNo = in.readString();
        this.orderNo = in.readString();
        this.shelfNo = in.readString();
        this.shelfArea = in.readString();
        this.bizDate = in.readString();
        this.srcPos = in.readString();
        this.startCheckDate = in.readString();
        this.endCheckDate = in.readString();
        this.timeConsume = in.readLong();
        this.orderType = in.readInt();
        this.firstFlag = in.readInt();
        this.organCode = in.readString();
        this.organName = in.readString();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.status = in.readInt();
        this.taskStatus = in.readInt();
        this.orderAcount = in.readDouble();
        this.orderKinds = in.readDouble();
        this.approver = in.readString();
        this.approverTime = in.readString();
        this.memo = in.readString();
        this.creator = in.readString();
        this.checkMan = in.readString();
        this.checkNick = in.readString();
        this.mender = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.checkType = in.readInt();
        this.uploadCount = in.readInt();
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
        dest.writeString(this.shelfNo);
        dest.writeString(this.shelfArea);
        dest.writeString(this.bizDate);
        dest.writeString(this.srcPos);
        dest.writeString(this.startCheckDate);
        dest.writeString(this.endCheckDate);
        dest.writeLong(this.timeConsume);
        dest.writeInt(this.orderType);
        dest.writeInt(this.firstFlag);
        dest.writeString(this.organCode);
        dest.writeString(this.organName);
        dest.writeString(this.storeCode);
        dest.writeString(this.storeName);
        dest.writeInt(this.status);
        dest.writeInt(this.taskStatus);
        dest.writeDouble(this.orderAcount);
        dest.writeDouble(this.orderKinds);
        dest.writeString(this.approver);
        dest.writeString(this.approverTime);
        dest.writeString(this.memo);
        dest.writeString(this.creator);
        dest.writeString(this.checkMan);
        dest.writeString(this.checkNick);
        dest.writeString(this.mender);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeInt(this.checkType);
        dest.writeInt(this.uploadCount);
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
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

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getSrcPos() {
        return srcPos;
    }

    public void setSrcPos(String srcPos) {
        this.srcPos = srcPos;
    }

    public String getStartCheckDate() {
        return startCheckDate;
    }

    public void setStartCheckDate(String startCheckDate) {
        this.startCheckDate = startCheckDate;
    }

    public String getEndCheckDate() {
        return endCheckDate;
    }

    public void setEndCheckDate(String endCheckDate) {
        this.endCheckDate = endCheckDate;
    }

    public long getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(long timeConsume) {
        this.timeConsume = timeConsume;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getFirstFlag() {
        return firstFlag;
    }

    public void setFirstFlag(int firstFlag) {
        this.firstFlag = firstFlag;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public double getOrderAcount() {
        return orderAcount;
    }

    public void setOrderAcount(double orderAcount) {
        this.orderAcount = orderAcount;
    }

    public double getOrderKinds() {
        return orderKinds;
    }

    public void setOrderKinds(double orderKinds) {
        this.orderKinds = orderKinds;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproverTime() {
        return approverTime;
    }

    public void setApproverTime(String approverTime) {
        this.approverTime = approverTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
    }

    public int getUploadCount() {
        return uploadCount;
    }

    public void setUploadCount(int uploadCount) {
        this.uploadCount = uploadCount;
    }


    public static final class Builder {
        private long vendorId;
        private String taskNo;
        private String orderNo;
        private String shelfNo;
        private String shelfArea;
        private String bizDate;
        private String srcPos;
        private String startCheckDate;
        private String endCheckDate;
        private long timeConsume;
        private int orderType;
        private int firstFlag;
        private String organCode;
        private String organName;
        private String storeCode;
        private String storeName;
        private int status;
        private int taskStatus;
        private double orderAcount;
        private double orderKinds;
        private String approver;
        private String approverTime;
        private String memo;
        private String creator;
        private String checkMan;
        private String checkNick;
        private String mender;
        private int df;
        private String createDate;
        private String modifyDate;
        private int version;
        private int checkType;
        private int uploadCount;

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

        public Builder orderNo(String val) {
            orderNo = val;
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

        public Builder bizDate(String val) {
            bizDate = val;
            return this;
        }

        public Builder srcPos(String val) {
            srcPos = val;
            return this;
        }

        public Builder startCheckDate(String val) {
            startCheckDate = val;
            return this;
        }

        public Builder endCheckDate(String val) {
            endCheckDate = val;
            return this;
        }

        public Builder timeConsume(long val) {
            timeConsume = val;
            return this;
        }

        public Builder orderType(int val) {
            orderType = val;
            return this;
        }

        public Builder firstFlag(int val) {
            firstFlag = val;
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

        public Builder status(int val) {
            status = val;
            return this;
        }

        public Builder taskStatus(int val) {
            taskStatus = val;
            return this;
        }

        public Builder orderAcount(double val) {
            orderAcount = val;
            return this;
        }

        public Builder orderKinds(double val) {
            orderKinds = val;
            return this;
        }

        public Builder approver(String val) {
            approver = val;
            return this;
        }

        public Builder approverTime(String val) {
            approverTime = val;
            return this;
        }

        public Builder memo(String val) {
            memo = val;
            return this;
        }

        public Builder creator(String val) {
            creator = val;
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

        public Builder checkType(int val) {
            checkType = val;
            return this;
        }

        public Builder uploadCount(int val) {
            uploadCount = val;
            return this;
        }

        public AbCheckOrder build() {
            return new AbCheckOrder(this);
        }
    }
}
