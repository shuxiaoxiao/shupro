package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysUser;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.shupro.core.common.BaseService;

public interface SysUserService extends BaseService<SysUser> {
	
	/**
	 * 通过主键id数组 删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids) throws Exception;

	/**
	 * 检查登录名（唯一）
	 * @param loginName
	 * @return
	 */
	SysUser checkLoginName(String loginName);
	
	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	SysUser login(String loginName, String password);

	/**
	 * 导出查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> select2Excel(Map<String, Object> map);

//	/**
//	 * 重置或修改密码(底层实际还是updateSelective)
//	 * @param ids
//	 * @param pwd 新密码
//	 * @return
//	 */
//	int resetPwd(SysUser sysUser);
	
	/**
	 * 批量新增
	 * @param record
	 * @return
	 */
	int insertBatch(List<SysUser> list);
	
}
