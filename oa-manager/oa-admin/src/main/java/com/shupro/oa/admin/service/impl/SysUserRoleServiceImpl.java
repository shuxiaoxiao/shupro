package com.shupro.oa.admin.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.oa.admin.dao.SysUserRoleMapper;
import com.shupro.oa.admin.model.SysUserRole;
import com.shupro.oa.admin.service.SysUserRoleService;
import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;

@Service
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService {
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysUserRole> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

}
