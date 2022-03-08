package com.bitzh.finance.entity;

import java.util.Date;

public class ExceptionLog {
    private String excId;

    private String excName;

    private String operUsername;

    private String operMethod;

    private String operUrl;

    private String operIp;

    private Date operCreatetime;

    private String excRequparam;

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

    public String getOperUsername() {
        return operUsername;
    }

    public void setOperUsername(String operUsername) {
        this.operUsername = operUsername == null ? null : operUsername.trim();
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

    public Date getOperCreatetime() {
        return operCreatetime;
    }

    public void setOperCreatetime(Date operCreatetime) {
        this.operCreatetime = operCreatetime;
    }

    public String getExcRequparam() {
        return excRequparam;
    }

    public void setExcRequparam(String excRequparam) {
        this.excRequparam = excRequparam == null ? null : excRequparam.trim();
    }

    public String getExcMessage() {
        return excMessage;
    }

    public void setExcMessage(String excMessage) {
        this.excMessage = excMessage == null ? null : excMessage.trim();
    }
}