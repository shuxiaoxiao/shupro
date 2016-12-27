package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.core.utils.SystemUtil;
import com.shupro.oa.admin.dao.SysUserMapper;
import com.shupro.oa.admin.dao.SysUserRoleMapper;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;

@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<SysUser> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	@Transactional
	public int logicDeleteByIds(Serializable[] ids) throws Exception {
		sysUserMapper.updateStateByIds(ids);
		Map<String, Object> map = new HashMap<>();
		map.put("userIds", ids);
		sysUserRoleMapper.deleteByMap(map);
		
		return 1;
	}

	@Override
	public SysUser checkLoginName(String loginName) {
		Map<String, Object> map = new HashMap<>();
		map.put("loginName", loginName);
		
		List<SysUser> list = sysUserMapper.selectAllByCondition(map);
		if(SystemUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public SysUser login(String loginName, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("loginName", loginName);
		map.put("pwd", password);
		
		List<SysUser> list = sysUserMapper.selectAllByCondition(map);
		if(SystemUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<Map<String, Object>> select2Excel(Map<String, Object> map) {
		
		return sysUserMapper.select2Excel(map);
	}

//	@Override
//	public int resetPwd(SysUser sysUser) {
//		
//		return sysUserMapper.updateSelective(sysUser);
//	}
//	@Override
//	public int resetPwd(Integer[] ids, String pwd) {
//		SysUser sysUser = new SysUser();
//		sysUser.setPwd(pwd);
//		sysUser.setIds(ids);
//		
//		return sysUserMapper.updateSelective(sysUser);
//	}

	@Override
	@Transactional
	public int insertBatch(List<SysUser> list) {
		
		return sysUserMapper.insertBatch(list);
	}
	
}
