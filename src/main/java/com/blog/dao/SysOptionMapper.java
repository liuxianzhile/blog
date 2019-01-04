package com.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.blog.model.SysOption;

/**
 * Mapper类，，对应表sys_option
 */
public interface SysOptionMapper extends Dao<SysOption>{

	/**
	 * 根据ID查询相应信息
	 * @param string
	 */
	SysOption selectByOptionId(@Param(value = "id")String id);
}