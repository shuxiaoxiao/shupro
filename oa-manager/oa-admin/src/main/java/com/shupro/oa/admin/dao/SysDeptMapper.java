package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysDept;

import java.io.Serializable;
import java.util.List;

import com.shupro.core.common.BaseMapper;

public interface SysDeptMapper extends BaseMapper<SysDept> {
	
	/**
	 * 根据id 只是更新state
	 * @param id
	 * @return
	 */
	int updateStateByIds(Serializable[] ids);

	/**
	 * 根据pid 查询
	 * @param pid
	 * @return
	 */
	List<SysDept> selectByPid(String pid);
	
}