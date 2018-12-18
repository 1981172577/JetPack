package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：系统常用参数
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "parameter",
        indices = {@Index(value = "pcode", name = "idx_sys_parameter_pcode", unique = true)})
public class Parameter implements Parcelable {
    public static final Creator<Parameter> CREATOR = new Creator<Parameter>() {
        @Override
        public Parameter createFromParcel(Parcel source) {
            return new Parameter(source);
        }

        @Override
        public Parameter[] newArray(int size) {
            return new Parameter[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;           //varchar(32) NOT NULL COMMENT '记录编号',
    private String createDate; //datetime DEFAULT NULL COMMENT '创建日期',
    private String modifyDate; //datetime DEFAULT NULL COMMENT '修改日期',
    private String pcode;      //varchar(64) DEFAULT NULL COMMENT '参数唯一性编码(多语言也用此字段)',
    private String cname;      //varchar(256) DEFAULT NULL COMMENT '中文描述',
    private String pvalue;     //varchar(1024) DEFAULT NULL COMMENT '参数值',
    private int pflag;         //int(11) DEFAULT '1' COMMENT '参数标志位， 不同参数不同作用',
    private String pmoudle;    //varchar(64) DEFAULT NULL COMMENT '参数所属模块',

    private Parameter(Builder builder) {
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        pcode = builder.pcode;
        cname = builder.cname;
        pvalue = builder.pvalue;
        pflag = builder.pflag;
        pmoudle = builder.pmoudle;
    }

    public Parameter() {
    }

    protected Parameter(Parcel in) {
        this.id = in.readLong();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
        this.pcode = in.readString();
        this.cname = in.readString();
        this.pvalue = in.readString();
        this.pflag = in.readInt();
        this.pmoudle = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getPmoudle() {
        return pmoudle;
    }

    public void setPmoudle(String pmoudle) {
        this.pmoudle = pmoudle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
        dest.writeString(this.pcode);
        dest.writeString(this.cname);
        dest.writeString(this.pvalue);
        dest.writeInt(this.pflag);
        dest.writeString(this.pmoudle);
    }

    public static final class Builder {
        private String createDate;
        private String modifyDate;
        private String pcode;
        private String cname;
        private String pvalue;
        private int pflag;
        private String pmoudle;

        public Builder() {
        }

        public Builder createDate(String val) {
            createDate = val;
            return this;
        }

        public Builder modifyDate(String val) {
            modifyDate = val;
            return this;
        }

        public Builder pcode(String val) {
            pcode = val;
            return this;
        }

        public Builder cname(String val) {
            cname = val;
            return this;
        }

        public Builder pvalue(String val) {
            pvalue = val;
            return this;
        }

        public Builder pflag(int val) {
            pflag = val;
            return this;
        }

        public Builder pmoudle(String val) {
            pmoudle = val;
            return this;
        }

        public Parameter build() {
            return new Parameter(this);
        }
    }
}
