package com.cell.user.condition;

import java.io.Serializable;
import java.util.Set;

public class ListSysUserCondition implements Serializable {

	private static final long serialVersionUID = 6238623404255913275L;
	
	private Set<Long> ids;
	private String username;
	private Boolean status;
	public Set<Long> getIds() {
		return ids;
	}
	public void setIds(Set<Long> ids) {
		this.ids = ids;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
