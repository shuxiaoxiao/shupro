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

import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.digest.DigestUtil;
import com.shupro.core.utils.page.PageBean;
import com.shupro.core.vo.Result;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysUser";
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageBean<SysUser> list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		//easyUI的grid分页参数,具体处理在service层
		map.put("pageNo", request.getParameter("page"));
		map.put("pageSize", request.getParameter("rows"));
		//查询域的查询条件
		//map.put("deptid", request.getParameter("deptid"));
		map.put("loginName", request.getParameter("loginName"));
		map.put("state", "1");
		PageBean<SysUser> list = sysUserService.select2PageBean(map);
		
		return list;
	}
	
	/**
     * 保存
     * 返回的是json
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(SysUser sysUser){
		int code = 500;
    	String message = "发生错误";
    	
    	try {
    		String pwd = sysUser.getPwd();
    		if(SystemUtil.isNotEmpty(pwd)){
    			sysUser.setPwd(DigestUtil.md5(pwd));
    		}
    		int count = sysUserService.insert(sysUser);
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
    public Result update(SysUser sysUser){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
//    		String pwd = sysUser.getPwd();
//    		if(SystemUtil.isNotEmpty(pwd)){
//    			sysUser.setPwd(DigestUtil.md5(pwd));
//    		}
    		int count = sysUserService.updateSelective(sysUser);
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
     * 逻辑删除用户,并删除中间表(post方式)
     * 返回的是json
     * @param ids 用户id数组
     */
    @RequestMapping(value = "/logicDelete", method = RequestMethod.POST)
    @ResponseBody
    public Result logicDelete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysUserService.logicDeleteByIds(ids);
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
     * 物理删除用户(post方式)
     * 返回的是json
     * @param ids 用户id数组
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysUserService.deleteById(ids);
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
    public String delete(@PathVariable Integer[] ids){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		int count = sysUserService.deleteById(ids);
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
     * 物理删除用户(post方式)
     * 返回的是json
     * @param ids 用户id数组
     */
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    @ResponseBody
    public Result resetPwd(SysUser sysUser){
    	int code = 500;
    	String message = "发生错误";
    	
    	try {
    		//未做后端验证
    		String pwd = sysUser.getPwd();
    		if(SystemUtil.isNotEmpty(pwd)){
//    			pwd = DigestUtil.md5(pwd);
    			sysUser.setPwd(DigestUtil.md5(pwd));
    		}
//    		int count = sysUserService.resetPwd(sysUser);
    		int count = sysUserService.updateSelective(sysUser);
    		if(count > 0){
    			code = 200;
				message = "操作成功";
    		}
    	} catch (Exception e) {
    		message = "发生异常";
    		e.printStackTrace();
    	}
    	
    	return new Result(code, message);      
    }
	
}