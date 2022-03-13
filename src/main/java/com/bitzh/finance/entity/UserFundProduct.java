package com.bitzh.finance.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserFundProduct {
    private Integer id;

    private Integer userid;

    private com.bitzh.finance.entity.User user;

    private Integer fundid;

    private com.bitzh.finance.entity.FundProduct fundProduct;

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

    public Integer getFundid() {
        return fundid;
    }

    public void setFundid(Integer fundid) {
        this.fundid = fundid;
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

    public com.bitzh.finance.entity.FundProduct getFundProduct() {
        return fundProduct;
    }

    public void setFundProduct(FundProduct fundProduct) {
        this.fundProduct = fundProduct;
    }
}