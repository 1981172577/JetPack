package com.migrsoft.jetpack.bean;

/**
 * 简介：数据同步-下载，请求参数
 *
 * @author 王强（249346528@qq.com） 2017/10/11.
 */

public class SyncParamsForDownload {
    private long vendorId;
    private String posCode;
    /**
     * 要同步的表，以"，"分割
     */
    private String dbType;
    /**
     * 同步开始时间，等于上次同步的结束时间，也是以"，"分割，数量等于dbType的数量
     */
    private String startDate;
    /**
     * 同步结束时间，同startDate
     */
    private String endDate;

    /**
     * 同步次数，用于分批次（分页）请求，每次同步(全量/增量同步)都是从0开始
     */
    private String syncTimeCount;

    private SyncParamsForDownload(Builder builder) {
        vendorId = builder.vendorId;
        posCode = builder.posCode;
        dbType = builder.dbType;
        startDate = builder.startDate;
        endDate = builder.endDate;
        syncTimeCount = builder.syncTimeCount;
    }


    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSyncTimeCount() {
        return syncTimeCount;
    }

    public void setSyncTimeCount(String syncTimeCount) {
        this.syncTimeCount = syncTimeCount;
    }

    public static final class Builder {
        private long vendorId;
        private String posCode;
        private String dbType;
        private String startDate;
        private String endDate;
        private String syncTimeCount;

        public Builder() {
        }

        public Builder vendorId(long val) {
            vendorId = val;
            return this;
        }

        public Builder posCode(String val) {
            posCode = val;
            return this;
        }

        public Builder dbType(String val) {
            dbType = val;
            return this;
        }

        public Builder startDate(String val) {
            startDate = val;
            return this;
        }

        public Builder endDate(String val) {
            endDate = val;
            return this;
        }

        public Builder syncTimeCount(String val) {
            syncTimeCount = val;
            return this;
        }

        public SyncParamsForDownload build() {
            return new SyncParamsForDownload(this);
        }
    }
}
