package com.cell.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cell.user.entiy.SysRoleResourcePermission;
import com.cell.user.entiy.SysRoleResourcePermissionExample;

public interface SysRoleResourcePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int countByExample(SysRoleResourcePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int deleteByExample(SysRoleResourcePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int insert(SysRoleResourcePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int insertSelective(SysRoleResourcePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    List<SysRoleResourcePermission> selectByExample(SysRoleResourcePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    SysRoleResourcePermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysRoleResourcePermission record, @Param("example") SysRoleResourcePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByExample(@Param("record") SysRoleResourcePermission record, @Param("example") SysRoleResourcePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByPrimaryKeySelective(SysRoleResourcePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_resource_permission
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByPrimaryKey(SysRoleResourcePermission record);
}