package com.blog.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogUserMapper;
import com.blog.dao.SysOptionMapper;
import com.blog.dto.UserResignDTO;
import com.blog.enums.ResultCodeEnum;
import com.blog.exception.BussinessException;
import com.blog.model.BlogUser;
import com.blog.model.SysOption;
import com.blog.utils.UserInfoCacheUtil;
import com.blog.utils.UserInfoValidationUtil;

import cn.hutool.core.bean.BeanUtil;

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
	@Autowired
	private SysOptionMapper sysOptionMapper; 
	
	private static final Logger logger = LogManager.getLogger(UserProcessorService.class);

	/**
	 * 用户注册
	 * @param userResignDTO
	 * @return 
	 */
	@Transactional
	public Integer registerUser(UserResignDTO userResignDTO) {
		boolean updateFlag = false;
		//查询用户名是否存在
		BlogUser blogUser = blogUserMapper.queryUserByUserName(userResignDTO.getUserName());
		//如果存在判断用户状态
		if(null != blogUser && (UserInfoValidationUtil.USER_STATUS_VALID == userResignDTO.getUserStatus()
                || UserInfoValidationUtil.USER_STATUS_INVALID_LOGIN == userResignDTO.getUserStatus()
                || UserInfoValidationUtil.USER_STATUS_DEACTIVATED == userResignDTO.getUserStatus()
                || UserInfoValidationUtil.NULL_USER_NAME.equals(userResignDTO.getUserName()))) {
			throw new BussinessException(ResultCodeEnum.USER_HAS_EXISTED);
		}
		//查询用户邮箱是否存在
		blogUser = blogUserMapper.queryUserByEmail(userResignDTO.getUserEmail());
		//如果存在判断用户状态
		if(blogUser != null) {
			if(UserInfoValidationUtil.USER_STATUS_VALID == userResignDTO.getUserStatus()
	                || UserInfoValidationUtil.USER_STATUS_INVALID_LOGIN == userResignDTO.getUserStatus()
	                || UserInfoValidationUtil.USER_STATUS_DEACTIVATED == userResignDTO.getUserStatus()) {
				throw new BussinessException(ResultCodeEnum.USER_HAS_EXISTED);
			}
			updateFlag = true;
		}
		
		BeanUtil.copyProperties(userResignDTO, blogUser);
		
		if(updateFlag) {
			//更新用户信息
			if (!AvatarQueryService.DEFAULT_AVATAR_URL.equals(userResignDTO.getUserAvatarUrl())) {
                if (UserInfoCacheUtil.getBoolean("qiniu.enabled")) {
                	blogUser.setUserAvatarUrl(UserInfoCacheUtil.get("qiniu.domain") + "/avatar/" + blogUser.getUserNo() + "?" + new Date().getTime());
                } else {
                	blogUser.setUserAvatarUrl(userResignDTO.getUserAvatarUrl() + "?" + new Date().getTime());
                }

                if (255 < userResignDTO.getUserAvatarUrl().length()) {
                	logger.warn("用户 [" + userResignDTO.getUserName() + "]的头像地址[" + userResignDTO.getUserAvatarUrl() + "] 超过了255");
                    blogUser.setUserAvatarUrl(AvatarQueryService.DEFAULT_AVATAR_URL);
                }
                blogUserMapper.updateByIdSelective(blogUser);
            }
		} else {
			//新增用户信息
			blogUserMapper.save(blogUser);
			
			//用户数量统计
			SysOption sysOption = sysOptionMapper.selectByOptionId("statisticMemberCount");
			sysOption.setOptionValue(String.valueOf(Integer.valueOf(sysOption.getOptionValue()) + 1));
			sysOptionMapper.updateByIdSelective(sysOption);
		}
		return blogUser.getUserNo();
	}
}
