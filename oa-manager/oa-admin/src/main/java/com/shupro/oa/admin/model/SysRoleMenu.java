package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysRoleMenu implements Serializable {
	
	private Integer id;// 主键
	private Integer roleId;// 角色表id
	private Integer menuId;// 菜单表id

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId=roleId;
	}
	public Integer getMenuId() {
		return this.menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId=menuId;
	}
}

