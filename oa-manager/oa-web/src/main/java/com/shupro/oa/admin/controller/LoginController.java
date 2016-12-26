package com.shupro.oa.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.digest.DigestUtil;
import com.shupro.core.vo.Result;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysUserService;

/**
 * 登录退出
 * @author shu
 *
 */
@Controller
//@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private SysUserService sysUserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response) {
    	int code = 500;
    	String message = "发生错误";
    	
        try {
        	String loginName = request.getParameter("loginName");
        	String password = request.getParameter("password");
			if (SystemUtil.isEmpty(loginName) || SystemUtil.isEmpty(password)) {
			    message = "用户名或密码不能为空";
			    
			}else{//检验通过
//				//给cookie的密码加上前缀后的处理
//				Cookie[] cookieArr = request.getCookies();
//				if(SystemUtil.isNotEmpty(cookieArr)){
//					for(Cookie cookie : cookieArr){
//						if("token".equals(cookie.getName())){
//							password = password.substring(3);
//						}
//					}
//				}
				//md5加密 密码
				String md5Pwd = DigestUtil.md5(password);
				SysUser sysUser = sysUserService.login(loginName, md5Pwd);
				if (null != sysUser) {
					if("1".equals(sysUser.getState())){
						//记住我
						rememberMe(loginName, password, request, response);
						
						//保存用户到session
						request.getSession().setAttribute("userInfo", sysUser);
						
						//成功显示首页
						code = 200;
						message = "/home";
					}else{
						message = "该用户已被删除";
					}
					
				}else{
					message = "用户名或密码错误";
				}
			}
		} catch (Exception e) {
			message = "发生异常";
			e.printStackTrace();
		}
    	
    	return new Result(code, message);
    }

    /**
     * 记住我,cookie 采用的是base64编码
     * @param sysUser
     */
	private void rememberMe(String loginName, String password, HttpServletRequest request, HttpServletResponse response) {
		// 1：创建Cookie，使用base64加密用户名和密码
		// Cookie中不能存放中文
		String tokenVal = "";
		try {
			String str = loginName + "," + password;
			tokenVal = DigestUtil.encodeBase64(str);
			tokenVal = URLEncoder.encode(tokenVal, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Cookie tokenCookie = new Cookie("token", tokenVal);
		// 2：判断页面中的复选框是否被选中，选中设置，不选中就不设置
		String remeberMe = request.getParameter("rememberMe");
		// 设置有效路径
		tokenCookie.setPath(request.getContextPath() + "/");
		// 选中
		if (remeberMe != null && remeberMe.equals("yes")) {
			// 设置有效时间
			tokenCookie.setMaxAge(7 * 24 * 60 * 60);// 1周
		} else {
			// 未选中,则清空
			tokenCookie.setMaxAge(0);
		}
		// 3：将Cookie存放到response对象
		response.addCookie(tokenCookie);
		
	}

	/**
     * 安全退出(ajax)
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logoutAjax(HttpServletRequest request) {
    	LOGGER.info("登出");
    	//由于使用ajax，跳转有前端来控制
    	request.getSession().removeAttribute("userInfo");
    	Result result = new Result(200, "/");
//    	result.setSuccess(true);
    	
        return result;
    }
    
    /**
     * 安全退出
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
    	LOGGER.info("登出");
    	//重定向到登录页面,如果有参数之类的建议使用RedirectAttributes
    	request.getSession().removeAttribute("userInfo");
    	
    	return "redirect:/";
    }
}
