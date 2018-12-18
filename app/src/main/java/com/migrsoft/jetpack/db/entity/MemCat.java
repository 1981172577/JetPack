package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：会员类别
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "memcat",
        indices = {@Index(value = {"vendorId", "catCode"}, name = "idx_memCat_ids")})
public class MemCat implements Parcelable {
    public static final Creator<MemCat> CREATOR = new Creator<MemCat>() {
        @Override
        public MemCat createFromParcel(Parcel source) {
            return new MemCat(source);
        }

        @Override
        public MemCat[] newArray(int size) {
            return new MemCat[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;                // bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private long vendorId;          // bigint(20) unsigned NOT NULL COMMENT '商家ID',
    private String catCode;         // varchar(16) NOT NULL COMMENT '类别编码',
    private String catName;         // varchar(32) NOT NULL COMMENT '类别名称',
    private int doScore;            // tinyint(4) NOT NULL COMMENT '是否积分 1是 0否',
    private int onsaleType;         // tinyint(4) DEFAULT NULL COMMENT '会员基准价  0零售价  1会员价  2会员价1  3会员价2  4批发价',
    private double rate;            // double(16,5) DEFAULT NULL COMMENT '折扣',
    private int need;               // tinyint(4) NOT NULL COMMENT '是否需要办理条件 1是 0否',
    private double greaterAmount;   // double(16,5) DEFAULT NULL COMMENT '消费金额大于',
    private int combineFlag;        // tinyint(4) DEFAULT NULL COMMENT '条件拼接标记 0或1且',
    private double greaterNum;      // double(16,5) DEFAULT NULL COMMENT '消费数量大于',
    private double pointAmount;     // double(16,5) DEFAULT '0.00000' COMMENT '积分满额（会员升级用）',
    private double consumeAmount;   // double(16,5) DEFAULT '0.00000' COMMENT '消费满额（会员升级用）',
    private double rechargeAmount;  // double(16,5) DEFAULT '0.00000' COMMENT '充值满额（会员升级用）',
    private int needPwdFlag;        // tinyint(4) DEFAULT '0' COMMENT '0不需要密码 1表示需要密码',
    private int df;                 // tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String memo;            // varchar(32) DEFAULT NULL COMMENT '备注',
    private String createDate;      // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;      // datetime NOT NULL COMMENT '修改日期',

    public MemCat() {
    }


    private MemCat(Builder builder) {
        vendorId = builder.vendorId;
        catCode = builder.catCode;
        catName = builder.catName;
        doScore = builder.doScore;
        onsaleType = builder.onsaleType;
        rate = builder.rate;
        need = builder.need;
        greaterAmount = builder.greaterAmount;
        combineFlag = builder.combineFlag;
        greaterNum = builder.greaterNum;
        pointAmount = builder.pointAmount;
        consumeAmount = builder.consumeAmount;
        rechargeAmount = builder.rechargeAmount;
        needPwdFlag = builder.needPwdFlag;
        df = builder.df;
        memo = builder.memo;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
    }

    protected MemCat(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.catCode = in.readString();
        this.catName = in.readString();
        this.doScore = in.readInt();
        this.onsaleType = in.readInt();
        this.rate = in.readDouble();
        this.need = in.readInt();
        this.greaterAmount = in.readDouble();
        this.combineFlag = in.readInt();
        this.greaterNum = in.readDouble();
        this.pointAmount = in.readDouble();
        this.consumeAmount = in.readDouble();
        this.rechargeAmount = in.readDouble();
        this.needPwdFlag = in.readInt();
        this.df = in.readInt();
        this.memo = in.readString();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.vendorId);
        dest.writeString(this.catCode);
        dest.writeString(this.catName);
        dest.writeInt(this.doScore);
        dest.writeInt(this.onsaleType);
        dest.writeDouble(this.rate);
        dest.writeInt(this.need);
        dest.writeDouble(this.greaterAmount);
        dest.writeInt(this.combineFlag);
        dest.writeDouble(this.greaterNum);
        dest.writeDouble(this.pointAmount);
        dest.writeDouble(this.consumeAmount);
        dest.writeDouble(this.rechargeAmount);
        dest.writeInt(this.needPwdFlag);
        dest.writeInt(this.df);
        dest.writeString(this.memo);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
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

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getDoScore() {
        return doScore;
    }

    public void setDoScore(int doScore) {
        this.doScore = doScore;
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

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public double getGreaterAmount() {
        return greaterAmount;
    }

    public void setGreaterAmount(double greaterAmount) {
        this.greaterAmount = greaterAmount;
    }

    public int getCombineFlag() {
        return combineFlag;
    }

    public void setCombineFlag(int combineFlag) {
        this.combineFlag = combineFlag;
    }

    public double getGreaterNum() {
        return greaterNum;
    }

    public void setGreaterNum(double greaterNum) {
        this.greaterNum = greaterNum;
    }

    public double getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(double pointAmount) {
        this.pointAmount = pointAmount;
    }

    public double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public int getNeedPwdFlag() {
        return needPwdFlag;
    }

    public void setNeedPwdFlag(int needPwdFlag) {
        this.needPwdFlag = needPwdFlag;
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

    public static final class Builder {
        private long vendorId;
        private String catCode;
        private String catName;
        private int doScore;
        private int onsaleType;
        private double rate;
        private int need;
        private double greaterAmount;
        private int combineFlag;
        private double greaterNum;
        private double pointAmount;
        private double consumeAmount;
        private double rechargeAmount;
        private int needPwdFlag;
        private int df;
        private String memo;
        private String createDate;
        private String modifyDate;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder catCode(String val) {
            catCode = val;
            return this;
        }

        public Builder catName(String val) {
            catName = val;
            return this;
        }

        public Builder doScore(int val) {
            doScore = val;
            return this;
        }

        public Builder onsaleType(int val) {
            onsaleType = val;
            return this;
        }

        public Builder rate(double val) {
            rate = val;
            return this;
        }

        public Builder need(int val) {
            need = val;
            return this;
        }

        public Builder greaterAmount(double val) {
            greaterAmount = val;
            return this;
        }

        public Builder combineFlag(int val) {
            combineFlag = val;
            return this;
        }

        public Builder greaterNum(double val) {
            greaterNum = val;
            return this;
        }

        public Builder pointAmount(double val) {
            pointAmount = val;
            return this;
        }

        public Builder consumeAmount(double val) {
            consumeAmount = val;
            return this;
        }

        public Builder rechargeAmount(double val) {
            rechargeAmount = val;
            return this;
        }

        public Builder needPwdFlag(int val) {
            needPwdFlag = val;
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

        public MemCat build() {
            return new MemCat(this);
        }
    }
}
