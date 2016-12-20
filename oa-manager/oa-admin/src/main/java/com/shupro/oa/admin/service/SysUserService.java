package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysUser;

import java.io.Serializable;

import com.shupro.core.common.BaseService;

public interface SysUserService extends BaseService<SysUser> {
	
	/**
	 * 通过主键id数组 删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids);

	/**
	 * 检查登录名（唯一）
	 * @param loginName
	 * @return
	 */
	SysUser checkLoginName(String loginname);
	
	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	SysUser login(String loginname, String password);
	
}
