package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.condition.ListSysUserCondition;
import com.cell.user.entiy.SysUser;
import com.cell.user.page.Page;
import com.cell.user.page.PageResult;
import com.cell.user.service.SysUserService;
import com.cell.user.util.RetCodeConst;
import com.cell.user.vo.SysUserVo;
import com.cell.user.vo.UserAuthorityVo;

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
	public String createUser(@RequestBody String userAuthorityJson) {
		logger.info("createUser  user:{}", userAuthorityJson);
		if (StringUtils.isBlank(userAuthorityJson)) {
			return "param error";
		}
		UserAuthorityVo vo = JSON.parseObject(userAuthorityJson,
				UserAuthorityVo.class);
		if (vo == null) {
			return "param error";
		}
		Long userId = sysUserService.createSysUser(vo);
		return JSON.toJSONString(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public PageResult<SysUserVo> listSysUser(
			@RequestParam(value = "condition") ListSysUserCondition condition,
			@RequestParam(value = "page") Page page) {
		return sysUserService.listSysUser(condition, page);
	}

	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updateUser(String userAuthorityJson) {

		if (StringUtils.isBlank(userAuthorityJson)) {
			return RetCodeConst.FAIL;
		}
		UserAuthorityVo vo = JSON.parseObject(userAuthorityJson,
				UserAuthorityVo.class);
		if (vo == null) {
			return RetCodeConst.FAIL;
		}
		sysUserService.updateSysUser(vo);
		return RetCodeConst.SUCCESS;
	}
}
