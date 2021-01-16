package com.jiang.localspringbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiang.localspringbootdemo.model.LayOutSaveDTO;
import com.jiang.localspringbootdemo.model.LayoutDistrictDTO;
import com.jiang.localspringbootdemo.model.LayoutEquipmentDTO;
import com.jiang.localspringbootdemo.service.LayOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-04 14:35
 */

@RequestMapping("/layout")
@Controller
public class LayOutController  {


    @Autowired
    private LayOutService layOutService;

    /**
     * 列表方法
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object layOutList(){
        return "";
    }


    @RequestMapping("/save")
    @ResponseBody
    public Object layOutList(@RequestBody LayOutSaveDTO layOutSaveDTO){

        layOutService.saveLayOut(layOutSaveDTO);

        return new Object();
    }



    @RequestMapping("/getDetailByWarehouseCode")
    @ResponseBody
    public Object detail(@RequestBody JSONObject jsonObject){
        String warehouseCode = jsonObject.getString("warehouseCode");
        //layOutService.getDetail(warehouseCod);

        return new Object();
    }


    public static void main(String[] args) {
        LayOutSaveDTO layOutSaveDTO = new LayOutSaveDTO();

        layOutSaveDTO.setBusinessMode(1L);
        layOutSaveDTO.setCreateUserId(121L);
        layOutSaveDTO.setCreateUserName("wangwu");
        layOutSaveDTO.setEnabledDms(1);
        layOutSaveDTO.setExistedLayout(1);
        layOutSaveDTO.setLayoutUrl("wwww.baidu.com");
        layOutSaveDTO.setLayoutData("test");
        layOutSaveDTO.setWarehouseCode("MRYXBJN-BEIYUAN");
        layOutSaveDTO.setWarehouseName("每日优鲜北苑");

        List<LayoutDistrictDTO>  layoutDistrictDTOList = new ArrayList<>(2);
        LayoutDistrictDTO layoutDistrictDTO = new LayoutDistrictDTO();
        layoutDistrictDTO.setAlias("温区一");
        layoutDistrictDTO.setRemark("备注二");
        layoutDistrictDTO.setDataStr("数据区");


        List<LayoutEquipmentDTO> list = new ArrayList<>();
        LayoutEquipmentDTO layoutEquipmentDTO = new LayoutEquipmentDTO();
        layoutEquipmentDTO.setAreaId(null);
        layoutEquipmentDTO.setEquipmentId(1L);
        layoutEquipmentDTO.setDataStr("设备1");
        list.add(layoutEquipmentDTO);
        layoutDistrictDTO.setLayoutEquipmentDTOList(list);


        layoutDistrictDTOList.add(layoutDistrictDTO);


        layOutSaveDTO.setDistrictVOList(layoutDistrictDTOList);


        System.out.println(JSONObject.toJSONString(layOutSaveDTO));


    }

}
