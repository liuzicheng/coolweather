package com.liu.coolweather.model;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public enum RequestKeyStatusEnum {

    OK(0,"ok","数据正常"),
    INVALID_KEY(1,"invalid key","错误的key"),
    UNKNOWN_CITY(2,"unknown city","未知或错误城市"),
    NO_MORE_REQUESTS(3,"no more requests","超过访问次数"),
    PARAM_INVALID(4,"param invalid","参数错误"),
    VIP_OVER(5,"vip over","付费账号过期"),
    ANR(6,"anr","无响应或超时"),
    PERMISSION_DENIED(7,"permission denied","无访问权限，如免费key强制获取付费数据或获取未购买的付费数据");

    private int keyId;
    private String status;
    private String explanation;

    RequestKeyStatusEnum(int keyId, String status, String explanation) {
        this.keyId = keyId;
        this.status = status;
        this.explanation = explanation;
    }

    public static String getExplan(int index){
        for (RequestKeyStatusEnum rse : RequestKeyStatusEnum.values()){
            if (rse.keyId == index){
                return rse.explanation;
            }
        }
        return null;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
