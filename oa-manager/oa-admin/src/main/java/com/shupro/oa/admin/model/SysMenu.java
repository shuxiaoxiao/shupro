package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysMenu implements Serializable {
	
	private Integer id;// 
	private String name;// 菜单名称
	private Integer pid;// 父id
	private String levels;// 层级
	private java.util.Date createtime;// 创建时间
	private String requestUrl;// 请求路径
	private String menuType;// 菜单类型,1菜单 2按钮
	private String isenable;// 状态，0不可用 1可用
	private Integer sotid;// 排序号
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
	public Integer getPid() {
	    return this.pid;
	}
	public void setPid(Integer pid) {
	    this.pid=pid;
	}
	public String getLevels() {
	    return this.levels;
	}
	public void setLevels(String levels) {
	    this.levels=levels;
	}
	public java.util.Date getCreatetime() {
	    return this.createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
	    this.createtime=createtime;
	}
	public String getRequestUrl() {
	    return this.requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
	    this.requestUrl=requestUrl;
	}
	public String getMenuType() {
	    return this.menuType;
	}
	public void setMenuType(String menuType) {
	    this.menuType=menuType;
	}
	public String getIsenable() {
	    return this.isenable;
	}
	public void setIsenable(String isenable) {
	    this.isenable=isenable;
	}
	public Integer getSotid() {
	    return this.sotid;
	}
	public void setSotid(Integer sotid) {
	    this.sotid=sotid;
	}
}

