package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.User;
import com.cell.user.service.DemoService;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class DemoController {

	private Logger logger = LoggerFactory.getLogger(DemoController.class);
	@Autowired
	private DemoService userService;

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public User getUserInfo() {
		User user = userService.getUserInfo();
		if (user != null) {
			System.out.println("user.getName():" + user.getName());
			logger.info("user.getAge():" + user.getAge());
		}

		logger.info("getUserInfo  user:{}", JSON.toJSONString(user));
		return user;
	}
}
