package com.solphire.echart.demo.controller;

import com.solphire.echart.demo.service.PrestoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 映射json接口测试
 *
 * @author junhong
 *         <p>
 *         2019年06月30日
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    PrestoQueryService queryService;

    @RequestMapping("/getBar2")
    public Map<String, Object> getBar2(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("name=" + name);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", Arrays.asList(new Integer[]{2, 4, 3, 5, 2, 6, 11}));
        map.put("categories", Arrays.asList(new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"}));
        return map;
    }

    @RequestMapping("/getBar")
    public Map<String, Object> getBar(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("name=" + name);
        Map<String, Object> map = queryService.getQueryRet();
        if (map == null || map.size() == 0) {
            return null;
        }
        map.put("categories", map.get("dsList"));
        map.put("data", map.get("cntList"));
        return map;
    }
}
