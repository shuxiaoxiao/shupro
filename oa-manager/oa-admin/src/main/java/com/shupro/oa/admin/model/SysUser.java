package com.shupro.oa.admin.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class SysUser implements Serializable {
	
	private Integer id;// 
	private String name;// 名称
	private String loginName;// 登录名
	private String pwd;// 密码
	private String sex;// 性别
	private String icon;// 图标
	private String phoneNum;// 手机号
	private String phoneNum2;// 备用号
	private String address;// 地址
	private String state;// 用户状态,0不可用 1可用
	private String deptid;// 部门id
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createtime;// 入职时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private java.util.Date leavetime;// 离职时间
	private String userType;// 用户类型
	private Integer sotid;// 排序号
	
	//=====以下是显示需要字段(开始)=====
//	private String newPwd;// 新密码
//	private String againPwd;// 确认密码
	private String rolename;// 角色名称
	private String sexName;// 性别名称
	private Integer[] ids; //用户id数组（重置密码有用到）
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	//=====以下是显示需要字段(结束)=====
	
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
	public String getLoginName() {
	    return this.loginName;
	}
	public void setLoginName(String loginName) {
	    this.loginName=loginName;
	}
	public String getPwd() {
	    return this.pwd;
	}
	public void setPwd(String pwd) {
	    this.pwd=pwd;
	}
	public String getSex() {
	    return this.sex;
	}
	public void setSex(String sex) {
	    this.sex=sex;
	}
	public String getIcon() {
	    return this.icon;
	}
	public void setIcon(String icon) {
	    this.icon=icon;
	}
	public String getPhoneNum() {
	    return this.phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
	    this.phoneNum=phoneNum;
	}
	public String getPhoneNum2() {
	    return this.phoneNum2;
	}
	public void setPhoneNum2(String phoneNum2) {
	    this.phoneNum2=phoneNum2;
	}
	public String getAddress() {
	    return this.address;
	}
	public void setAddress(String address) {
	    this.address=address;
	}
	public String getState() {
	    return this.state;
	}
	public void setState(String state) {
	    this.state=state;
	}
	public String getDeptid() {
	    return this.deptid;
	}
	public void setDeptid(String deptid) {
	    this.deptid=deptid;
	}
	public java.util.Date getCreatetime() {
	    return this.createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
	    this.createtime=createtime;
	}
	public java.util.Date getLeavetime() {
	    return this.leavetime;
	}
	public void setLeavetime(java.util.Date leavetime) {
	    this.leavetime=leavetime;
	}
	public String getUserType() {
	    return this.userType;
	}
	public void setUserType(String userType) {
	    this.userType=userType;
	}
	public Integer getSotid() {
	    return this.sotid;
	}
	public void setSotid(Integer sotid) {
	    this.sotid=sotid;
	}
}

