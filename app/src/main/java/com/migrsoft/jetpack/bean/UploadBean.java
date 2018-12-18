package com.migrsoft.jetpack.bean;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/13.
 */

public class UploadBean {
    private String ujson;
    private String utype;

    public UploadBean() {
    }

    private UploadBean(Builder builder) {
        setUjson(builder.ujson);
        setUtype(builder.utype);
    }

    public String getUjson() {
        return ujson;
    }

    public void setUjson(String ujson) {
        this.ujson = ujson;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    @Override
    public String toString() {
        return "UploadBean{" +
                "ujson='" + ujson + '\'' +
                ", utype='" + utype + '\'' +
                '}';
    }

    public static final class Builder {
        private String ujson;
        private String utype;

        public Builder() {
        }

        public Builder ujson(String val) {
            ujson = val;
            return this;
        }

        public Builder utype(String val) {
            utype = val;
            return this;
        }

        public UploadBean build() {
            return new UploadBean(this);
        }
    }
}
