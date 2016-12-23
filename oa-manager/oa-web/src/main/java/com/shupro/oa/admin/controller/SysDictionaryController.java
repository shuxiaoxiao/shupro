package com.shupro.oa.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.oa.admin.model.SysDictionary;
import com.shupro.oa.admin.service.SysDictionaryService;
import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.json.JsonUtil;
import com.shupro.core.utils.page.PageBean;
import com.shupro.core.vo.Result;

@Controller
@RequestMapping("/sysDictionary")
public class SysDictionaryController {

	@Autowired
	private SysDictionaryService sysDictionaryService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysDictionary";
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageBean<SysDictionary> list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		//easyUI的grid分页参数,具体处理在service层
		map.put("pageNo", request.getParameter("page"));
		map.put("pageSize", request.getParameter("rows"));
		//查询域的查询条件
		//map.put("deptid", request.getParameter("deptid"));
		map.put("name", request.getParameter("name"));
		map.put("state", "1");
		PageBean<SysDictionary> list = sysDictionaryService.select2PageBean(map);
		
		return list;
	}
	
	/**
     * 保存
     * 返回的是json
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(SysDictionary sysDictionary){
		int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDictionaryService.insert(sysDictionary);
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
    public Result update(SysDictionary sysDictionary){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDictionaryService.updateSelective(sysDictionary);
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
     * 逻辑删除(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/logicDelete", method = RequestMethod.POST)
    @ResponseBody
    public Result logicDelete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDictionaryService.logicDeleteByIds(ids);
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
     * 删除(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDictionaryService.deleteById(ids);
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
     * 删除(get方式)
     * 返回的是json
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysDictionaryService.deleteById(ids);
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
     * 查询内容给combo(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/select2Combo", method = RequestMethod.POST)
    @ResponseBody
    public List<SysDictionary> select2Combo(@RequestParam Integer pid){
//    	int code = 500;
//    	String message = "发生错误";
    	List<SysDictionary> list = null;
    	try {
    		Map<String, Object> map = new HashMap<>();
    		map.put("pid", pid);
    		list = sysDictionaryService.selectAllByCondition(map);
//    		if(SystemUtil.isNotEmpty(list)){
//    			code = 200;
//    			message = "成功";
//    		}
    	} catch (Exception e) {
//    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return list;      
    }
    
    /**
     * 逻辑删除(post方式)
     * 返回的是json
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public Result selectById(@RequestParam Integer id){
    	int code = 500;
    	String message = "发生错误";
    	SysDictionary sysDictionary = null;
    	try {
    		sysDictionary = sysDictionaryService.selectById(id);
    		code = 200;
    		message = "成功";
    		
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message, sysDictionary); 
    }
	
}