package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/hello")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		logger.info("greeting  name:{},model:{}",
				JSON.toJSONString(name), JSON.toJSONString(name));
		return "hello";
	}

}
