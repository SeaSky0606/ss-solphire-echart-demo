package com.solphire.echart.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 映射json接口测试
 * @author Administrator -> junhong
 *
 * 2016年12月31日 : 下午1:04:37
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {


	@RequestMapping("/get")
	public Map<String,Object> get(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("name="+name);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lowList", Arrays.asList(new Integer[]{2,4,3,5,2,6,11}));
		map.put("highList", Arrays.asList(new Integer[]{22,24,23,25,22,26,21}));
		return map;
	}
	@RequestMapping("/getStringList")
	public Map<String,Object> getStringList(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("name="+name);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lowList", Arrays.asList(new String[]{"2","4","3","5","2","6","11"}));
		map.put("highList", Arrays.asList(new String[]{"22","24","23","25","22","26","21"}));
		return map;
	}
	@RequestMapping("/getArray")
	public Map<String,Object> getArray(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("name="+name);
		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("lowList", Arrays.asList(new Integer[]{2,4,3,5,2,6,11}));
//		map.put("highList", Arrays.asList(new Integer[]{22,24,23,25,22,26,21}));
		map.put("lowList",new Integer[]{2,4,3,5,2,6,11});
		map.put("highList", new Integer[]{22,24,23,25,22,26,21});
		return map;
	}
}
