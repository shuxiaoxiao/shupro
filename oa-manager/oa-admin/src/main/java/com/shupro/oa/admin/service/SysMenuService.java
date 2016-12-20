package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysMenu;

import java.io.Serializable;

import com.shupro.core.common.BaseService;

public interface SysMenuService extends BaseService<SysMenu> {
	
	/**
	 * 通过主键id数组 删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids);
	
}
