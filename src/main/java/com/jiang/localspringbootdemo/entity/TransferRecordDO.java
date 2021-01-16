package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class TransferRecordDO {
    private Long id;

    private String transferRecordNo;

    private Byte transferStatus;

    private Byte createType;

    private Long warehouseId;

    private Integer distributionTimes;

    private Date warehouseOutTime;

    private Date warehouseInTime;

    private Byte syncAtpOutStatus;

    private Byte syncAtpInStatus;

    private Byte warehouseOutStatus;

    private Byte warehouseInStatus;

    private Byte syncCancelStatus;

    private Long warehouseOutUserId;

    private Long inboundUserId;

    private String inboundUser;

    private Long rejectUserId;

    private String rejectUser;

    private Date rejectTime;

    private Long cancelUserId;

    private Date cancelTime;

    private Long cancelVerifyUserId;

    private Date cancelVerifyTime;

    private String cancelVerifyComment;

    private Long shardingId;

    private Byte createSource;

    private Long createUserId;

    private Date createTime;

    private Long updateUserId;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferRecordNo() {
        return transferRecordNo;
    }

    public void setTransferRecordNo(String transferRecordNo) {
        this.transferRecordNo = transferRecordNo;
    }

    public Byte getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Byte transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Byte getCreateType() {
        return createType;
    }

    public void setCreateType(Byte createType) {
        this.createType = createType;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getDistributionTimes() {
        return distributionTimes;
    }

    public void setDistributionTimes(Integer distributionTimes) {
        this.distributionTimes = distributionTimes;
    }

    public Date getWarehouseOutTime() {
        return warehouseOutTime;
    }

    public void setWarehouseOutTime(Date warehouseOutTime) {
        this.warehouseOutTime = warehouseOutTime;
    }

    public Date getWarehouseInTime() {
        return warehouseInTime;
    }

    public void setWarehouseInTime(Date warehouseInTime) {
        this.warehouseInTime = warehouseInTime;
    }

    public Byte getSyncAtpOutStatus() {
        return syncAtpOutStatus;
    }

    public void setSyncAtpOutStatus(Byte syncAtpOutStatus) {
        this.syncAtpOutStatus = syncAtpOutStatus;
    }

    public Byte getSyncAtpInStatus() {
        return syncAtpInStatus;
    }

    public void setSyncAtpInStatus(Byte syncAtpInStatus) {
        this.syncAtpInStatus = syncAtpInStatus;
    }

    public Byte getWarehouseOutStatus() {
        return warehouseOutStatus;
    }

    public void setWarehouseOutStatus(Byte warehouseOutStatus) {
        this.warehouseOutStatus = warehouseOutStatus;
    }

    public Byte getWarehouseInStatus() {
        return warehouseInStatus;
    }

    public void setWarehouseInStatus(Byte warehouseInStatus) {
        this.warehouseInStatus = warehouseInStatus;
    }

    public Byte getSyncCancelStatus() {
        return syncCancelStatus;
    }

    public void setSyncCancelStatus(Byte syncCancelStatus) {
        this.syncCancelStatus = syncCancelStatus;
    }

    public Long getWarehouseOutUserId() {
        return warehouseOutUserId;
    }

    public void setWarehouseOutUserId(Long warehouseOutUserId) {
        this.warehouseOutUserId = warehouseOutUserId;
    }

    public Long getInboundUserId() {
        return inboundUserId;
    }

    public void setInboundUserId(Long inboundUserId) {
        this.inboundUserId = inboundUserId;
    }

    public String getInboundUser() {
        return inboundUser;
    }

    public void setInboundUser(String inboundUser) {
        this.inboundUser = inboundUser;
    }

    public Long getRejectUserId() {
        return rejectUserId;
    }

    public void setRejectUserId(Long rejectUserId) {
        this.rejectUserId = rejectUserId;
    }

    public String getRejectUser() {
        return rejectUser;
    }

    public void setRejectUser(String rejectUser) {
        this.rejectUser = rejectUser;
    }

    public Date getRejectTime() {
        return rejectTime;
    }

    public void setRejectTime(Date rejectTime) {
        this.rejectTime = rejectTime;
    }

    public Long getCancelUserId() {
        return cancelUserId;
    }

    public void setCancelUserId(Long cancelUserId) {
        this.cancelUserId = cancelUserId;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Long getCancelVerifyUserId() {
        return cancelVerifyUserId;
    }

    public void setCancelVerifyUserId(Long cancelVerifyUserId) {
        this.cancelVerifyUserId = cancelVerifyUserId;
    }

    public Date getCancelVerifyTime() {
        return cancelVerifyTime;
    }

    public void setCancelVerifyTime(Date cancelVerifyTime) {
        this.cancelVerifyTime = cancelVerifyTime;
    }

    public String getCancelVerifyComment() {
        return cancelVerifyComment;
    }

    public void setCancelVerifyComment(String cancelVerifyComment) {
        this.cancelVerifyComment = cancelVerifyComment;
    }

    public Long getShardingId() {
        return shardingId;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Byte getCreateSource() {
        return createSource;
    }

    public void setCreateSource(Byte createSource) {
        this.createSource = createSource;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}