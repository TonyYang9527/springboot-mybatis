package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysUser;
import com.cell.user.service.SysUserService;

@Controller
@RequestMapping(value = "/user")
public class SysUserController {

	private Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/get")
	@ResponseBody
	public SysUser getUser(String id) {
		SysUser user = sysUserService.getSysUserById(Long.parseLong(id));
		logger.info("getUser  user:{}", JSON.toJSONString(user));
		return user;
	}
}
