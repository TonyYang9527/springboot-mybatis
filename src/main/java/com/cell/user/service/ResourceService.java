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
import com.cell.user.entiy.SysResource;
import com.cell.user.entiy.SysResourceExample;
import com.cell.user.mapper.SysResourceMapper;

@Service
public class ResourceService {

	private Logger logger = LoggerFactory.getLogger(ResourceService.class);

	@Resource
	protected SysResourceMapper sysResourceMapper;

	/**
	 * 根据主键获取SysResource.
	 *
	 * @param id
	 *            the id
	 * @return SysResource
	 */
	public SysResource getSysResourceById(Long id) {
		SysResource resource = sysResourceMapper.selectByPrimaryKey(id);
		logger.info("getSysResourceById  id:{},resource:{}",
				JSON.toJSONString(id), JSON.toJSONString(resource));
		if (resource != null) {
			return resource;
		}
		return null;
	}

	/**
	 * 创建 SysResource.
	 * 
	 * @param req
	 * @return id
	 */
	public Long createSysResource(SysResource resource) {
		sysResourceMapper.insertSelective(resource);
		logger.info("createSysResource  resource:{}",
				JSON.toJSONString(resource));
		// 后面加入缓存
		return resource.getId();
	}

	/**
	 * 更新 SysResource
	 * 
	 * @param req
	 * @return boolean
	 */
	public boolean updateSysResource(SysResource resource) {
		SysResourceExample example = new SysResourceExample();
		SysResourceExample.Criteria c = example.createCriteria();
		c.andIdEqualTo(resource.getId());

		logger.info("updateSysResource  resource:{}",
				JSON.toJSONString(resource));
		sysResourceMapper.updateByExampleSelective(resource, example);

		return true;
	}

	/**
	 * 根据id 删除 SysResource.
	 * 
	 * @param sysPermissionId
	 * @return boolean
	 */
	public boolean deleteSysResourceById(Long id) {

		SysResourceExample example = new SysResourceExample();
		SysResourceExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		logger.info("deleteSysResourceById  sysAuthorityId:{}",
				JSON.toJSONString(id));
		sysResourceMapper.deleteByExample(example);
		return true;
	}

	/**
	 * 根据主键获取 List<SysRole>.
	 *
	 * @param id
	 *            the id
	 * @return SysRole
	 */
	public List<SysResource> findSysResources(Set<Long> ids, Set<Long> parentIds) {

		if (CollectionUtils.isEmpty(ids) && CollectionUtils.isEmpty(parentIds)) {
			return new ArrayList<SysResource>();
		}

		SysResourceExample example = new SysResourceExample();
		SysResourceExample.Criteria criteria = example.createCriteria();
		List<Long> idsList = new ArrayList<Long>(ids.size());
		for (Long id : ids) {
			idsList.add(id);
		}
		criteria.andIdIn(idsList);

		List<Long> parentIdsList = new ArrayList<Long>(parentIds.size());
		for (Long parentId : parentIds) {
			parentIdsList.add(parentId);
		}
		criteria.andParentIdIn(parentIdsList);

		List<SysResource> resources = sysResourceMapper
				.selectByExample(example);
		logger.info("findSysRoles  ids:{},  parentIds:{},resources:{}",
				JSON.toJSONString(ids), JSON.toJSONString(parentIds),
				JSON.toJSONString(resources));

		if (CollectionUtils.isEmpty(resources)) {
			return new ArrayList<SysResource>();
		}
		return resources;
	}

}
