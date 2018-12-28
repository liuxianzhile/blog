package com.blog.model;

import java.sql.Timestamp;

/**
 * 所有Model的基类
 * @file Model.java
 * @author FuNian Cui
 * @date 2018年12月26日 下午4:44:55
 */
public class Model {
	/** 主键 */
    private Long id;
	/** 数据备注 */
    private String dataMisc;
    /** 数据是否有效（0 无效 1 有效） */
    private Integer dataStatus;
    /** 创建时间 */
    private Timestamp createTime;
    /** 创建人ID */
    private Long createUserId;
    /** 创建人姓名 */
    private String createUserName;
    /** 修改时间 */
    private Timestamp updateTime;
    /** 修改人ID */
    private Long updateUserId;
    /** 修改人姓名 */
    private String updateUserName;
    
    /** 创建时间 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/** 创建时间 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/** 修改时间 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	/** 修改时间 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	/** 主键 */
	public Long getId() {
		return id;
	}
	/** 主键 */
	public void setId(Long id) {
		this.id = id;
	}
	/** 数据备注 */
    public String getDataMisc(){ 
        return dataMisc;
    } 
    /** 数据备注 */
    public void setDataMisc(String dataMisc){ 
        this.dataMisc = dataMisc;
    }
    /** 数据是否有效（0 无效 1 有效） */
    public Integer getDataStatus(){ 
        return dataStatus;
    } 
    /** 数据是否有效（0 无效 1 有效） */
    public void setDataStatus(Integer dataStatus){ 
        this.dataStatus = dataStatus;
    }
    /** 创建人ID */
    public Long getCreateUserId(){ 
        return createUserId;
    } 
    /** 创建人ID */
    public void setCreateUserId(Long createUserId){ 
        this.createUserId = createUserId;
    }
    /** 创建人姓名 */
    public String getCreateUserName(){ 
        return createUserName;
    } 
    /** 创建人姓名 */
    public void setCreateUserName(String createUserName){ 
        this.createUserName = createUserName;
    }
    /** 修改人ID */
    public Long getUpdateUserId(){ 
        return updateUserId;
    } 
    /** 修改人ID */
    public void setUpdateUserId(Long updateUserId){ 
        this.updateUserId = updateUserId;
    }
    /** 修改人姓名 */
    public String getUpdateUserName(){ 
        return updateUserName;
    } 
    /** 修改人姓名 */
    public void setUpdateUserName(String updateUserName){ 
        this.updateUserName = updateUserName;
    }
}
