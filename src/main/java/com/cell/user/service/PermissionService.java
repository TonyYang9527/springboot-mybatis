package com.cell.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysPermission;
import com.cell.user.entiy.SysPermissionExample;
import com.cell.user.mapper.SysPermissionMapper;

@Service
public class PermissionService {

	private Logger logger = LoggerFactory.getLogger(PermissionService.class);

	@Resource
	protected SysPermissionMapper sysPermissionMapper;

	/**
	 * 根据主键获取SysPermission.
	 *
	 * @param id
	 *            the id
	 * @return SysPermission
	 */
	public SysPermission getSysPermissionById(Long id) {
		SysPermission permission = sysPermissionMapper.selectByPrimaryKey(id);
		logger.info("getSysAuthorityById  id:{},authority:{}",
				JSON.toJSONString(id), JSON.toJSONString(permission));
		if (permission != null) {
			return permission;
		}
		return null;
	}

	/**
	 * 根据id 删除 SysPermission.
	 * 
	 * @param sysPermissionId
	 * @return boolean
	 */
	public boolean deleteSysPermissionById(Long sysPermissionId) {

		SysPermissionExample example = new SysPermissionExample();
		SysPermissionExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(sysPermissionId);
		logger.info("deleteSysAuthorityById  sysAuthorityId:{}",
				JSON.toJSONString(sysPermissionId));
		sysPermissionMapper.deleteByExample(example);
		return true;
	}

	/**
	 * 根据主键获取 List<SysRole>.
	 *
	 * @param id
	 *            the id
	 * @return SysRole
	 */
	public List<SysPermission> findSysPermissionByIds(Set<Long> ids) {

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<SysPermission>();
		}
		SysPermissionExample example = new SysPermissionExample();
		SysPermissionExample.Criteria criteria = example.createCriteria();

		List<Long> values = new ArrayList<Long>(ids.size());
		for (Long id : ids) {
			values.add(id);
		 }
		criteria.andIdIn(values);

		List<SysPermission> permissions = sysPermissionMapper
				.selectByExample(example);
		logger.info("findSysPermissionByIds  ids:{},role:{}",
				JSON.toJSONString(ids), JSON.toJSONString(permissions));

		if (CollectionUtils.isEmpty(permissions)) {
			return new ArrayList<SysPermission>();
		}
		return permissions;
	}
}
