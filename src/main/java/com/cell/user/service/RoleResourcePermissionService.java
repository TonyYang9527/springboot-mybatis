package com.cell.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cell.user.mapper.SysRoleResourcePermissionMapper;

@Service
public class RoleResourcePermissionService {

	
	private Logger logger = LoggerFactory
			.getLogger(RoleResourcePermissionService.class);

	@Resource
	protected SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

	
}
