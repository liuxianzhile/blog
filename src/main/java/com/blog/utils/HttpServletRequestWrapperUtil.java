package com.blog.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @file HttpServletRequestWrapperUtil.java
 * @author FuNian Cui
 * @date 2018年12月26日 下午5:41:35
 */
public class HttpServletRequestWrapperUtil extends HttpServletRequestWrapper {
	private static final Logger logger = LogManager.getLogger(HttpServletRequestWrapperUtil.class);
	private final byte[] body;
	
	/**
	 * 构造方法
	 * @param request
	 * @throws IOException 
	 */
	public HttpServletRequestWrapperUtil(HttpServletRequest request) throws IOException {
		super(request);
        String sessionStream = getBodyString(request);
        body = sessionStream.getBytes(Charset.forName("UTF-8"));
        logger.info("保存的流" + sessionStream);
	}
    
	/**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public String getBodyString(final ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = cloneInputStream(request.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * 复制输入流
     * @param inputStream
     * @return
     */
    public InputStream cloneInputStream(ServletInputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buffer)) > -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
    
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }
            
            @Override
            public boolean isFinished() {
                return false;
            }
            
            @Override
            public boolean isReady() {
                return false;
            }
            
            @Override
            public void setReadListener(ReadListener readListener) {}
        };
	}
	
	public byte[] getBody() {
        return this.body;
    }
}
