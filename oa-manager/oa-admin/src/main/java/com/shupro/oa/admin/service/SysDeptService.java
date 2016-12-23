package com.shupro.oa.admin.service;

import com.shupro.oa.admin.model.SysDept;

import java.io.Serializable;
import java.util.List;

import com.shupro.core.common.BaseService;
import com.shupro.core.vo.TreeNode;

public interface SysDeptService extends BaseService<SysDept> {
	
	/**
	 * 通过主键id数组 逻辑删除(底层是mybatis的foreach)
	 * @param ids
	 * @return
	 */
	int logicDeleteByIds(Serializable[] ids);
	
	/**
	 * 根据pid 查询
	 * @param pid
	 * @return
	 */
	List<SysDept> selectByPid(String pid);
	
	/**
	 * 
	 * @param deptList
	 * @return
	 */
	List<TreeNode> select2tree(List<SysDept> deptList);
	
}
