package com.jiang.localspringbootdemo.model;

import java.util.Date;
import java.util.List;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-04 14:24
 */

public class LayoutDistrictDTO {


    /**
     * 公共数据区域id
     */
    private Long districtId;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 长
     */
    private Long length;

    /**
     * 宽
     */
    private Long width;

    /**
     * 高
     */
    private Long height;

    /**
     * 别名
     */
    private String alias;
    /**
     * 前端数据信息
     */
    private String dataStr;

    /**
     * 区域包含的设备集合
     */
    private List<LayoutEquipmentDTO> layoutEquipmentDTOList;


    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public List<LayoutEquipmentDTO> getLayoutEquipmentDTOList() {
        return layoutEquipmentDTOList;
    }

    public void setLayoutEquipmentDTOList(List<LayoutEquipmentDTO> layoutEquipmentDTOList) {
        this.layoutEquipmentDTOList = layoutEquipmentDTOList;
    }
}
