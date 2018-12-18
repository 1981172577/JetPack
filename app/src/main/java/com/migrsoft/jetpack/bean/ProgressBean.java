package com.migrsoft.jetpack.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 简介：更新／下载 进度Bean
 *
 * @author 王强（249346528@qq.com） 2017/9/4.
 */

public class ProgressBean implements Parcelable {
    public static final Creator<ProgressBean> CREATOR = new Creator<ProgressBean>() {
        @Override
        public ProgressBean createFromParcel(Parcel source) {
            return new ProgressBean(source);
        }

        @Override
        public ProgressBean[] newArray(int size) {
            return new ProgressBean[size];
        }
    };
    private int progress = 0;
    private int max = 0;
    private ProgressType type;

    private ProgressBean(Builder builder) {
        setProgress(builder.progress);
        setMax(builder.max);
        setType(builder.type);
    }

    public ProgressBean() {
    }


    protected ProgressBean(Parcel in) {
        this.progress = in.readInt();
        this.max = in.readInt();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : ProgressType.values()[tmpType];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ProgressType getType() {
        return type;
    }

    public void setType(ProgressType type) {
        this.type = type;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.progress);
        dest.writeInt(this.max);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
    }

    @Override
    public String toString() {
        return "ProgressBean{" +
                "progress=" + progress +
                ", max=" + max +
                ", type=" + (type == ProgressType.TYPE_DOWNLOADING ? "下载" : "处理") +
                '}';
    }

    public enum ProgressType {
        TYPE_DOWNLOADING,   //下载
        TYPE_HANDLING,      //处理
        TYPE_UPLOADING      //上传
    }

    public static final class Builder {
        private int progress;
        private int max;
        private ProgressType type;

        public Builder() {
        }

        public Builder progress(int val) {
            progress = val;
            return this;
        }

        public Builder max(int val) {
            max = val;
            return this;
        }

        public Builder type(ProgressType val) {
            type = val;
            return this;
        }

        public ProgressBean build() {
            return new ProgressBean(this);
        }
    }
}
