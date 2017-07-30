package com.cell.user.service;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.cell.user.vo.SysAuthorityVo;
import com.cell.user.vo.SysUserVo;
import com.cell.user.vo.UserAuthorityVo;

public class Test {
	public static void main(String[] args) {
	UserAuthorityVo vo  = new UserAuthorityVo();
	SysUserVo user = new SysUserVo();
	user.setDeleted(false);
	user.setEmail("yxj1985@126.com");
	SysAuthorityVo authority = new SysAuthorityVo();
	authority.setGroupId(0L);
	authority.setJobId(0L);
	authority.setOrganizationId(0L);
	Set<Long> ids=new HashSet<Long>(); 
	ids.add(0L);
	ids.add(1L);
	ids.add(3L);
	authority.setRoleIds(ids) ;
	authority.setType(false);
	vo.setUser(user);
	vo.setAuthority(authority);
	System.out.println(JSON.toJSONString(vo));
}
}
