package com.blog.service;

import com.blog.utils.UserInfoCacheUtil;

/**
 * 头像相关逻辑接口
 * @file AvatarQueryService.java
 * @author FuNian Cui
 * @date 2019年1月3日 下午1:49:33
 */
public class AvatarQueryService {
	/**
     * 默认头像地址
     */
    public static final String DEFAULT_AVATAR_URL = UserInfoCacheUtil.get("defaultThumbnailURL");
}
