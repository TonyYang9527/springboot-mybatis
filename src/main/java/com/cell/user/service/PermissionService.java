package com.cell.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cell.user.mapper.SysPermissionMapper;


@Service
public class PermissionService {

	private Logger logger = LoggerFactory.getLogger(PermissionService.class);

	@Resource
	protected SysPermissionMapper sysPermissionMapper;
	
}
