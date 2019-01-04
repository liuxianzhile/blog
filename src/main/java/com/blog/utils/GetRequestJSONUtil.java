package com.blog.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * request 对象的相关操作
 * @file GetRequestJSONUtils.java
 * @author FuNian Cui
 * @date 2018年12月25日 下午3:24:29
 */
public class GetRequestJSONUtil {

	/**
	 * request 中 json 字符串的内容
	 * @param request
	 * @return String
	 * @throws IOException 
	 */
    public static String getRequestJsonString(HttpServletRequest request) throws IOException {
    	String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
        // POST
        } else {
            return getRequestPostStr(request);
        }
    }
    
    /**
     * post 请求内容
     * @param request
     * @return String
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request) throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
    
    /**      
     * post 请求的 byte[] 数组
     * @param request
     * @return byte[]
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength < 0) { 
        	return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
}