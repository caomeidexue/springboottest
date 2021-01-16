package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class TransferRecordItemDO {
    private Long id;

    private Long transferRecordId;

    private Long materialId;

    private Integer materialNum;

    private Byte transferReasonType;

    private String pictureUrl;

    private Long handoverId;

    private String handoverNo;

    private Long shardingId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransferRecordId() {
        return transferRecordId;
    }

    public void setTransferRecordId(Long transferRecordId) {
        this.transferRecordId = transferRecordId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Integer materialNum) {
        this.materialNum = materialNum;
    }

    public Byte getTransferReasonType() {
        return transferReasonType;
    }

    public void setTransferReasonType(Byte transferReasonType) {
        this.transferReasonType = transferReasonType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Long getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(Long handoverId) {
        this.handoverId = handoverId;
    }

    public String getHandoverNo() {
        return handoverNo;
    }

    public void setHandoverNo(String handoverNo) {
        this.handoverNo = handoverNo;
    }

    public Long getShardingId() {
        return shardingId;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
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