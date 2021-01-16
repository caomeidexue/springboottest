package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class DeliveryBox {
    private Integer id;

    private String deliverBoxNo;

    private String containerNo;

    private Byte bussinessType;

    private Byte boxType;

    private String parentContainerNo;

    private String reciverName;

    private String groupStr;

    private Byte boxStatus;

    private Byte deliveryBoxStatus;

    private Integer waybillId;

    private String waybillNo;

    private Date bindTime;

    private String bindOperator;

    private Integer boxFullQty;

    private String bigWarehouseNo;

    private String shipperCode;

    private String createUserLoginName;

    private String updateUserLoginName;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliverBoxNo() {
        return deliverBoxNo;
    }

    public void setDeliverBoxNo(String deliverBoxNo) {
        this.deliverBoxNo = deliverBoxNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public Byte getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(Byte bussinessType) {
        this.bussinessType = bussinessType;
    }

    public Byte getBoxType() {
        return boxType;
    }

    public void setBoxType(Byte boxType) {
        this.boxType = boxType;
    }

    public String getParentContainerNo() {
        return parentContainerNo;
    }

    public void setParentContainerNo(String parentContainerNo) {
        this.parentContainerNo = parentContainerNo;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public String getGroupStr() {
        return groupStr;
    }

    public void setGroupStr(String groupStr) {
        this.groupStr = groupStr;
    }

    public Byte getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(Byte boxStatus) {
        this.boxStatus = boxStatus;
    }

    public Byte getDeliveryBoxStatus() {
        return deliveryBoxStatus;
    }

    public void setDeliveryBoxStatus(Byte deliveryBoxStatus) {
        this.deliveryBoxStatus = deliveryBoxStatus;
    }

    public Integer getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Integer waybillId) {
        this.waybillId = waybillId;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public String getBindOperator() {
        return bindOperator;
    }

    public void setBindOperator(String bindOperator) {
        this.bindOperator = bindOperator;
    }

    public Integer getBoxFullQty() {
        return boxFullQty;
    }

    public void setBoxFullQty(Integer boxFullQty) {
        this.boxFullQty = boxFullQty;
    }

    public String getBigWarehouseNo() {
        return bigWarehouseNo;
    }

    public void setBigWarehouseNo(String bigWarehouseNo) {
        this.bigWarehouseNo = bigWarehouseNo;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getCreateUserLoginName() {
        return createUserLoginName;
    }

    public void setCreateUserLoginName(String createUserLoginName) {
        this.createUserLoginName = createUserLoginName;
    }

    public String getUpdateUserLoginName() {
        return updateUserLoginName;
    }

    public void setUpdateUserLoginName(String updateUserLoginName) {
        this.updateUserLoginName = updateUserLoginName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}