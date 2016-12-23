package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysUserRole;

import java.util.Map;

import com.shupro.core.common.BaseMapper;

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	
	/**
	 * 多条件 删除(由于是中间表)
	 * @param id
	 * @return
	 */
	int deleteByMap(Map<String, Object> map);
	
}