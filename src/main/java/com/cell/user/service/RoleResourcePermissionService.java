package com.cell.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysRoleResourcePermission;
import com.cell.user.entiy.SysRoleResourcePermissionExample;
import com.cell.user.mapper.SysRoleResourcePermissionMapper;

@Service
public class RoleResourcePermissionService {

	private Logger logger = LoggerFactory
			.getLogger(RoleResourcePermissionService.class);

	@Resource
	protected SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

	/**
	 * 根据主键获取SysRoleResourcePermission.
	 *
	 * @param id
	 *            the id
	 * @return SysRoleResourcePermission
	 */
	public SysRoleResourcePermission getSysRoleResourcePermissionById(Long id) {
		SysRoleResourcePermission relation = sysRoleResourcePermissionMapper
				.selectByPrimaryKey(id);
		logger.info("getSysRoleResourcePermissionById  id:{},relation:{}",
				JSON.toJSONString(id), JSON.toJSONString(relation));
		if (relation == null) {
			return new SysRoleResourcePermission();
		}
		return relation;
	}

	/**
	 * 创建 SysRoleResourcePermission.
	 * 
	 * @param req
	 * @return id
	 */
	public Long createSysRoleResourcePermission(
			SysRoleResourcePermission relation) {
		sysRoleResourcePermissionMapper.insertSelective(relation);
		logger.info("createSysRoleResourcePermission  relation:{}",
				JSON.toJSONString(relation));
		// 后面加入缓存
		return relation.getId();
	}

	/**
	 * 更新 SysRoleResourcePermission
	 * 
	 * @param req
	 * @return boolean
	 */
	public boolean updateSysRoleResourcePermission(
			SysRoleResourcePermission relation) {
		SysRoleResourcePermissionExample example = new SysRoleResourcePermissionExample();
		SysRoleResourcePermissionExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(relation.getId());

		logger.info("updateSysRoleResourcePermission  relation:{}",
				JSON.toJSONString(relation));
		sysRoleResourcePermissionMapper.updateByExampleSelective(relation,
				example);

		return true;
	}

	/**
	 * 根据id 删除 SysRoleResourcePermission.
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteSysRoleResourcePermissionById(Set<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return true;
		}
		SysRoleResourcePermissionExample example = new SysRoleResourcePermissionExample();
		SysRoleResourcePermissionExample.Criteria criteria = example
				.createCriteria();
		List<Long> values = new ArrayList<Long>(ids.size());
		for (Long roleId : ids) {
			values.add(roleId);
		}
		criteria.andIdIn(values);

		logger.info("deleteSysRoleResourcePermissionById  ids:{}",
				JSON.toJSONString(ids));
		sysRoleResourcePermissionMapper.deleteByExample(example);
		return true;
	}

	/**
	 * 根据主键获取SysRoleResourcePermission.
	 *
	 * @param id
	 *            the id
	 * @return SysRoleResourcePermission
	 */
	public List<SysRoleResourcePermission> getSysRoleResourcePermissionByRoleIds(
			Set<Long> roleIds) {

		if (CollectionUtils.isEmpty(roleIds)) {
			return new ArrayList<SysRoleResourcePermission>();
		}
		SysRoleResourcePermissionExample example = new SysRoleResourcePermissionExample();
		SysRoleResourcePermissionExample.Criteria criteria = example
				.createCriteria();

		List<Long> values = new ArrayList<Long>(roleIds.size());
		for (Long roleId : roleIds) {
			values.add(roleId);
		}
		criteria.andRoleIdIn(values);

		List<SysRoleResourcePermission> relations = sysRoleResourcePermissionMapper
				.selectByExample(example);
		logger.info(
				"getSysRoleResourcePermissionByRoleIds  roleIds:{},relation:{}",
				JSON.toJSONString(roleIds), JSON.toJSONString(relations));
		if (CollectionUtils.isEmpty(relations)) {
			return new ArrayList<SysRoleResourcePermission>();
		}
		return relations;

	}
}
