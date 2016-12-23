package com.shupro.oa.admin.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class SysLog implements Serializable {
	
	private Integer id;// 
	private String loginName;// 登录名
	private String roleName;// 角色名
	private String content;// 内容
	private String clientIp;// 客户端ip
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;// 创建时间
	public Integer getId() {
	    return this.id;
	}
	public void setId(Integer id) {
	    this.id=id;
	}
	public String getLoginName() {
	    return this.loginName;
	}
	public void setLoginName(String loginName) {
	    this.loginName=loginName;
	}
	public String getRoleName() {
	    return this.roleName;
	}
	public void setRoleName(String roleName) {
	    this.roleName=roleName;
	}
	public String getContent() {
	    return this.content;
	}
	public void setContent(String content) {
	    this.content=content;
	}
	public String getClientIp() {
	    return this.clientIp;
	}
	public void setClientIp(String clientIp) {
	    this.clientIp=clientIp;
	}
	public java.util.Date getCreatetime() {
	    return this.createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
	    this.createtime=createtime;
	}
}

