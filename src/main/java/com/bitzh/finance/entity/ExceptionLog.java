package com.bitzh.finance.entity;

public class ExceptionLog {
    private String excId;

    private String excName;

    private String operUserName;

    private String operMethod;

    private String operUrl;

    private String operIp;

    private String operCreateTime;

    private String excRequParam;

    private String excMessage;

    public String getExcId() {
        return excId;
    }

    public void setExcId(String excId) {
        this.excId = excId == null ? null : excId.trim();
    }

    public String getExcName() {
        return excName;
    }

    public void setExcName(String excName) {
        this.excName = excName == null ? null : excName.trim();
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName == null ? null : operUserName.trim();
    }

    public String getOperMethod() {
        return operMethod;
    }

    public void setOperMethod(String operMethod) {
        this.operMethod = operMethod == null ? null : operMethod.trim();
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl == null ? null : operUrl.trim();
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp == null ? null : operIp.trim();
    }

    public String getOperCreateTime() {
        return operCreateTime;
    }

    public void setOperCreateTime(String operCreateTime) {
        this.operCreateTime = operCreateTime == null ? null : operCreateTime.trim();
    }

    public String getExcRequParam() {
        return excRequParam;
    }

    public void setExcRequParam(String excRequParam) {
        this.excRequParam = excRequParam == null ? null : excRequParam.trim();
    }

    public String getExcMessage() {
        return excMessage;
    }

    public void setExcMessage(String excMessage) {
        this.excMessage = excMessage == null ? null : excMessage.trim();
    }
}