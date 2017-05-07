package com.cell.user.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.entiy.SysUser;
import com.cell.user.entiy.SysUserExample;
import com.cell.user.mapper.SysUserMapper;

@Service
public class SysUserService {

	private Logger logger = LoggerFactory.getLogger(SysUserService.class);

	@Autowired
	protected SysUserMapper sysUserMapper;

	/**
	 * 根据主键获取SysUser.
	 *
	 * @param id
	 *            the id
	 * @return SysUser
	 */
	public SysUser getSysUserById(Long id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		logger.info("getSysUserById  id:{},user:{}", JSON.toJSONString(id),
				JSON.toJSONString(user));
		if (user != null) {
			return user;
		}
		return null;
	}

	/**
	 * 根据username获取SysUser.
	 *
	 * @param username
	 * @return SysUser
	 */
	public SysUser getSysUserByOther(String username, String email,
			String mobile) {

		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria c = example.createCriteria();
		if (StringUtils.isNotEmpty(username)) {
			c.andUsernameEqualTo(username);
		}
		if (StringUtils.isNotEmpty(email)) {
			c.andEmailEqualTo(email);
		}
		if (StringUtils.isNotEmpty(mobile)) {
			c.andMobileEqualTo(mobile);
		}
		List<SysUser> users = sysUserMapper.selectByExample(example);
		logger.info(
				"getSysUserByOther  username:{}, email:{}, mobile:{},users:{}",
				JSON.toJSONString(username), JSON.toJSONString(email),
				JSON.toJSONString(mobile), JSON.toJSONString(users));

		if (CollectionUtils.isNotEmpty(users) && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 根据id 删除 SysUser.
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteSysUserById(Long id) {

		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		logger.info("deleteSysUserById  id:{}", JSON.toJSONString(id));
		sysUserMapper.deleteByExample(example);
		return true;
	}

}
