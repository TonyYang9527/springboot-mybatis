package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysUser;
import com.cell.user.service.SysUserService;
import com.cell.user.vo.UserAuthorityVo;
import com.cell.user.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class SysUserController {

	private Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public SysUser getUser(String id) {
		SysUser user = sysUserService.findUserById(Long.parseLong(id));
		logger.info("getUser  user:{}", JSON.toJSONString(user));
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(String userAuthorityJson, boolean hasAuthority) {

		if (StringUtils.isBlank(userAuthorityJson)) {
			return null;
		}
		
		UserAuthorityVo vo = JSON.parseObject(userAuthorityJson,
				UserAuthorityVo.class);

		if (vo == null) {
			return null;
		}
		
		return JSON.toJSONString(vo);
	}
}
