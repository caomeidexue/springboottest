package com.jiang.localspringbootdemo.entity;

import java.util.Date;

public class LayoutEquipmentDO {
    private Long id;

    private Integer layoutId;

    private Long layoutDistrictId;

    private Long equipmentId;

    private Long areaId;

    private Integer createUid;

    private String createUname;

    private Date createTime;

    private Integer updateUid;

    private String updateUname;

    private Date updateTime;

    private String dataStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public Long getLayoutDistrictId() {
        return layoutDistrictId;
    }

    public void setLayoutDistrictId(Long layoutDistrictId) {
        this.layoutDistrictId = layoutDistrictId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public String getCreateUname() {
        return createUname;
    }

    public void setCreateUname(String createUname) {
        this.createUname = createUname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    public String getUpdateUname() {
        return updateUname;
    }

    public void setUpdateUname(String updateUname) {
        this.updateUname = updateUname;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }
}