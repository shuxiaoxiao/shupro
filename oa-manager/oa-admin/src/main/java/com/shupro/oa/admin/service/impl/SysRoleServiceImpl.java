package com.shupro.oa.admin.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.oa.admin.dao.SysRoleMapper;
import com.shupro.oa.admin.model.SysRole;
import com.shupro.oa.admin.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysRole> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public int logicDeleteByIds(Serializable[] ids) {
		return sysRoleMapper.updateStateByIds(ids);
	}

}
