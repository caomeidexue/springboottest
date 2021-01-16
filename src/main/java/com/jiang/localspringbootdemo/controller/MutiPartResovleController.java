package com.jiang.localspringbootdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-11-13 19:23
 */

@RestController
public class MutiPartResovleController {

    /**
     * 导入文件
     * @return wrapper
     */
    @PostMapping(consumes = "multipart/form-data", value = "/import")
    public Object uploadLoadFile(@RequestParam(value = "file") MultipartFile file){

        String originalFileName = file.getOriginalFilename();
        if (!originalFileName.endsWith(".xlsx")) {
            return null;
        }
        try (InputStream inputStream = file.getInputStream()){

            // 上传文件
            String[] str = {"materialId", "num"};
            Map<String, Class> expectMap = new HashMap<>();
            expectMap.put("materialId", Double.class);
            expectMap.put("num", Double.class);




        } catch (Exception e) {

            return null;
        }
        return null;
    }
}
