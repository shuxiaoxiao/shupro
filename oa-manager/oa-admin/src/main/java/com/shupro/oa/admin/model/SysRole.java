package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysRole implements Serializable {
	
	private Integer id;// 
	private String name;// 名称
	private String description;// 描述
	private String type;// 角色类型
	private String isenable;// 状态，0不可用 1可用

	public Integer getId() {
	    return this.id;
	}
	public void setId(Integer id) {
	    this.id=id;
	}
	public String getName() {
	    return this.name;
	}
	public void setName(String name) {
	    this.name=name;
	}
	public String getDescription() {
	    return this.description;
	}
	public void setDescription(String description) {
	    this.description=description;
	}
	public String getType() {
	    return this.type;
	}
	public void setType(String type) {
	    this.type=type;
	}
	public String getIsenable() {
	    return this.isenable;
	}
	public void setIsenable(String isenable) {
	    this.isenable=isenable;
	}
}

