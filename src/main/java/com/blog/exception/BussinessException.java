package com.blog.exception;

import com.blog.enums.ResultCodeEnum;

/**
 * 业备异常信息,所有的异常信息要进行捕捉包装成业务异常
 * @file BussinessException.java
 * @author FuNian Cui
 * @date 2018年12月20日 上午9:39:03
 */
public class BussinessException extends RuntimeException{
	private static final long serialVersionUID = 2185078233520175564L;
	
	private Integer code;
	
	private String message;

	public BussinessException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	
	public BussinessException(ResultCodeEnum resultCodeEnum) {
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
	}
	
	public BussinessException(Integer code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
	}
	
	public BussinessException(ResultCodeEnum resultCodeEnum, Throwable throwable) {
		super(resultCodeEnum.getMessage(), throwable);
		this.code = resultCodeEnum.getCode();
	}
	
	//测试异常类
	public static void main(String[] args) {
        try{
            int i = 1/0;
            System.out.println(i);
        }catch (Exception e){
            throw new BussinessException(ResultCodeEnum.SPECIFIED_QUESTIONED_USER_NOT_EXIST, e);
        }
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
