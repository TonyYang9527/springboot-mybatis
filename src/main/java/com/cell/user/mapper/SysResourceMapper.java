package com.cell.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cell.user.entiy.SysResource;
import com.cell.user.entiy.SysResourceExample;

public interface SysResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int countByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int deleteByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int insert(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int insertSelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    SysResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Fri Mar 24 17:07:32 CST 2017
     */
    int updateByPrimaryKey(SysResource record);
}