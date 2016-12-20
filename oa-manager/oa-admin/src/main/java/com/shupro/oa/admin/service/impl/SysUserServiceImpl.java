package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.core.utils.SystemUtil;
import com.shupro.oa.admin.dao.SysUserMapper;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;

@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysUser> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public int logicDeleteByIds(Serializable[] ids) {
		return sysUserMapper.updateStateByIds(ids);
	}

	@Override
	public SysUser checkLoginName(String loginname) {
		Map<String, Object> map = new HashMap<>();
		map.put("loginname", loginname);
		
		List<SysUser> list = sysUserMapper.selectAllByCondition(map);
		if(SystemUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public SysUser login(String loginname, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("loginname", loginname);
		map.put("pwd", password);
		
		List<SysUser> list = sysUserMapper.selectAllByCondition(map);
		if(SystemUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}

}
