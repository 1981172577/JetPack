package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 简介：系统参数设置
 *
 * @author 王强（249346528@qq.com） 2017/8/10.
 */
@Entity(tableName = "saprameter",
        indices = {@Index(value = "subsysCode", name = "idx_sparameter_syscode")})
public class Sparameter implements Parcelable, Serializable {
    public static final Creator<Sparameter> CREATOR = new Creator<Sparameter>() {
        @Override
        public Sparameter createFromParcel(Parcel source) {
            return new Sparameter(source);
        }

        @Override
        public Sparameter[] newArray(int size) {
            return new Sparameter[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;            //  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    private long vendorId;      //  bigint(20) unsigned NOT NULL COMMENT '商家ID 0表示平台全局默认参数',
    private String paramCode;   //  varchar(16) NOT NULL COMMENT '参数编码',
    private String paramName;   //  varchar(64) NOT NULL COMMENT '参数名称',
    private String paramValue;  //  varchar(128) DEFAULT NULL COMMENT '参数值',
    private int usable;         //  tinyint(4) NOT NULL COMMENT '是否生效1是 0否',
    private String subsysCode;  //  varchar(16) NOT NULL COMMENT '参数所属子系统编码 取字典baseCode表',
    private int valueType;      //  tinyint(4) DEFAULT NULL COMMENT '值数据类型 0-字符 1数字 2日期 3下拉框',
    private String selCode;     //  varchar(16) DEFAULT NULL COMMENT '基本代码下拉框取值',
    private int visable;        //  tinyint(4) DEFAULT NULL COMMENT '商家是否可见 1是 0否',
    private int revisable;      //  tinyint(4) DEFAULT NULL COMMENT '商家是否可修改 1是 0否',
    private String memo;        //  varchar(32) DEFAULT NULL COMMENT '备注',
    private int df;             //  tinyint(4) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate;  //  datetime NOT NULL COMMENT '创建日期',
    private String modifyDate;  //  datetime NOT NULL COMMENT '修改日期',

    public Sparameter() {
    }


    private Sparameter(Builder builder) {
        vendorId = builder.vendorId;
        paramCode = builder.paramCode;
        paramName = builder.paramName;
        paramValue = builder.paramValue;
        usable = builder.usable;
        subsysCode = builder.subsysCode;
        valueType = builder.valueType;
        selCode = builder.selCode;
        visable = builder.visable;
        revisable = builder.revisable;
        memo = builder.memo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
    }

    protected Sparameter(Parcel in) {
        this.id = in.readLong();
        this.vendorId = in.readLong();
        this.paramCode = in.readString();
        this.paramName = in.readString();
        this.paramValue = in.readString();
        this.usable = in.readInt();
        this.subsysCode = in.readString();
        this.valueType = in.readInt();
        this.selCode = in.readString();
        this.visable = in.readInt();
        this.revisable = in.readInt();
        this.memo = in.readString();
        this.df = in.readInt();
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
        dest.writeString(this.paramCode);
        dest.writeString(this.paramName);
        dest.writeString(this.paramValue);
        dest.writeInt(this.usable);
        dest.writeString(this.subsysCode);
        dest.writeInt(this.valueType);
        dest.writeString(this.selCode);
        dest.writeInt(this.visable);
        dest.writeInt(this.revisable);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
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

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public int getUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

    public String getSubsysCode() {
        return subsysCode;
    }

    public void setSubsysCode(String subsysCode) {
        this.subsysCode = subsysCode;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public String getSelCode() {
        return selCode;
    }

    public void setSelCode(String selCode) {
        this.selCode = selCode;
    }

    public int getVisable() {
        return visable;
    }

    public void setVisable(int visable) {
        this.visable = visable;
    }

    public int getRevisable() {
        return revisable;
    }

    public void setRevisable(int revisable) {
        this.revisable = revisable;
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

    public static final class Builder {
        private long vendorId;
        private String paramCode;
        private String paramName;
        private String paramValue;
        private int usable;
        private String subsysCode;
        private int valueType;
        private String selCode;
        private int visable;
        private int revisable;
        private String memo;
        private int df;
        private String createDate;
        private String modifyDate;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder paramCode(String val) {
            paramCode = val;
            return this;
        }

        public Builder paramName(String val) {
            paramName = val;
            return this;
        }

        public Builder paramValue(String val) {
            paramValue = val;
            return this;
        }

        public Builder usable(int val) {
            usable = val;
            return this;
        }

        public Builder subsysCode(String val) {
            subsysCode = val;
            return this;
        }

        public Builder valueType(int val) {
            valueType = val;
            return this;
        }

        public Builder selCode(String val) {
            selCode = val;
            return this;
        }

        public Builder visable(int val) {
            visable = val;
            return this;
        }

        public Builder revisable(int val) {
            revisable = val;
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

        public Sparameter build() {
            return new Sparameter(this);
        }
    }
}
