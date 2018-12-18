package com.migrsoft.jetpack.bean;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/9/29.
 */

public class SyncResultBean {
    /**
     * true 成功
     */
    protected boolean status;
    /**
     * 消息
     */
    protected String message;

    protected SyncType type;

    public SyncResultBean() {
        this.type = SyncType.ALL;
    }

    public SyncType getType() {
        return type;
    }

    /**
     * 状态标示位
     *
     * @return true 成功
     */
    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 结果消息描述
     *
     * @return
     */
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SyncResultBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }

    public enum SyncType {
        /**
         * 同步 -- 下行
         */
        DOWN,
        /**
         * 同步 -- 上传
         */
        UP,
        /**
         * 同步 --（上行 + 下行）
         */
        ALL
    }
}
