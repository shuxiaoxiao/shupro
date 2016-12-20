package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysDept;

import java.io.Serializable;

import com.shupro.core.common.BaseMapper;

public interface SysDeptMapper extends BaseMapper<SysDept> {
	
	/**
	 * 根据id 只是更新state
	 * @param id
	 * @return
	 */
	int updateStateByIds(Serializable[] ids);
	
}