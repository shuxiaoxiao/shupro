package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysDictionary implements Serializable {
	
	private Integer id;// 
	private Integer pid;// 父编码
	private String typeCode;// 类型编码
	private String name;// 显示的文字
	private String value;// 存的具体值
	private String descs;// 描述
	private String state;// 状态，0不可用 1可用
	private Integer sotid;// 排序号
	public Integer getId() {
	    return this.id;
	}
	public void setId(Integer id) {
	    this.id=id;
	}
	public Integer getPid() {
	    return this.pid;
	}
	public void setPid(Integer pid) {
	    this.pid=pid;
	}
	public String getTypeCode() {
	    return this.typeCode;
	}
	public void setTypeCode(String typeCode) {
	    this.typeCode=typeCode;
	}
	public String getName() {
	    return this.name;
	}
	public void setName(String name) {
	    this.name=name;
	}
	public String getValue() {
	    return this.value;
	}
	public void setValue(String value) {
	    this.value=value;
	}
	public String getDescs() {
	    return this.descs;
	}
	public void setDescs(String descs) {
	    this.descs=descs;
	}
	public String getState() {
	    return this.state;
	}
	public void setState(String state) {
	    this.state=state;
	}
	public Integer getSotid() {
	    return this.sotid;
	}
	public void setSotid(Integer sotid) {
	    this.sotid=sotid;
	}
}

