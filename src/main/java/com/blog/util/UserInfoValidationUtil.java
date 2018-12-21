package com.blog.util;

import com.alibaba.druid.util.StringUtils;
import com.blog.annotation.advice.ProcessAdvice;

/**
 * 用户数据信息校验
 * @file UserInfoValidationUtil.java
 * @author FuNian Cui
 * @date 2018年12月21日 下午5:20:00
 */
public class UserInfoValidationUtil extends ProcessAdvice{
	
	public static boolean validationUserName(final String userName) { 
		if(StringUtils.isEmpty(userName)) {
			return false;
		}
		
		return true;
	}
}
