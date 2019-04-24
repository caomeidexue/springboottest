package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class ZrSyncafaResult {
    private Integer id;

    private String uniqueBusinessId;

    private String status;

    private String errMsg;

    private String customerTrxId;

    private String trxNumber;

    private Date createTime;

    private Integer isDel;

    private Date lastModifyTime;

    private Integer isClose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueBusinessId() {
        return uniqueBusinessId;
    }

    public void setUniqueBusinessId(String uniqueBusinessId) {
        this.uniqueBusinessId = uniqueBusinessId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getCustomerTrxId() {
        return customerTrxId;
    }

    public void setCustomerTrxId(String customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public String getTrxNumber() {
        return trxNumber;
    }

    public void setTrxNumber(String trxNumber) {
        this.trxNumber = trxNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getIsClose() {
        return isClose;
    }

    public void setIsClose(Integer isClose) {
        this.isClose = isClose;
    }
}