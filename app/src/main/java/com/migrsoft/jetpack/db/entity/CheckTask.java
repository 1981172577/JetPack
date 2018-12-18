package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：盘点任务表
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "checktask",
        indices = {@Index(value = {"vendorId", "taskNo"}, unique = true)})
public class CheckTask implements Parcelable {
    public static final Creator<CheckTask> CREATOR = new Creator<CheckTask>() {
        @Override
        public CheckTask createFromParcel(Parcel source) {
            return new CheckTask(source);
        }

        @Override
        public CheckTask[] newArray(int size) {
            return new CheckTask[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;               // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;         // bigint(20) unsigned NOT NULL COMMENT '商家ID',
    private String taskNo;         // varchar(16) NOT NULL COMMENT '盘点任务号',
    private int checkType;         // tinyint(4) NOT NULL COMMENT '盘点类型 0 全场 1单品 2品牌 3品类',
    private String organCode;      // varchar(16) NOT NULL COMMENT '机构编码',
    private String organName;      // varchar(64) NOT NULL COMMENT '机构名称',
    private String storeCode;      // varchar(16) NOT NULL COMMENT '盘点仓库编码',
    private String storeName;      // varchar(64) DEFAULT NULL COMMENT '仓库名称',
    private String objectCode;     // varchar(8000) DEFAULT NULL COMMENT '盘点目标编码 根据类型决定品牌 品类 商品',
    private String objectName;     // text COMMENT '盘点目标名称 根据类型决定品牌 品类 商品',
    private int checkStatus;       // tinyint(4) DEFAULT NULL COMMENT '任务状态  0 盘点中 1已结束 2已终止',
    private int status;            // tinyint(4) NOT NULL DEFAULT '0' COMMENT '审核状态  0已保存  1审核中  2已审核   3已终止',
    private String approver;       // varchar(32) DEFAULT NULL COMMENT '最后审核人',
    private String approverTime;   // datetime DEFAULT NULL COMMENT '最后审核时间',
    private int referenced;        // tinyint(4) DEFAULT '0' COMMENT '是否被差异单引用 1是 0否',
    private String memo;           // varchar(64) DEFAULT NULL COMMENT '备注',
    private String creator;        // varchar(32) NOT NULL COMMENT '创建者',
    private String mender;         // varchar(32) DEFAULT NULL COMMENT '最后修改人',
    private int df;                // tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除1删除 0正常',
    private String createDate;     // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;     // datetime NOT NULL COMMENT '修改日期',
    private int version;           // int(10) unsigned NOT NULL DEFAULT '0' COMMENT '数据版本',
    private String bizDate;        // datetime DEFAULT NULL COMMENT '单据时间',
    private int locked;            // tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已锁定单据 0 未锁定 1 已锁定',
    private String balanceDate;    // datetime DEFAULT NULL COMMENT '月结存时间',
    private String menderName;     // varchar(32) DEFAULT NULL COMMENT '最后修改人真实姓名',
    private String approverName;   // varchar(32) DEFAULT NULL COMMENT '审核人真实姓名',
    private String creatorName;    // varchar(32) DEFAULT NULL COMMENT '制单人真实姓名',
    private String sysMemo;        // varchar(128) DEFAULT NULL COMMENT '系统备注',
    private String approveOpinion; // varchar(256) DEFAULT NULL COMMENT '审批意见',

    public CheckTask() {
    }

    private CheckTask(Builder builder) {
        vendorId = builder.vendorId;
        taskNo = builder.taskNo;
        checkType = builder.checkType;
        organCode = builder.organCode;
        organName = builder.organName;
        storeCode = builder.storeCode;
        storeName = builder.storeName;
        objectCode = builder.objectCode;
        objectName = builder.objectName;
        checkStatus = builder.checkStatus;
        status = builder.status;
        approver = builder.approver;
        approverTime = builder.approverTime;
        referenced = builder.referenced;
        memo = builder.memo;
        creator = builder.creator;
        mender = builder.mender;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        version = builder.version;
        bizDate = builder.bizDate;
        locked = builder.locked;
        balanceDate = builder.balanceDate;
        menderName = builder.menderName;
        approverName = builder.approverName;
        creatorName = builder.creatorName;
        sysMemo = builder.sysMemo;
        approveOpinion = builder.approveOpinion;
    }

    protected CheckTask(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.taskNo = in.readString();
        this.checkType = in.readInt();
        this.organCode = in.readString();
        this.organName = in.readString();
        this.storeCode = in.readString();
        this.storeName = in.readString();
        this.objectCode = in.readString();
        this.objectName = in.readString();
        this.checkStatus = in.readInt();
        this.status = in.readInt();
        this.approver = in.readString();
        this.approverTime = in.readString();
        this.referenced = in.readInt();
        this.memo = in.readString();
        this.creator = in.readString();
        this.mender = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.version = in.readInt();
        this.bizDate = in.readString();
        this.locked = in.readInt();
        this.balanceDate = in.readString();
        this.menderName = in.readString();
        this.approverName = in.readString();
        this.creatorName = in.readString();
        this.sysMemo = in.readString();
        this.approveOpinion = in.readString();
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

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getReferenced() {
        return referenced;
    }

    public void setReferenced(int referenced) {
        this.referenced = referenced;
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

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getMenderName() {
        return menderName;
    }

    public void setMenderName(String menderName) {
        this.menderName = menderName;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getSysMemo() {
        return sysMemo;
    }

    public void setSysMemo(String sysMemo) {
        this.sysMemo = sysMemo;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
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
        dest.writeString(this.organCode);
        dest.writeString(this.organName);
        dest.writeString(this.storeCode);
        dest.writeString(this.storeName);
        dest.writeString(this.objectCode);
        dest.writeString(this.objectName);
        dest.writeInt(this.checkStatus);
        dest.writeInt(this.status);
        dest.writeString(this.approver);
        dest.writeString(this.approverTime);
        dest.writeInt(this.referenced);
        dest.writeString(this.memo);
        dest.writeString(this.creator);
        dest.writeString(this.mender);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeInt(this.version);
        dest.writeString(this.bizDate);
        dest.writeInt(this.locked);
        dest.writeString(this.balanceDate);
        dest.writeString(this.menderName);
        dest.writeString(this.approverName);
        dest.writeString(this.creatorName);
        dest.writeString(this.sysMemo);
        dest.writeString(this.approveOpinion);
    }

    public static final class Builder {
        private long vendorId;
        private String taskNo;
        private int checkType;
        private String organCode;
        private String organName;
        private String storeCode;
        private String storeName;
        private String objectCode;
        private String objectName;
        private int checkStatus;
        private int status;
        private String approver;
        private String approverTime;
        private int referenced;
        private String memo;
        private String creator;
        private String mender;
        private int df;
        private String createDate;
        private String modifyDate;
        private int version;
        private String bizDate;
        private int locked;
        private String balanceDate;
        private String menderName;
        private String approverName;
        private String creatorName;
        private String sysMemo;
        private String approveOpinion;

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

        public Builder objectCode(String val) {
            objectCode = val;
            return this;
        }

        public Builder objectName(String val) {
            objectName = val;
            return this;
        }

        public Builder checkStatus(int val) {
            checkStatus = val;
            return this;
        }

        public Builder status(int val) {
            status = val;
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

        public Builder referenced(int val) {
            referenced = val;
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

        public Builder bizDate(String val) {
            bizDate = val;
            return this;
        }

        public Builder locked(int val) {
            locked = val;
            return this;
        }

        public Builder balanceDate(String val) {
            balanceDate = val;
            return this;
        }

        public Builder menderName(String val) {
            menderName = val;
            return this;
        }

        public Builder approverName(String val) {
            approverName = val;
            return this;
        }

        public Builder creatorName(String val) {
            creatorName = val;
            return this;
        }

        public Builder sysMemo(String val) {
            sysMemo = val;
            return this;
        }

        public Builder approveOpinion(String val) {
            approveOpinion = val;
            return this;
        }

        public CheckTask build() {
            return new CheckTask(this);
        }
    }
}
