package com.jiang.localspringbootdemo.model;


import java.util.List;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-04 14:16
 */

public class LayOutSaveDTO {

    /**
     * 编码
     */
    private String warehouseCode;

    /**
     * 名称
     */
    private String warehouseName;

    /**
     * 模型id
     */
    private Long businessMode;


    /**
     * 图片地址
     */
    private String layoutUrl;

    /**
     * 是否已有布局图
     */
    private Integer existedLayout;

    /**
     * 是否启用陈列系统
     */
    private Integer enabledDms;

    private Integer layoutStatus;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 前段保存数据集合
     */
    private String layoutData;

    /**
     * 布局图锁包含区域
     */
    private List<LayoutDistrictDTO> districtVOList;


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

    public Integer getExistedLayout() {
        return existedLayout;
    }

    public void setExistedLayout(Integer existedLayout) {
        this.existedLayout = existedLayout;
    }

    public Integer getEnabledDms() {
        return enabledDms;
    }

    public void setEnabledDms(Integer enabledDms) {
        this.enabledDms = enabledDms;
    }

    public Integer getLayoutStatus() {
        return layoutStatus;
    }

    public void setLayoutStatus(Integer layoutStatus) {
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

    public String getLayoutData() {
        return layoutData;
    }

    public void setLayoutData(String layoutData) {
        this.layoutData = layoutData;
    }

    public List<LayoutDistrictDTO> getDistrictVOList() {
        return districtVOList;
    }

    public void setDistrictVOList(List<LayoutDistrictDTO> districtVOList) {
        this.districtVOList = districtVOList;
    }
}
