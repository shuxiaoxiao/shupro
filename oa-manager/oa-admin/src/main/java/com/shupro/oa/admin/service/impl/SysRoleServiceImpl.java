package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.oa.admin.dao.SysRoleMapper;
import com.shupro.oa.admin.dao.SysRoleMenuMapper;
import com.shupro.oa.admin.dao.SysUserRoleMapper;
import com.shupro.oa.admin.model.SysRole;
import com.shupro.oa.admin.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysRole> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	@Transactional
	public int logicDeleteByIds(Serializable[] ids) throws Exception {
		sysRoleMapper.updateStateByIds(ids);
		
		Map<String, Object> map = new HashMap<>();
		map.put("roleIds", ids);
		sysUserRoleMapper.deleteByMap(map);
		sysRoleMenuMapper.deleteByMap(map);
		
		return 1;
	}

}
