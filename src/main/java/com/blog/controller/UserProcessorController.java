package com.blog.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.vo.DefaultResultVO;

/**
 * @file UserProcessorController.java
 * @author FuNian Cui
 * @date 2018年12月14日 下午3:25:36
 */
@RestController
@RequestMapping("api/admin")
public class UserProcessorController {
	private static final Logger logger = LogManager.getLogger(UserProcessorController.class);
	
	public DefaultResultVO addAdmin() {
		logger.info("用户注册");
		DefaultResultVO resp = new DefaultResultVO();
		resp.success();
		
		return resp;
	}
}
