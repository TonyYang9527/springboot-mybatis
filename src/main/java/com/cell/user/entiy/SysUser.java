package com.cell.user.entiy;

import java.util.Date;

public class SysUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.id
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.username
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.email
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.mobile
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String mobile;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.password
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.salt
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String salt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.device
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String device;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.status
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private Boolean status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.deleted
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private Boolean deleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.admin
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private Boolean admin;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.created_time
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private Date createdTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.created_by
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	private String createdBy;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.id
	 * @return  the value of sys_user.id
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.id
	 * @param id  the value for sys_user.id
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.username
	 * @return  the value of sys_user.username
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.username
	 * @param username  the value for sys_user.username
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.email
	 * @return  the value of sys_user.email
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.email
	 * @param email  the value for sys_user.email
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.mobile
	 * @return  the value of sys_user.mobile
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.mobile
	 * @param mobile  the value for sys_user.mobile
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.password
	 * @return  the value of sys_user.password
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.password
	 * @param password  the value for sys_user.password
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.salt
	 * @return  the value of sys_user.salt
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.salt
	 * @param salt  the value for sys_user.salt
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.device
	 * @return  the value of sys_user.device
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.device
	 * @param device  the value for sys_user.device
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setDevice(String device) {
		this.device = device == null ? null : device.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.status
	 * @return  the value of sys_user.status
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.status
	 * @param status  the value for sys_user.status
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.deleted
	 * @return  the value of sys_user.deleted
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.deleted
	 * @param deleted  the value for sys_user.deleted
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.admin
	 * @return  the value of sys_user.admin
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.admin
	 * @param admin  the value for sys_user.admin
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.created_time
	 * @return  the value of sys_user.created_time
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.created_time
	 * @param createdTime  the value for sys_user.created_time
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.created_by
	 * @return  the value of sys_user.created_by
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.created_by
	 * @param createdBy  the value for sys_user.created_by
	 * @mbggenerated  Fri Mar 24 17:07:32 CST 2017
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}
}