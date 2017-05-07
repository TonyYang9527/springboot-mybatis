package com.cell.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cell.user.mapper.SysRoleMapper;

@Service
public class RoleService {

	private Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Resource
	protected SysRoleMapper sysRoleMapper;
}
