package com.blog.vo;

import java.io.Serializable;

import com.blog.enums.ResultCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 返回前端JSON封装
 * @file DefaultResultVO.java
 * @author FuNian Cui
 * @date 2018年12月14日 下午4:47:49
 */
@Data
@JsonInclude(Include.NON_NULL)
public class DefaultResultVO implements Serializable{

	private static final long serialVersionUID = 5566637251972355902L;
	
	private Integer code;

    private String msg;

    private Object data;
    
    public DefaultResultVO() {
		super();
	}
    
    public DefaultResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public DefaultResultVO(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public DefaultResultVO(ResultCodeEnum resultCode) {
    	this.code = resultCode.getCode();
    	this.msg = resultCode.getMessage();
    }
    
    public DefaultResultVO(ResultCodeEnum resultCode, Object data) {
    	this.code = resultCode.getCode();
    	this.msg = resultCode.getMessage();
    	this.data = data;
    }

    public static DefaultResultVO success() {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        return result;
    }
    
    public static DefaultResultVO success(Object data) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static DefaultResultVO failure(ResultCodeEnum resultCode) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(resultCode);
        return result;
    }

    public static DefaultResultVO failure(ResultCodeEnum resultCode, Object data) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    
	private void setResultCode(ResultCodeEnum success) {
		this.code = success.getCode();
        this.msg = success.getMessage();
	}
}
