package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysAuthority;
import com.cell.user.service.AuthorityService;

@Controller
public class AuthorityController {
	private Logger logger = LoggerFactory.getLogger(AuthorityController.class);
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/create")
	@ResponseBody
	public boolean create(String param) {
		if (StringUtils.isBlank(param)) {
			return Boolean.FALSE;
		}
		SysAuthority authority = JSON.parseObject(param, SysAuthority.class);
		logger.info("create  authority:{}", JSON.toJSONString(authority));
		if (authority != null) {
			authorityService.createSysAuthority(authority);
		}
		return Boolean.TRUE;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(String param) {
		if (StringUtils.isBlank(param)) {
			return Boolean.FALSE;
		}
		SysAuthority authority = JSON.parseObject(param, SysAuthority.class);
		logger.info("create  authority:{}", JSON.toJSONString(authority));
		if (authority != null) {
			authorityService.updateSysAuthority(authority);
		}
		return Boolean.TRUE;
	}
	
}
