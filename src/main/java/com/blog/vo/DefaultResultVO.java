package com.blog.vo;

import java.io.Serializable;

import com.blog.enums.ResultCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 
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

    public DefaultResultVO() {}

    public DefaultResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DefaultResultVO success() {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        return result;
    }
    
    public DefaultResultVO success(Object data) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public DefaultResultVO failure(ResultCodeEnum resultCode) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(resultCode);
        return result;
    }

    public DefaultResultVO failure(ResultCodeEnum resultCode, Object data) {
    	DefaultResultVO result = new DefaultResultVO();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    
	private void setResultCode(ResultCodeEnum success) {
		this.code = success.code();
        this.msg = success.message();
	}
}
