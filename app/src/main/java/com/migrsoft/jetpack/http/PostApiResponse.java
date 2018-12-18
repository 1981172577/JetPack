package com.migrsoft.jetpack.http;

/**
 * Filedescription.
 *
 * @author 张庆涛
 * @date 2017/11/2
 */

public class PostApiResponse {

    /**
     * returnCode : 返回结果码
     * returnMsg :  结果内容
     * dataCount : 0
     * returnData : null
     * returnObject : null
     */

    private int returnCode;
    private String returnMsg;
    private int dataCount;
    private String returnData;
    private Object returnObject;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public String toString() {
        return "returnCode = " + returnCode + ";returnMsg = " + returnMsg + ";returnData = " + returnData;
    }
}
