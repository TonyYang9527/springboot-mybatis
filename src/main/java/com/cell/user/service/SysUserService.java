package com.cell.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.cell.user.condition.ListSysUserCondition;
import com.cell.user.entiy.SysAuthority;
import com.cell.user.entiy.SysUser;
import com.cell.user.entiy.SysUserExample;
import com.cell.user.mapper.SysAuthorityMapper;
import com.cell.user.mapper.SysUserMapper;
import com.cell.user.page.Page;
import com.cell.user.page.PageResult;
import com.cell.user.util.TransformUtil;
import com.cell.user.vo.SysUserVo;
import com.cell.user.vo.UserAuthorityVo;

@Service
public class SysUserService {

	private Logger logger = LoggerFactory.getLogger(SysUserService.class);

	@Autowired
	protected SysUserMapper sysUserMapper;
	@Resource
	protected SysAuthorityMapper sysAuthorityMapper;

	/**
	 * 根据主键获取SysUser.
	 * 
	 * @param id
	 *            the id
	 * @return SysUser
	 */
	public SysUser findUserById(Long id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		logger.info("getSysUserById  id:{},user:{}", JSON.toJSONString(id),
				JSON.toJSONString(user));
		if (user != null) {
			return user;
		}
		return null;
	}

	/**
	 * 创建 SysUser.
	 * 
	 * @param req
	 * @return id
	 */
	public Long createSysUser(UserAuthorityVo vo) {

		SysUser user = TransformUtil.transformSysUser(vo.getUser());
		user.setId(null);
		user.setCreatedTime(new Date());
		user.setCreatedBy("admin");
		sysUserMapper.insertSelective(user);

		SysAuthority authority = TransformUtil.transformSysAuthority(vo
				.getAuthority());
		authority.setId(null);
		authority.setUserId(user.getId());
		sysAuthorityMapper.insertSelective(authority);

		logger.info("createSysUser  user:{},authority:{}",
				JSON.toJSONString(user), JSON.toJSONString(authority));
		return user.getId();
	}

	/**
	 * 更新 SysUser.
	 * 
	 * @param req
	 * @return id
	 */
	public Long updateSysUser(UserAuthorityVo vo) {
		
		SysUser user = TransformUtil.transformSysUser(vo.getUser());
		SysUser sysuser = sysUserMapper.selectByPrimaryKey(user.getId());
		if (sysuser != null) {
			sysUserMapper.updateByPrimaryKeySelective(user);
		}

		SysAuthority authority = TransformUtil.transformSysAuthority(vo
				.getAuthority());
		SysAuthority sysAuthority = sysAuthorityMapper
				.selectByPrimaryKey(authority.getId());
		if (sysAuthority != null) {
			sysAuthorityMapper.updateByPrimaryKeySelective(authority);
		}
		logger.info("updateSysUser  user:{},authority:{}",
				JSON.toJSONString(user), JSON.toJSONString(authority));
		return user.getId();
	}

	/**
	 * 根据主键获取 List<SysUser>.
	 * 
	 * @param Set
	 *            <Long> ids
	 * @return List<SysUser>
	 */
	public List<SysUser> findUserByIds(Set<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<SysUser>();
		}
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria c = example.createCriteria();

		List<Long> values = new ArrayList<Long>(ids.size());
		for (Long id : ids) {
			values.add(id);
		}
		c.andIdIn(values);

		List<SysUser> users = sysUserMapper.selectByExample(example);
		logger.info("findUserByIds  ids:{},users:{}", JSON.toJSONString(ids),
				JSON.toJSONString(users));
		if (CollectionUtils.isEmpty(users)) {
			return new ArrayList<SysUser>();
		}
		return users;
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
	 * 根据id 更新SysUser状态.
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean updateStatusById(Long id, Boolean status) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andStatusEqualTo(!status);// 多种状态:注意状态迁移
		List<SysUser> users = sysUserMapper.selectByExample(example);

		if (CollectionUtils.isNotEmpty(users) && users.size() == 1) {
			SysUser user = new SysUser();
			user.setId(id);
			user.setStatus(status);
			sysUserMapper.updateByPrimaryKeySelective(user);
		}
		logger.info("updateStatusById  id:{},status:{}", JSON.toJSONString(id),
				JSON.toJSONString(status));
		return true;
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

	/**
	 * 根据条件 查询 SysUser列表.
	 * 
	 * @param record
	 * @return PageResult
	 */
	public PageResult<SysUserVo> listSysUser(ListSysUserCondition condition,
			Page page) {

		if (page != null && page.isNeedTotalRecord()) {
			int totalRecord = countSysUser(condition);
			page.setTotalRecord(totalRecord);
			// nodata
			if (totalRecord == 0) {
				PageResult<SysUserVo> result = new PageResult<SysUserVo>();
				result.setResult(new ArrayList<SysUserVo>());
				result.setPage(page);
				return result;
			}
		}

		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(condition.getUsername())) {
			criteria.andUsernameLike("%" + condition.getUsername() + "%");
		}

		if (condition.getStatus() != null) {
			criteria.andStatusEqualTo(condition.getStatus());
		}
		if (CollectionUtils.isNotEmpty(condition.getIds())) {
			List<Long> values = new ArrayList<Long>(condition.getIds().size());
			for (Long id : condition.getIds()) {
				values.add(id);
			}
			criteria.andIdIn(values);
		}

		if (page != null) {
			example.setLimitStart(page.getStart());
			example.setLimitEnd(page.getPageSize());
		}

		List<SysUser> users = sysUserMapper.selectByExample(example);
		PageResult<SysUserVo> result = new PageResult<SysUserVo>();
		result.setResult(TransformUtil.transformSysUserForQuery(users));
		result.setPage(page);
		return result;
	}

	/**
	 * 根据条件统计SysUser列表.
	 * 
	 * @param record
	 * @return int
	 */
	public int countSysUser(ListSysUserCondition condition) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(condition.getUsername())) {
			criteria.andUsernameLike("%" + condition.getUsername() + "%");
		}

		if (condition.getStatus() != null) {
			criteria.andStatusEqualTo(condition.getStatus());
		}
		if (CollectionUtils.isNotEmpty(condition.getIds())) {
			List<Long> values = new ArrayList<Long>(condition.getIds().size());
			for (Long id : condition.getIds()) {
				values.add(id);
			}
			criteria.andIdIn(values);
		}
		return sysUserMapper.countByExample(example);
	}
}
