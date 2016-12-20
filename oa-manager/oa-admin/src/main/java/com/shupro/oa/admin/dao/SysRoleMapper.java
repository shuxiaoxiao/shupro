package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysRole;

import java.io.Serializable;

import com.shupro.core.common.BaseMapper;

public interface SysRoleMapper extends BaseMapper<SysRole> {

	/**
	 * 根据id 只是更新state
	 * @param id
	 * @return
	 */
	int updateStateByIds(Serializable[] ids);
	
}