package com.bitzh.finance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserTermFinancial {
    private Integer id;

    private Integer userid;

    private com.bitzh.finance.entity.User user;

    private Integer termid;

    private com.bitzh.finance.entity.TermFinancial termFinancial;

    private Date starttime;

    private BigDecimal averyield;

    private BigDecimal profit;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public BigDecimal getAveryield() {
        return averyield;
    }

    public void setAveryield(BigDecimal averyield) {
        this.averyield = averyield;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public com.bitzh.finance.entity.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.bitzh.finance.entity.TermFinancial getTermFinancial() {
        return termFinancial;
    }

    public void setTermFinancial(TermFinancial termFinancial) {
        this.termFinancial = termFinancial;
    }
}