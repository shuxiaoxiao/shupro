package com.shupro.oa.admin.auto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.shupro.core.utils.db.SpringUtil;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;

public class SpringTest {

	SysUserService sysUserService = null;
//	SysRoleService sysRoleService = null;
	
	@Before
	public void init() {
		String beanName = "sysUserServiceImpl";
		sysUserService = (SysUserService) SpringUtil.getBean(beanName);
//		sysRoleService = (SysRoleService) SpringUtil.getBean("sysRoleServiceImpl");
		
//		System.out.println(sysUserService);
	}
	
	@Test
	public void select2PageBean_test() {
		Map map = new HashMap<>();
		map.put("pageNo", "1");
		map.put("pageSize", "10");
//		map.put("page", "1");
//		map.put("rows", "10");
		System.out.println("select2PageBean:"+ sysUserService.select2PageBean(map));
	}
	
	@Test
	public void selectById_test() {
		int id = 1;
		System.out.println("selectById:"+ sysUserService.selectById(id));
	}
	
	@Test
	public void insert_test() {
		SysUser sysUser1 = new SysUser();
		sysUser1.setName("cc");
		sysUser1.setLoginName("cc");
		sysUser1.setPwd("cc");
		System.out.println("insert:"+ sysUserService.insert(sysUser1));
		SysUser sysUser2 = new SysUser();
		sysUser2.setName("dd");
		sysUser2.setLoginName("dd");
		sysUser2.setPwd("bb");
		System.out.println("insert:"+ sysUserService.insert(sysUser2));
	}
	
	@Test
	public void deleteById_test() {
		Integer[] id = {3};
		try {
			System.out.println("deleteById:"+ sysUserService.logicDeleteByIds(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void deleteById_test2() {
//		//数组未实现Serializable接口
//		Integer[] idArr = new Integer[]{2,3,4,5};
//		System.out.println("deleteById:"+ sysRoleService.deleteById(idArr));
////		System.out.println("deleteById:"+ sysRoleService.deleteByIds(idArr));
//	}
	
	@Test
	public void deleteById_test3() {
		//数组未实现Serializable接口
//		int[] idArr = new int[]{2,3,4,6};
		//参数类型不对
//		List<Integer> list = new ArrayList<>();
//		list.add(2);
//		list.add(3);
		String ids = "2,3";
//		Serializable[] idsStr = ids.split(",");
//		for (Serializable serializable : idsStr) {
//			System.out.println(serializable);
//		}
		System.out.println("deleteById:"+ sysUserService.deleteById(ids));
	}
	
	
//	public static int deleteById(Serializable id) {
//		System.out.println("id");
//		return 1;
//	}
//	public static int deleteById(Serializable[] idArr) {
//		System.out.println("idArr");
//		return 1;
//	}
//	public static void main(String[] args) {
//		int[] idArr = new int[]{2,3,4,6};
//		System.out.println(deleteById(idArr));
//	}
}
