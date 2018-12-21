package com.blog.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.annotation.Before;
import com.blog.dto.UserResignDTO;
import com.blog.util.UserInfoValidationUtil;
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
	
	private static final Logger logger = LogManager.getLogger(UserProcessorController.class);
	
	/**
	 * 用户注册接口
	 * @param userResignDTO
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Before(UserInfoValidationUtil.class)
	public DefaultResultVO addAdmin(@RequestBody UserResignDTO userResignDTO) {
		logger.info("用户注册");
		return DefaultResultVO.success();
	}
}
