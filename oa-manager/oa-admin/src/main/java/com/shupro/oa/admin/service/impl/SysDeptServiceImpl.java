package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.oa.admin.dao.SysDeptMapper;
import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.admin.service.SysDeptService;
import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;

@Service
public class SysDeptServiceImpl extends AbstractService<SysDept> implements SysDeptService {
	
	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysDept> baseMapper) {
		super.setBaseMapper(baseMapper);
	}
	
	@Override
	public int logicDeleteByIds(Serializable[] ids) {
		return sysDeptMapper.updateStateByIds(ids);
	}
	
}
