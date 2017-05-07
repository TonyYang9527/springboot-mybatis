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
import com.cell.user.entiy.SysRole;
import com.cell.user.entiy.SysRoleExample;
import com.cell.user.mapper.SysRoleMapper;

@Service
public class RoleService {

	private Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Resource
	protected SysRoleMapper sysRoleMapper;

	/**
	 * 根据主键获取SysRole.
	 *
	 * @param id
	 *            the id
	 * @return SysRole
	 */
	public SysRole getSysRoleById(Long id) {
		SysRole role = sysRoleMapper.selectByPrimaryKey(id);
		logger.info("getSysRoleById  id:{},role:{}", JSON.toJSONString(id),
				JSON.toJSONString(role));
		if (role != null) {
			return role;
		}
		return null;
	}

	/**
	 * 创建 SysRole.
	 * 
	 * @param req
	 * @return id
	 */
	public Long createSysRole(SysRole role) {
		sysRoleMapper.insertSelective(role);
		logger.info("createSysRole  role:{}", JSON.toJSONString(role));
		// 后面加入缓存
		return role.getId();
	}

	/**
	 * 更新 SysRole
	 * 
	 * @param req
	 * @return boolean
	 */
	public boolean updateSysRole(SysRole role) {

		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(role.getId());

		logger.info("updateSysRole  role:{}", JSON.toJSONString(role));
		sysRoleMapper.updateByExampleSelective(role, example);

		return true;
	}

	/**
	 * 根据id 删除 SysRole.
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteSysRoleById(Long id) {

		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		logger.info("deleteSysRoleById  id:{}", JSON.toJSONString(id));
		sysRoleMapper.deleteByExample(example);
		return true;
	}

	/**
	 * 根据主键获取 List<SysRole>.
	 *
	 * @param id
	 *            the id
	 * @return SysRole
	 */
	public List<SysRole> findSysRoleByIds(Set<Long> ids) {

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<SysRole>();
		}
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria criteria = example.createCriteria();

		List<Long> values = new ArrayList<Long>(ids.size());
		for (Long id : ids) {
			values.add(id);
		}
		criteria.andIdIn(values);

		List<SysRole> roles = sysRoleMapper.selectByExample(example);
		logger.info("findSysRoleByIds  ids:{},role:{}", JSON.toJSONString(ids),
				JSON.toJSONString(roles));
		if (CollectionUtils.isEmpty(roles)) {
			return new ArrayList<SysRole>();
		}
		return roles;
	}

}
