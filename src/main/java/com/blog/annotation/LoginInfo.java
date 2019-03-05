package com.blog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 传递用户信息，读取请求中的token，根据token获取到用户信息，将用户信息通过自定义注解的方式传递到控制层。
 * @file LoginInfo.java
 * @author FuNian Cui
 * @date 2019年2月18日 下午2:24:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface LoginInfo {

}
