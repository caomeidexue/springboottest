package com.jiang.localspringbootdemo.entity;

import java.io.Serializable;
import java.util.Date;

public class OtimisticLockAccount implements Serializable {
    private Integer id;

    private String uniqueid;

    private Integer amount;

    private Integer versionAmount;

    private Integer cucurrentVersionAmount;

    private Date lastModifyTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getVersionAmount() {
        return versionAmount;
    }

    public void setVersionAmount(Integer versionAmount) {
        this.versionAmount = versionAmount;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCucurrentVersionAmount() {
        return cucurrentVersionAmount;
    }

    public void setCucurrentVersionAmount(Integer cucurrentVersionAmount) {
        this.cucurrentVersionAmount = cucurrentVersionAmount;
    }
}