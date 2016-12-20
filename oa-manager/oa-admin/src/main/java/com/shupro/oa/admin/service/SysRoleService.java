package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysRole;

import java.io.Serializable;

import com.shupro.core.common.BaseService;

public interface SysRoleService extends BaseService<SysRole> {
	
	/**
	 * 通过主键id数组 删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids);
	
}
