package com.cell.user.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cell.user.mapper.SysAuthorityMapper;

@Service
public class AuthorityService {

	private Logger logger = LoggerFactory.getLogger(AuthorityService.class);
	@Resource
	protected SysAuthorityMapper sysAuthorityMapper;
	
}
