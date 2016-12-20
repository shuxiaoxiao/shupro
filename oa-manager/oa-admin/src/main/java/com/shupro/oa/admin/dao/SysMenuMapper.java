package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysMenu;

import java.io.Serializable;

import com.shupro.core.common.BaseMapper;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 根据id 只是更新state
	 * @param id
	 * @return
	 */
	int updateStateByIds(Serializable[] ids);
	
}