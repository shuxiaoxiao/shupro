package com.shupro.oa.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.core.utils.page.PageBean;
import com.shupro.core.vo.Result;
import com.shupro.oa.admin.model.SysDept;
import com.shupro.oa.admin.service.SysDeptService;

@Controller
@RequestMapping("/sysDept")
public class SysDeptController {

	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysDept";
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageBean<SysDept> list(HttpServletRequest request) {
//		int code = 500;
//    	String message = "发生错误";
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	PageBean<SysDept> list = null;
    	try {
    		//easyUI的grid分页参数,具体处理在service层
    		map.put("pageNo", request.getParameter("page"));
    		map.put("pageSize", request.getParameter("rows"));
    		//查询域的查询条件
    		//map.put("deptid", request.getParameter("deptid"));
    		map.put("name", request.getParameter("name"));
    		
    		list = sysDeptService.select2PageBean(map);
//    		code = 200;
//    		message = "成功";
    		
    	} catch (Exception e) {
//    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return list;
	}
	
	/**
     * 保存
     * 返回的是text
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(SysDept sysDept){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDeptService.insert(sysDept);
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
     * 返回的是text
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(SysDept sysDept){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDeptService.updateSelective(sysDept);
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
     * 删除，post
     * 返回的是text
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDeptService.deleteById(ids);
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
     * 删除，get
     * 返回的是text
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDeptService.deleteById(ids);
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
    
    /**
     * 删除
     * 返回的是text
     */
    @RequestMapping(value = "/logicDelete", method = RequestMethod.POST)
    @ResponseBody
    public Result logicDelete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDeptService.logicDeleteByIds(ids);
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
	
}