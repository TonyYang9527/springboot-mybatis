package com.cell.user.vo;

import java.io.Serializable;

public class UserAuthorityVo implements Serializable {

	private static final long serialVersionUID = 8714264418954323189L;

	private UserVo user;
	private AuthorityVo authority;

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public AuthorityVo getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityVo authority) {
		this.authority = authority;
	}

}
