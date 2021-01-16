package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.config.thymeleafproperties.PDFGeneratorAA;
import com.jiang.localspringbootdemo.util.pdfgenerate.PDFGenerator1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-15 10:51
 * 本地集成themleaf
 */
@Controller
public class ThemLeafController {



  //@Autowired
 // private PDFGeneratorAA pdfGeneratorAA;


    @RequestMapping("thymeleaf")
    public String test(){
        /*model.addAttribute("msg","第一个集成thymeleaf模板");*/
        Map<String,Object> map = new HashMap<>();
        map.put("msg","第一个集成thymeleaf模板");
        PDFGenerator1 pdfGenerator = new PDFGenerator1("/templates",".html");
        try {
          //  pdfGeneratorAA.generate(new File("//Users/jiangqb/Desktop/temp/hello1.pdf"),"hello1",map);
        }catch (Exception e){
            e.printStackTrace();
        }


       /* final TemplateEngine templateEngine = getTemplateEngine();
        String htmlContent = templateEngine.process(template, ctx);*/

        /*ModelAndView modelAndView = new ModelAndView("hello1");
        String viewName = modelAndView.getViewName();*/


        return "hello1";
    }
}
