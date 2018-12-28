package com.blog.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.model.Model;
import com.github.pagehelper.Page;

/**
 * DAO的基接口 其他基类都可以实现该或者基础该接口
 * @file Dao.java
 * @author FuNian Cui
 * @date 2018年12月26日 下午4:44:14
 */
public interface Dao<T extends Model> {
	/**
     * 保存新增的对象.
     */
    int save(final T entity);

    /**
     * 按id获取对象.
     */
    T selectById(final Long id);

    /**
     * 分页获取所有数据
     */
    Page<T> selectAllPage(final Map<String, Object> map);


    /**
     * 按id删除对象.
     */
    int deleteById(final Long id);


    /**
     * 根据id修改数据.
     */
    int updateByIdSelective(final T entity);

    /**
     * 批量保存
     * @param entityList
     */
    int batchInsert(List<T> entityList);

    /**
     * 单条逻辑删除-单条更新状态为作废
     * @param id
     * @return
     */
    int logicalSelectById(@Param("updateUserId") long updateUserId, @Param("updateUserName") String updateUserName, @Param("id") long id, @Param("updateTime") Timestamp updateTime);

    /**
     * 批量逻辑删除-批量更新状态为作废
     * @param entityList
     * @return
     */
    int batchLogicalSelectById(@Param("list") List<Long> ids,@Param("updateUserId") long updateUserId, @Param("updateUserName") String updateUserName, @Param("updateTime") Timestamp updateTime);
}
