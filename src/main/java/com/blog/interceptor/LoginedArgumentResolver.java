package com.blog.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.blog.annotation.LoginInfo;
import com.blog.dto.UserResignDTO;
import com.blog.utils.UserInfoValidationUtil;

/**
 * @file LoginedArgumentResolver.java
 * @author FuNian Cui
 * @date 2019年2月18日 下午2:51:15
 */
public class LoginedArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterAnnotation(LoginInfo.class) != null
                && parameter.getParameterType() == UserResignDTO.class) {
            // 如果该参数注解有@Logined才会执行下面的resolveArgument方法
            return true;
        }
        return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		return request.getSession().getAttribute(UserInfoValidationUtil.REDIS_LOGIN_USER_KEY);
		
        /*String accessToken = request.getHeader(UserInfoValidationUtil.ACCESS_TOKEN_KEY);
        UserResignDTO loginUser = RedisUtil.get(UserInfoValidationUtil.REDIS_LOGIN_USER_KEY + accessToken);
        return loginUser;*/
	}
}
