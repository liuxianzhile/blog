package com.blog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.blog.annotation.advice.ProcessAdvice;


/**
 * 调用接口之前进行初始化
 * 在定义注解类时使用了另一个注解类Retention 在注解类上使用另一个注解类，那么被使用的注解类就称为元注解
 * 注解就相当于一个你的源程序要调用一个类，在源程序中应用某个注解，得事先准备好这个注解类。就像你要调用某个类，得事先开发好这个类。
 * @file Before.java
 * @author FuNian Cui
 * @date 2018年12月21日 下午3:19:44
 */
//Target注解决定注解可以加在哪些成分上，如加在类身上，或者属性身上，或者方法身上等成分
@Target({ElementType.METHOD, ElementType.TYPE})
//Retention注解决定注解的生命周期
/*@Retention元注解的讲解：其三种取值：
RetentionPolicy.SOURCE  ----> Java源文件(.java文件) 该注解只在java源文件中存在，编译成.class文件后注解就不存在了
RetentionPolicy.CLASS   ----> .class文件  注解在java源文件(.java文件)中存在，编译成.class文件后注解也还存在，被注解类标识的类被类加载器加载到内存中后注解就不存在了
RetentionPolicy.RUNTIME ----> 内存中的字节码*/
@Retention(RetentionPolicy.RUNTIME)


public @interface Before {
	
	/*
	 * 定义基本属性value
	 * default指定value默认缺省值
	 */
	Class<? extends ProcessAdvice>[] value() default ProcessAdvice.class;
}
