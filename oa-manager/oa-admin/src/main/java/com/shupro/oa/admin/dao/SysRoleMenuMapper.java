package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysRoleMenu;

import java.util.Map;

import com.shupro.core.common.BaseMapper;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
	
	/**
	 * 多条件 删除(由于是中间表)
	 * @param id
	 * @return
	 */
	int deleteByMap(Map<String, Object> map);
	
}