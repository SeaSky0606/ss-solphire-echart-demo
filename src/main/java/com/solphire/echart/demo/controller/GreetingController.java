package com.solphire.echart.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 映射html页面测试
 * @author Administrator -> junhong
 *
 * 2016年12月31日 : 下午1:04:15
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name,Model model) {
        model.addAttribute("name", name);
        System.out.println("name="+name);
    	return "greeting";
    }
    @RequestMapping("/index")
    public String index(@RequestParam(value = "name", defaultValue = "World") String name,Model model) {
    	model.addAttribute("name", name);
    	System.out.println("name="+name);
    	return "index";
    }



}
