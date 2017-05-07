package com.cell.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysAuthority;
import com.cell.user.entiy.SysAuthorityExample;
import com.cell.user.mapper.SysAuthorityMapper;

@Service
public class AuthorityService {

	private Logger logger = LoggerFactory.getLogger(AuthorityService.class);
	@Resource
	protected SysAuthorityMapper sysAuthorityMapper;

	/**
	 * 根据主键获取SysAuthority.
	 *
	 * @param id
	 *            the id
	 * @return SysAuthority
	 */
	public SysAuthority getSysAuthorityById(Long id) {

		SysAuthority authority = sysAuthorityMapper.selectByPrimaryKey(id);
		logger.info("getSysAuthorityById  id:{},authority:{}",
				JSON.toJSONString(id), JSON.toJSONString(authority));
		if (authority != null) {
			return authority;
		}
		return null;
	}

	/**
	 * 根据id 删除 SysAuthority.
	 * 
	 * @param id
	 * @return int
	 */
	public boolean deleteSysAuthorityById(Long sysAuthorityId) {

		SysAuthorityExample example = new SysAuthorityExample();
		SysAuthorityExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(sysAuthorityId);
		logger.info("deleteSysAuthorityById  sysAuthorityId:{}",
				JSON.toJSONString(sysAuthorityId));
		sysAuthorityMapper.deleteByExample(example);
		return true;
	}

	/**
	 * 根据主键获取SysAuthority.
	 *
	 * @param id
	 *            the id
	 * @return SysAuthority
	 */
	public List<SysAuthority> findSysAuthorityByUserId(Long userId) {

		SysAuthorityExample example = new SysAuthorityExample();
		SysAuthorityExample.Criteria criteria = example.createCriteria();

		if (userId != null) {
			criteria.andUserIdEqualTo(userId);
		}
		List<SysAuthority> authorities = sysAuthorityMapper
				.selectByExample(example);

		logger.info("findSysAuthorityByUserId  userId:{},authorities:{}",
				JSON.toJSONString(userId), JSON.toJSONString(authorities));
		if (!CollectionUtils.isEmpty(authorities)) {
			return authorities;
		}
		return null;
	}
}
