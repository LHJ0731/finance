package com.bitzh.finance.entity;

import java.util.Date;

public class OperationLog {
    private String operId;

    private String operModul;

    private String operType;

    private String operDesc;

    private String operUsername;

    private String operMethod;

    private String operUrl;

    private String operIp;

    private Date operCreatetime;

    private String operRequparam;

    private String operRespparam;

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getOperModul() {
        return operModul;
    }

    public void setOperModul(String operModul) {
        this.operModul = operModul == null ? null : operModul.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc == null ? null : operDesc.trim();
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

    public String getOperRequparam() {
        return operRequparam;
    }

    public void setOperRequparam(String operRequparam) {
        this.operRequparam = operRequparam == null ? null : operRequparam.trim();
    }

    public String getOperRespparam() {
        return operRespparam;
    }

    public void setOperRespparam(String operRespparam) {
        this.operRespparam = operRespparam == null ? null : operRespparam.trim();
    }
}