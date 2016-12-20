package com.shupro.oa.admin.controller;

import javax.servlet.http.HttpServletRequest;

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
    public Result login(HttpServletRequest request) {
    	int code = 500;
    	String message = "发生错误";
    	
        try {
        	String loginname = request.getParameter("loginname");
        	String password = request.getParameter("password");
			if (SystemUtil.isEmpty(loginname) || SystemUtil.isEmpty(password)) {
			    message = "用户名或密码不能为空";
			    
			}else{//检验通过
				//md5加密 密码
				password = DigestUtil.md5(password);
				SysUser sysUser = sysUserService.login(loginname, password);
				if (null != sysUser) {
					//保存用户到session
					request.getSession().setAttribute("userInfo", sysUser);
					
					//成功显示首页
					code = 200;
					message = "/home";
					
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
    	Result result = new Result(200, "/tologin");
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
    	
    	return "redirect:/tologin";
    }
}
