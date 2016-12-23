package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysRole;

import java.io.Serializable;

import com.shupro.core.common.BaseService;

public interface SysRoleService extends BaseService<SysRole> {
	
	/**
	 * 通过主键id数组 逻辑 删除,并删除 用户角色中间表、角色菜单中间表
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids) throws Exception;
	
}
