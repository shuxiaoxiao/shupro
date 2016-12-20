package com.shupro.oa.aop;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.shupro.core.utils.MyBeanUtil;
import com.shupro.core.utils.SystemUtil;
import com.shupro.core.utils.json.JsonUtil;
import com.shupro.oa.admin.model.SysLog;
import com.shupro.oa.admin.model.SysUser;
import com.shupro.oa.admin.service.SysLogService;

/**
 * @description：AOP 系统日志
 * 
 * @author：shuheng
 */
@Aspect
@Component
public class SysLogAop {
    private static Logger LOGGER = LoggerFactory.getLogger(SysLogAop.class);

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void cutController() {
    }

    @Around("cutController()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        String strMethodName = point.getSignature().getName();
        //tologin 则直接跳过
        if("tologin".equals(strMethodName)){
        	return point.proceed();
    	}
        String strClassName = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();
        SysUser userInfo = null;
        String strMessage = "";
        String clientip = "";
        HttpServletRequest request = null;
        if (SystemUtil.isNotEmpty(params)) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            userInfo = (SysUser) request.getSession().getAttribute("userInfo");
            // 获取请求ip
            clientip = request.getRemoteAddr();
            // 获取请求地址  
            String requestPath = request.getRequestURI();
            // 获取输入参数
            Map<String, Object> inputParamMap = MyBeanUtil.getParameterMap(request); 
//            //获取输入参数(方式二)
//            Map<String, String[]> inputParamMap = request.getParameterMap(); 
            strMessage = String.format("[类名]:%s,[方法]:%s,[请求路径]:%s,[参数]:%s", 
            		strClassName, strMethodName,requestPath, JsonUtil.obj2JsonStr(inputParamMap));
            LOGGER.info(strMessage);
        }

        if (isWriteLog(strMethodName)) {
            try {
//                Subject currentUser = SecurityUtils.getSubject();
//                PrincipalCollection collection = currentUser.getPrincipals();
//                if (null != collection) {
//                    String loginName = collection.getPrimaryPrincipal().toString();
            	if (null != request) {
            		if(null != userInfo) {
                		SysLog sysLog = new SysLog();
                		sysLog.setLoginName(userInfo.getLoginname());
                		sysLog.setRoleName(userInfo.getRolename());
                		sysLog.setContent(strMessage);
                		sysLog.setCreatetime(new Date());
                		sysLog.setClientIp(clientip);
                		LOGGER.info(sysLog.toString());
                		sysLogService.insert(sysLog);
                	}else{
                		LOGGER.info("用户未登录");
                	}
				}else{
					LOGGER.info("页面加载操作");
				}
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return point.proceed();
    }
    //init开头的方法都暂时记录,为了记录点击次数
    private boolean isWriteLog(String method) {
        String[] pattern = {"login", "logout", "init", "add", "save", "insert", "edit", "update", "delete", "grant"};
        for (String s : pattern) {
            if (method.indexOf(s) > -1) {
                return true;
            }
        }
        return false;
    }
}
