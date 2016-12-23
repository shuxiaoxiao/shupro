package com.shupro.oa.admin.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shupro.oa.admin.dao.SysDeptMapper;
import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.admin.service.SysDeptService;
import com.shupro.core.common.AbstractService;
import com.shupro.core.common.BaseMapper;
import com.shupro.core.vo.TreeNode;

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

	@Override
	public List<SysDept> selectByPid(String pid) {
		
		return sysDeptMapper.selectByPid(pid);
	}

	@Override
	public List<TreeNode> select2tree(List<SysDept> deptList) {
		List<TreeNode> list = null;
		TreeNode node = null;
		if (deptList != null) {
			list = new ArrayList<TreeNode>();
			for (SysDept dept : deptList) {
				if(dept != null){
					node = new TreeNode();
					node.setId(dept.getDeptid());//部门ID
					node.setChecked(false);
					node.setText(dept.getName());//部门名称
					node.setPid(dept.getPid());//父级部门ID
					node.setState(dept.getState());
//					if(selectByPid(dept.getDeptid()).size() >0){
//						node.setState("closed");
//					}else{
//						node.setState("open");
//					}
					
					list.add(node);
				}
			}
		}

		return list;
	}

}
