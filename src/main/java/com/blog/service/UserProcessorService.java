package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogUserMapper;
import com.blog.dto.UserResignDTO;
import com.blog.model.BlogUser;

/**
 * 用户登录注册相关逻辑
 * @file UserProcessorService.java
 * @author FuNian Cui
 * @date 2018年12月26日 上午11:22:21
 */
@Service
public class UserProcessorService {
	@Autowired
	private BlogUserMapper blogUserMapper; 

	/**
	 * 
	 * @param userResignDTO
	 * @return 
	 */
	public BlogUser registerUser(UserResignDTO userResignDTO) {
		return blogUserMapper.selectById(null);
	}
}
