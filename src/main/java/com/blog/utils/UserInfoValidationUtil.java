package com.blog.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 用户数据信息校验工具类
 * @file UserInfoValidationUtil.java
 * @author FuNian Cui
 * @date 2018年12月21日 下午5:20:00
 */
public class UserInfoValidationUtil{
	/**
     * 用户名最大长度
     */
    public static final int MAX_USER_NAME_LENGTH = 20;
    
    /**
     * 用户名最小长度
     */
    public static final int MIN_USER_NAME_LENGTH = 1;
    
	/**
     * 用户状态 - 合法
     */
    public static final int USER_STATUS_VALID = 0;
    
    /**
     * 用户状态 - 无效登录
     */
	public static final int USER_STATUS_INVALID_LOGIN = 3;
	
	/**
     * 用户状态 - 账号失效
     */
    public static final int USER_STATUS_DEACTIVATED = 4;
    
    /**
     * 空用户名
     */
	public static final String NULL_USER_NAME = "_";
	
	/**
	 * 用户姓名校验
	 * 有效用户名需满足：
	 * 		字数 [1, 20]
	 * 		内容 {a-z, A-Z, 0-9}
	 * @param userName 用户指定用户名
	 * @return {@code true} 合法用户名, {@code false} 非法用户名
	 */
	public static boolean validationUserName(final String userName) { 
		//检查指定用户名是否为空
		if(StringUtils.isEmpty(userName)) {
			return false;
		}
		
		//检查指定用户名是否为保留用户名
		if(isReservedUserName(userName)) {
			return false;
		}
		
		//检查指定用户名长度是否合法
		final Integer userNameLength = userName.length();
		if(userNameLength < MIN_USER_NAME_LENGTH || userNameLength > MAX_USER_NAME_LENGTH) {
			return false;
		}
		
		//检查指定用户名内容是否合法
		char userNameContent;
		for(int i = 0; i < userNameLength; i++) {
			userNameContent = userName.charAt(i);
			if((userNameContent <= 'z' && userNameContent >= 'a') ||
					(userNameContent <= 'Z' && userNameContent >= 'A') ||
					(userNameContent <= '9' && userNameContent >= '0')) {
				continue;
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 检查指定的用户名是否为保留用户名
	 * @param userName 用户指定用户名
	 * @return {@code true} 是保留用户名, {@code false} 不是保留用户名
	 */
	public static boolean isReservedUserName(final String userName) {
		//指定用户名逐一对比保留名名单列表
        for (final String reservedUserName : UserInfoCacheUtil.RESERVED_USER_NAMES) {
            if (StringUtils.equalsIgnoreCase(userName, reservedUserName)) {
                return true;
            }
        }
        return StringUtils.containsIgnoreCase(userName, UserInfoCacheUtil.ANONYMOUS_USER_NAME);
    }
}
