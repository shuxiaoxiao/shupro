package com.shupro.oa.admin.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.oa.admin.dao.SysRoleMenuMapper;
import com.shupro.oa.admin.model.SysRoleMenu;
import com.shupro.oa.admin.service.SysRoleMenuService;
import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;

@Service
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService {
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysRoleMenu> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

}
