package com.cell.user.vo;

import java.io.Serializable;

public class UserAuthorityVo implements Serializable {

	private static final long serialVersionUID = 8714264418954323189L;

	private SysUserVo user;
	
	private SysAuthorityVo authority;

	public SysUserVo getUser() {
		return user;
	}

	public void setUser(SysUserVo user) {
		this.user = user;
	}

	public SysAuthorityVo getAuthority() {
		return authority;
	}

	public void setAuthority(SysAuthorityVo authority) {
		this.authority = authority;
	}

}
