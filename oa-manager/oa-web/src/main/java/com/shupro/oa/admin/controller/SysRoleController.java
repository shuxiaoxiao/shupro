package com.shupro.oa.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.oa.admin.model.SysRole;
import com.shupro.oa.admin.service.SysRoleService;
import com.shupro.core.utils.json.JsonUtil;
import com.shupro.core.utils.page.PageBean;
import com.shupro.core.vo.Result;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysRole";
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageBean<SysRole> list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		//easyUI的grid分页参数,具体处理在service层
		map.put("pageNo", request.getParameter("page"));
		map.put("pageSize", request.getParameter("rows"));
		//查询域的查询条件
		//map.put("deptid", request.getParameter("deptid"));
		map.put("name", request.getParameter("name"));
		map.put("isenable", "1");
		PageBean<SysRole> list = sysRoleService.select2PageBean(map);
		
		return list;
	}
	
	/**
     * 保存
     * 返回的是json
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(SysRole sysRole){
		int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysRoleService.insert(sysRole);
    		if(count > 0){
    			code = 200;
				message = "成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);
    }
    
    /**
     * 修改
     * 返回的是json
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(SysRole sysRole){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysRoleService.updateSelective(sysRole);
    		if(count > 0){
    			code = 200;
				message = "成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);    
    }
    
    /**
     * 逻辑删除角色,并删除中间表(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/logicDelete", method = RequestMethod.POST)
    @ResponseBody
    public Result logicDelete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysRoleService.logicDeleteByIds(ids);
    		if(count > 0){
    			code = 200;
				message = "成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);      
    }
    
    /**
     * 物理删除角色(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysRoleService.deleteById(ids);
    		if(count > 0){
    			code = 200;
    			message = "成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);      
    }
    
    /**
     * 物理删除(get方式)
     * 返回的是json
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysRoleService.deleteById(ids);
    		if(count > 0){
    			code = 200;
				message = "成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);        
    }
    */
	
}