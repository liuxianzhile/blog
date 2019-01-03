package com.blog.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.blog.annotation.Before;
import com.blog.enums.ResultCodeEnum;
import com.blog.utils.GetRequestJSONUtil;
import com.blog.utils.HttpServletRequestWrapperUtil;
import com.blog.utils.UserInfoValidationUtil;
import com.blog.vo.DefaultResultVO;

/**
 * 用户信息校验拦截器
 * @file UserInfoInterceptor.java
 * @author FuNian Cui
 * @date 2018年12月25日 下午1:16:55
 */
public class UserInfoInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LogManager.getLogger(UserInfoInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        //获取请求参数
    	//new HttpServletRequestWrapperUtil(request).getBodyString(request);
        
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Access注解
        Before before = method.getAnnotation(Before.class);
        
        if (before == null) {
        	// 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        } else {
        	//进行校验
        	//ServletRequest的getReader()和getInputStream()两个方法只能被调用一次，而且不能两个都调用。
        	String jsonString = GetRequestJSONUtil.getRequestJsonString(request);
        	JSONObject jsonObject = JSONObject.parseObject(jsonString);
        	logger.info("jsonObject：" + jsonObject);
        	
        	if(!UserInfoValidationUtil.validationUserName(jsonObject.getString("userName"))) {
        		//重置response
                response.reset();
                //设置编码格式
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                //response.setHeader("Content-type", "application/json;charset=UTF-8");
                
                //返回前端错误信息
                PrintWriter pw = response.getWriter();
                pw.write(JSONObject.toJSONString(new DefaultResultVO(ResultCodeEnum.USER_REGISTER_NAME_ERROR)));
                pw.flush();
                pw.close();
        		// 校验不通过返回false, 拦截请求
        		return false;
        	}
        }
        
        HttpServletRequestWrapperUtil requestWrapper = new HttpServletRequestWrapperUtil(request);
        byte[] body = requestWrapper.getBody();
        logger.info("请求Body: （" + body.length + "）" + body.toString());
        // 默认记录后台接口请求日志记录
        String url = requestWrapper.getRequestURL().toString();
        String methodName = requestWrapper.getMethod();
        String uri = requestWrapper.getRequestURI();
        //获取带参数查询。 post方法传的参数，getQueryString（）得不到，它只对get方法得到的数据有效。
        String queryString = requestWrapper.getQueryString();
        logger.info(String.format("请求参数, url: %s, method: %s, uri: %s, params: %s ", url, methodName, uri, queryString));
        return true;
	}
}
