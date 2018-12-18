package com.migrsoft.jetpack.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/11.
 */
@Entity(tableName = "menu",
        indices = {@Index(value = "menuCode", name = "idx_menu_menuCode", unique = true),
                @Index(value = "parentCode", name = "idx_menu_parentCode"),
                @Index(value = "sysCode", name = "idx_menu_sysCode")})
public class Menu implements Parcelable {
    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    private long id;           // bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    private String menuCode;   // varchar(16) NOT NULL COMMENT '菜单编码',
    private String menuName;   // varchar(32) NOT NULL COMMENT '菜单名称',
    private String menuUrl;    // varchar(64) DEFAULT NULL COMMENT '菜单访问URL',
    private int viewOrder;     // int(11) NOT NULL COMMENT '展示顺序',
    private int location;      // int(11) DEFAULT NULL COMMENT '显示位置0上 1下 2左 3右',
    private String parentCode; // varchar(16) DEFAULT NULL COMMENT '父级菜单编码',
    private String sysCode;    // varchar(16) DEFAULT NULL COMMENT '所属系统编码,取自字典表',
    private int menuLevel;     // int(11) NOT NULL COMMENT '菜单级别',
    private String logo;       // varchar(40) DEFAULT NULL COMMENT 'logo样式类型',
    private String memo;       // varchar(64) DEFAULT NULL COMMENT '备注',
    private int df;            // int(11) NOT NULL COMMENT '是否已删除1删除 0正常',
    private String createDate; // datetime NOT NULL COMMENT '创建日期',
    private String modifyDate; // datetime NOT NULL COMMENT '修改日期',

    public Menu() {
    }

    private Menu(Builder builder) {
        menuCode = builder.menuCode;
        menuName = builder.menuName;
        menuUrl = builder.menuUrl;
        viewOrder = builder.viewOrder;
        location = builder.location;
        parentCode = builder.parentCode;
        sysCode = builder.sysCode;
        menuLevel = builder.menuLevel;
        logo = builder.logo;
        df = builder.df;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
    }

    protected Menu(Parcel in) {
        this.id = in.readLong();
        this.menuCode = in.readString();
        this.menuName = in.readString();
        this.menuUrl = in.readString();
        this.viewOrder = in.readInt();
        this.location = in.readInt();
        this.parentCode = in.readString();
        this.sysCode = in.readString();
        this.menuLevel = in.readInt();
        this.logo = in.readString();
        this.memo = in.readString();
        this.df = in.readInt();
        this.createDate = in.readString();
        this.modifyDate = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMenuCode() {

        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getViewOrder() {
        return viewOrder;
    }

    public void setViewOrder(int viewOrder) {
        this.viewOrder = viewOrder;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.menuCode);
        dest.writeString(this.menuName);
        dest.writeString(this.menuUrl);
        dest.writeInt(this.viewOrder);
        dest.writeInt(this.location);
        dest.writeString(this.parentCode);
        dest.writeString(this.sysCode);
        dest.writeInt(this.menuLevel);
        dest.writeString(this.logo);
        dest.writeString(this.memo);
        dest.writeInt(this.df);
        dest.writeString(this.createDate);
        dest.writeString(this.modifyDate);
    }

    public static final class Builder {
        private String menuCode;
        private String menuName;
        private String menuUrl;
        private int viewOrder;
        private int location;
        private String parentCode;
        private String sysCode;
        private int menuLevel;
        private String logo;
        private int df;
        private String createDate;
        private String modifyDate;
        private int fontIcon;
        private String hotKey;
        private String hotCode;

        public Builder() {
        }

        public Builder menuCode(String val) {
            menuCode = val;
            return this;
        }

        public Builder menuName(String val) {
            menuName = val;
            return this;
        }

        public Builder menuUrl(String val) {
            menuUrl = val;
            return this;
        }

        public Builder viewOrder(int val) {
            viewOrder = val;
            return this;
        }

        public Builder location(int val) {
            location = val;
            return this;
        }

        public Builder parentCode(String val) {
            parentCode = val;
            return this;
        }

        public Builder sysCode(String val) {
            sysCode = val;
            return this;
        }

        public Builder menuLevel(int val) {
            menuLevel = val;
            return this;
        }

        public Builder logo(String val) {
            logo = val;
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

        public Builder fontIcon(int val) {
            fontIcon = val;
            return this;
        }

        public Builder hotKey(String val) {
            hotKey = val;
            return this;
        }

        public Builder hotCode(String val) {
            hotCode = val;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
