package com.blog.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.blog.annotation.Before;
import com.blog.enums.ResultCodeEnum;
import com.blog.util.GetRequestJSONUtils;
import com.blog.util.UserInfoValidationUtil;
import com.blog.vo.DefaultResultVO;

/**
 * @file UserInfoInterceptor.java
 * @author FuNian Cui
 * @date 2018年12月25日 下午1:16:55
 */
public class UserInfoInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
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
        	String jsonString = GetRequestJSONUtils.getRequestJsonString(request);
        	JSONObject jsonObject = JSONObject.parseObject(jsonString);
        	if(!UserInfoValidationUtil.validationUserName(jsonObject.getString("userName"))) {
        		//重置response
                response.reset();
                //设置编码格式
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                
                //返回前端错误信息
                PrintWriter pw = response.getWriter();
                pw.write(JSONObject.toJSONString(new DefaultResultVO(ResultCodeEnum.USER_REGISTER_NAME_ERROR)));
                pw.flush();
                pw.close();
        		// 校验不通过返回false, 拦截请求
        		return false;
        	}
        }
		return true;
	}
}
