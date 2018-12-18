package com.migrsoft.jetpack.api;

import com.migrsoft.jetpack.BuildConfig;
import com.migrsoft.jetpack.db.entity.Register;
import com.migrsoft.jetpack.http.ApiResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PosApi {
    /**
     * 同步服务端数据到本地
     *
     * @param vendorId      商家ID
     * @param posCode       终端编码
     * @param dbTypes       同步的数据组
     * @param syncTimeCount 数据分批的次数
     * @param startDateStr  请求数据最后同步成功的开始时间
     * @param endDateStr    请求数据最后同步成功的结束时间
     * @return
     */
    @GET("/sync/getDataForPos/")
    Call<String> syncData(@Query("vendorId") long vendorId,
                          @Query("posCode") String posCode,
                          @Query("dbtypes") String dbTypes,
                          @Query("syncTimeCount") String syncTimeCount,
                          @Query("syncTimeStr") String startDateStr,
                          @Query("syncendTimeStr") String endDateStr);

    /**
     * 上传非业务类单据
     *
     * @param posDate
     * @param vendorId
     * @param posCode    rcode
     * @param uploadStr  数据（urlencode）
     * @param appVersion appversionName
     * @param sType      数据来源Android = 1
     * @return
     */
    @FormUrlEncoded
    @POST("/sync/uploadForOtherBusiness/")
    Call<ApiResponse<String>> uploadOtherBusiness(@Query("posDate") String posDate,
                                                  @Query("vendorId") long vendorId,
                                                  @Query("posCode") String posCode,
                                                  @Query("posVersion") String appVersion,
                                                  @Query("stype") String sType,
                                                  @Field("uploadStr") String uploadStr);


    /**
     * 上传业务数据
     *
     * @param posDate
     * @param vendorId
     * @param posCode      rcode
     * @param posVersion   appversionName
     * @param stype        数据来源Android = 1
     * @param saleorderStr 数据（urlencode）
     * @return
     */
    @FormUrlEncoded
    @POST("/sync/uploadSaleorder/")
    Call<ApiResponse<String>> uploadSaleOrder(@Query("posDate") String posDate,
                                              @Query("vendorId") long vendorId,
                                              @Query("posCode") String posCode,
                                              @Query("posVersion") String posVersion,
                                              @Query("stype") String stype,
                                              @Field("saleorderStr") String saleorderStr);

    class UploadBody {
        private long vendorId;
        private String posCode;
        private String uploadStr;
        private String posVersion;
        private String stype;

        public UploadBody(Register register, String uploadStr) {
            this.vendorId = register.getVendorId();
            this.posCode = register.getRcode();
            this.uploadStr = uploadStr;
            this.posVersion = BuildConfig.VERSION_NAME;
            this.stype = "1";
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

        public String getUploadStr() {
            return uploadStr;
        }

        public void setUploadStr(String uploadStr) {
            this.uploadStr = uploadStr;
        }

        public String getPosVersion() {
            return posVersion;
        }

        public void setPosVersion(String posVersion) {
            this.posVersion = posVersion;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }
    }
}
