package com.shupro.oa.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shupro.core.utils.digest.DigestUtil;
import com.shupro.oa.admin.model.SysUser;

/**
 * 拦截器
 * @author shu
 *
 */
public class SecurityInterceptor implements HandlerInterceptor {

	//1
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SysUser userInfo = (SysUser) request.getSession().getAttribute("userInfo");
		String requestURL = request.getRequestURI();
		System.out.println(requestURL);
		//本应该在配置文件放行，但为了登录页面的 "记住我" 功能特殊处理 【暂不安全】
		if("/tologin".equals(requestURL)){
			//特殊处理
			getCookies2LoginPage(request);
		}else{
			if (userInfo == null) {
				String url = request.getContextPath() + "/";
				// 考虑到可能有多层路径,如sysUser/init,这时重定向建议使用绝对路径
				response.sendRedirect(url);
//				response.sendRedirect(url + "tologin");
			}
		}
		return true;
	}

	//2
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	//3
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	} 
	
	/**
	 * 采用cookie的解决方法，缺点是密码明文了
	 */
	private void getCookies2LoginPage(HttpServletRequest request) {
		//用户名
		String loginName = "";
		//密码
		String password = "";
		//复选框
		String checked = "";
		//从Cookie中获取记住我中存放的登录名和密码
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie cookie:cookies){
				if("token".equals(cookie.getName())){
					
					String tokenVal = cookie.getValue();
					try {
						tokenVal = URLDecoder.decode(tokenVal, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					//base64解码
					String decodeVal = DigestUtil.decodeBase64(tokenVal);
					String[] strArr = decodeVal.split(",");
					loginName = strArr[0];
					password = strArr[1];
//					for (int i = 0, max = strArr.length; i < max; i++) {
//					}
					//复选框选中
					checked = "checked";
				}
				
			}
		}
		//存放到request中
		request.setAttribute("loginName", loginName);
		request.setAttribute("password", password);
		request.setAttribute("checked", checked);
	}

}
