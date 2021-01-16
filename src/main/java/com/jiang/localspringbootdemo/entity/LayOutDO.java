package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class LayOutDO {
    private Long id;

    private String warehouseCode;

    private String warehouseName;

    private Long businessMode;

    private String layoutUrl;

    private Byte existedLayout;

    private Byte enabledDms;

    private Byte layoutStatus;

    private Long createUserId;

    private String createUserName;

    private Date createTime;

    private Long updateUserId;

    private String updateUserName;

    private Date updateTime;

    private String layoutData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getBusinessMode() {
        return businessMode;
    }

    public void setBusinessMode(Long businessMode) {
        this.businessMode = businessMode;
    }

    public String getLayoutUrl() {
        return layoutUrl;
    }

    public void setLayoutUrl(String layoutUrl) {
        this.layoutUrl = layoutUrl;
    }

    public Byte getExistedLayout() {
        return existedLayout;
    }

    public void setExistedLayout(Byte existedLayout) {
        this.existedLayout = existedLayout;
    }

    public Byte getEnabledDms() {
        return enabledDms;
    }

    public void setEnabledDms(Byte enabledDms) {
        this.enabledDms = enabledDms;
    }

    public Byte getLayoutStatus() {
        return layoutStatus;
    }

    public void setLayoutStatus(Byte layoutStatus) {
        this.layoutStatus = layoutStatus;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLayoutData() {
        return layoutData;
    }

    public void setLayoutData(String layoutData) {
        this.layoutData = layoutData;
    }
}