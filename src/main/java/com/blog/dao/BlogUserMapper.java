package com.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.blog.model.BlogUser;

/**
 * Mapper类 对应表blog_user
 */

public interface BlogUserMapper extends Dao<BlogUser>{

	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	BlogUser queryUserByUserName(@Param(value = "userName")String userName);

	/**
	 * 根据邮箱查询用户信息
	 * @param userEmail
	 * @return
	 */
	BlogUser queryUserByEmail(@Param(value = "userEmail")String userEmail);
}