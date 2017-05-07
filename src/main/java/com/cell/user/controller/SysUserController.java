package com.cell.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cell.user.service.SysUserService;

@Controller
public class SysUserController {

	private Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

}
