package com.shupro.oa.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shupro.core.utils.MyBeanUtil;
import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.digest.DigestUtil;
import com.shupro.core.utils.excel.ExcelInfo;
import com.shupro.core.utils.excel.ExcelUtil;
import com.shupro.core.utils.lang.DateUtil;
import com.shupro.core.utils.page.PageBean;
import com.shupro.core.vo.Result;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;
import com.shupro.oa.util.AdminConstant;

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
    		String pwd = sysUser.getPwd();
    		if(SystemUtil.isNotEmpty(pwd)){
    			sysUser.setPwd(DigestUtil.md5(pwd));
    		}
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
	
	/**
	 * 导入, 每10条进行一次批量插入，默认密码 123456
	 * @param request
	 * @param file 文件
	 * @return
	 */
	@RequestMapping("/importUser")
	@ResponseBody
	public Result importExcel2User(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
		int code = 500;
		String message = "发生错误";
		
		try {
			List<String[]> list = ExcelUtil.read(file.getOriginalFilename(), file.getInputStream());
			if(SystemUtil.isEmpty(list)){
				message = "没有填写需要导入的数据";
			}else{
				
				int pageSize = 10;//每页条数
				int total = list.size();
				int pageNum = 0;//分页总数
				if (total % pageSize == 0) {
					pageNum = total / pageSize;
				} else {
					pageNum = total / pageSize + 1;
				}
				SysUser sysUser = null;
				int end = Math.min(pageSize, total);
				for (int i = 1; i <= pageNum; i++) {
					List<SysUser> userList = new ArrayList<>();
					for (int j = 0; j < end; j++) {
						int pageCount = (i -1) * pageSize;
						int start = pageCount + j;
						if (start >= total){//如果数据超出总的记录数的时候，就退出循环
							break;
						}
						String[] strArr = list.get(start);
						sysUser = setNewUser(strArr);
						userList.add(sysUser);
					}
					sysUserService.insertBatch(userList);
					
				}
				
				code = 200;
				message = "导入成功";
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			message = "导入发生异常";
		}
		
		return new Result(code, message);
	}
    
	/**
	 * SysUser赋值
	 * @param strArr
	 * @return
	 */
	private SysUser setNewUser(String[] strArr) {
		
		SysUser sysUser = new SysUser();
		sysUser.setName(strArr[0]);
		sysUser.setLoginName(strArr[1]);
		//默认密码 123456
		sysUser.setPwd(DigestUtil.md5("123456"));
		String sexStr = strArr[2];
		String sex = "";
		if("男".equals(sexStr)){
			sex = AdminConstant.SEX_MEN;
		}else if("女".equals(sexStr)){
			sex = AdminConstant.SEX_WOMEN;
		}
		sysUser.setSex(sex);
		sysUser.setPhoneNum(strArr[3]);
		sysUser.setPhoneNum2(strArr[4]);
		sysUser.setAddress(strArr[5]);
		
		String createtimeStr = strArr[6];
		sysUser.setCreatetime(DateUtil.strToDate(createtimeStr));
		String leavetimeStr = strArr[7];
		sysUser.setLeavetime(DateUtil.strToDate(leavetimeStr));
		
		return sysUser;
	}

	/**
	 * 导出
	 * @param response
	 */
	@RequestMapping("/export")
	@ResponseBody
	public void export2Excel(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = "users-"+ DateUtil.today2YyMMddHHmmss() +".xls";
			String sheetName = "用户";
			String[] titles = new String[]{"名称","登录名","性别","手机号","备用号","地址","部门id","入职时间","离职时间"};
			String[] fields = new String[]{"name","loginName","sexName","phoneNum","phoneNum2","address","deptid","createtime","leavetime"};
//			Map<String, Object> argsMap = JsonUtil.jsonStr2Map(teamInfo);
			Map<String, Object> argsMap = MyBeanUtil.getParameterMap(request);
			argsMap.put("state", "1");
			
			List<Map<String, Object>> list = sysUserService.select2Excel(argsMap);
			ExcelInfo excelInfo =new ExcelInfo(fileName, sheetName, titles, fields, list);
			excelInfo.setPageSize(5);
//			ExcelUtil.export2Http(excelInfo, response, true);
			ExcelUtil.export2Http(excelInfo, response, false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}