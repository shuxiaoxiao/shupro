package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.oa.admin.dao.SysMenuMapper;
import com.shupro.oa.admin.dao.SysRoleMenuMapper;
import com.shupro.oa.admin.model.SysMenu;
import com.shupro.oa.admin.service.SysMenuService;

@Service
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysMenu> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public int logicDeleteByIds(Serializable[] ids) throws Exception {
		sysMenuMapper.updateStateByIds(ids);
		
		Map<String, Object> map = new HashMap<>();
		map.put("menuIds", ids);
		sysRoleMenuMapper.deleteByMap(map);
		
		return 1;
	}
	
}
