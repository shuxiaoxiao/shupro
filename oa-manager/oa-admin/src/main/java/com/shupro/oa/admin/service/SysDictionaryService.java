package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysDictionary;

import java.io.Serializable;

import com.shupro.core.common.BaseService;

public interface SysDictionaryService extends BaseService<SysDictionary> {
	
	/**
	 * 通过主键id数组 删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids);
	
}
