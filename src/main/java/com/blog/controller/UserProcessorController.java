package com.blog.controller;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.annotation.Before;
import com.blog.dto.UserResignDTO;
import com.blog.interceptor.UserInfoInterceptor;
import com.blog.model.BlogUser;
import com.blog.service.UserProcessorService;
import com.blog.vo.DefaultResultVO;

/**
 * 用户登录/注册相关接口
 * @file UserProcessorController.java
 * @author FuNian Cui
 * @date 2018年12月14日 下午3:25:36
 */
@RestController
@RequestMapping("api/admin")
public class UserProcessorController {
	@Autowired
	private UserProcessorService userProcessorService; 
	
	private static final Logger logger = LogManager.getLogger(UserProcessorController.class);
	
	/**
	 * 用户注册接口
	 * @param userResignDTO 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Before(UserInfoInterceptor.class)
	public DefaultResultVO addAdmin(@RequestBody UserResignDTO userResignDTO) {
		logger.info("用户注册");
		BlogUser blogUser = new BlogUser();
		try {
			userProcessorService.registerUser(userResignDTO);
		} catch(Exception e) {
			logger.error("错误信息", e);
		}
		return DefaultResultVO.success(blogUser);
	}
	
	//测试自定义注解Before
	public static void main(String[] args) throws Exception{
		Class<UserProcessorController> clz = UserProcessorController.class;
		Method method = clz.getMethod("addAdmin", UserResignDTO.class);
		if(method.isAnnotationPresent(Before.class)) {
			System.out.println(method.getAnnotation(Before.class));
        }
    }
}
