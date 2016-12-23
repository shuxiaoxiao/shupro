package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysUserRole implements Serializable {
	
	private Integer id;// 
	private Integer userId;// 用户表id
	private Integer roleId;// 角色表id

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId=userId;
	}
	public Integer getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId=roleId;
	}
}

