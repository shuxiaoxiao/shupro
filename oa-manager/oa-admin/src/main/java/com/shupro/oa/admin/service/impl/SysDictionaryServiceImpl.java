package com.shupro.oa.admin.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.oa.admin.dao.SysDictionaryMapper;
import com.shupro.oa.admin.model.SysDictionary;
import com.shupro.oa.admin.service.SysDictionaryService;

@Service
public class SysDictionaryServiceImpl extends AbstractService<SysDictionary> implements SysDictionaryService {
	
	@Autowired
	private SysDictionaryMapper sysDictionaryMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysDictionary> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public int logicDeleteByIds(Serializable[] ids) {
		return sysDictionaryMapper.updateStateByIds(ids);
	}
	
}
