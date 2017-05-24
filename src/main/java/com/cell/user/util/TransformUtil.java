package com.cell.user.util;

import com.cell.user.entiy.SysAuthority;
import com.cell.user.entiy.SysUser;
import com.cell.user.vo.SysAuthorityVo;
import com.cell.user.vo.SysUserVo;

public class TransformUtil {

	
	public static SysUserVo transformSysUserVoForQuery(SysUser user) {

		SysUserVo result = new SysUserVo();
		if (user == null)
			return null;

		result.setId(user.getId());
		result.setMobile(user.getMobile());
		result.setPassword(user.getPassword());
        result.setSalt(user.getSalt());
        result.setStatus(user.getStatus());
        result.setUsername(user.getUsername());
        result.setAdmin(user.getAdmin());
        result.setCreatedBy(user.getCreatedBy());
        result.setCreatedTime(user.getCreatedTime());
        result.setDeleted(user.getDeleted());
        result.setDevice(user.getDevice());
        result.setEmail(user.getEmail());
		return result;
	}

	
	public static SysUser  transformSysUserForQuery( SysUserVo user) {
		SysUser result = new SysUser();
		if (user == null)
			return null;
		result.setId(user.getId());
		result.setMobile(user.getMobile());
		result.setPassword(user.getPassword());
        result.setSalt(user.getSalt());
        result.setStatus(user.getStatus());
        result.setUsername(user.getUsername());
        result.setAdmin(user.getAdmin());
        result.setCreatedBy(user.getCreatedBy());
        result.setCreatedTime(user.getCreatedTime());
        result.setDeleted(user.getDeleted());
        result.setDevice(user.getDevice());
        result.setEmail(user.getEmail());
		return result;
	}
	
	
	public static SysAuthorityVo transformSysAuthorityVoForQuery(
			SysAuthority authority) {

		SysAuthorityVo result = new SysAuthorityVo();
		if (authority == null)
			return null;

		result.setGroupId(authority.getGroupId());
		result.setId(authority.getId());
		result.setJobId(authority.getJobId());
		result.setOrganizationId(authority.getOrganizationId());
		result.setRoleIds(String2Set.toSet(authority.getRoleIds()));
		result.setType(authority.getType());
		result.setUserId(authority.getUserId());
		return result;
	}
	
}
