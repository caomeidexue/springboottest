package com.jiang.localspringbootdemo.model;

import java.util.Date;

/**
 * @Author jiangqb
 * @Description 区域包含设备
 * @Date 2020-01-04 14:28
 */

public class LayoutEquipmentDTO {


    /**
     * 基础数据设备id
     */
    private Long equipmentId;

    /**
     * 库区id
     */
    private Long areaId;

    /**
     * 创建人id
     */
    private Integer createUid;

    /**
     * 创建人名称
     */
    private String createUname;

    /**
     * 前端数据集合
     */
    private String dataStr;


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

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }
}
