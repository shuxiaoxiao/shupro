package com.shupro.oa.admin.dao;

import com.shupro.oa.admin.model.SysUser;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.shupro.core.common.BaseMapper;

public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 根据id 只是更新state
	 * @param id
	 * @return
	 */
	int updateStateByIds(Serializable[] ids);
	
	/**
	 * 导出查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> select2Excel(Map<String, Object> map);
	
	/**
	 * 批量新增
	 * @param record
	 * @return
	 */
	int insertBatch(List<SysUser> list);
	
}