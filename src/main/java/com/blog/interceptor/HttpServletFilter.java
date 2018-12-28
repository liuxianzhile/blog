package com.blog.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blog.util.HttpServletRequestWrapperUtil;

/**
 * 请求参数过滤器
 * 作用：request的输入流  getReader()和getInputStream() 只能读取一次不能重复读取，
 * 我们在过滤器或拦截器里读取了request的输入流之后，请求走到controller层时就会报错。
 * 当我们调用getInputStream()方法获取输入流时得到的是一个InputStream对象，而实际类型是ServletInputStream，它继承于InputStream。
 * InputStream的read()方法内部有一个postion，标志当前流被读取到的位置，每读取一次，该标志就会移动一次，
 * 如果读到最后，read()会返回-1，表示已经读取完了。如果想要重新读取则需要调用reset()方法，
 * position就会移动到上次调用mark的位置，mark默认是0，所以就能从头再读了。
 * 调用reset()方法的前提是已经重写了reset()方法，当然能否reset也是有条件的，
 * 它取决于markSupported()方法是否返回true。
 * InputStream默认不实现reset()，并且markSupported()默认也是返回false
 * @file HttpServletFilter.java
 * @author FuNian Cui
 * @date 2018年12月28日 上午9:49:33
 */
public class HttpServletFilter implements  Filter{
	private static final Logger logger = LogManager.getLogger(UserInfoInterceptor.class);
	
	public void init(FilterConfig filterConfig) throws ServletException {}
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        logger.info("请求参数过滤器");
        if(request instanceof HttpServletRequest) {
            requestWrapper = new HttpServletRequestWrapperUtil((HttpServletRequest) request);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
    public void destroy() {}
}
