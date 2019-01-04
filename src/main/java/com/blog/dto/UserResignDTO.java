package com.blog.dto;

import lombok.Data;

/**
 * @file UserResignDTO.java
 * @author FuNian Cui
 * @date 2018年12月17日 下午12:23:16
 */
@Data
public class UserResignDTO {
	//用户姓名
	private String userName;
	//用户邮箱
	private String userEmail;
	//用户状态
	private Integer userStatus;
	//头像图片URL
	private String userAvatarUrl;
}
