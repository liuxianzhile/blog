package com.blog.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 用户信息预存工具类
 * @file UserInfoCaacUtil.java
 * @author FuNian Cui
 * @date 2018年12月22日 上午11:22:52
 */
public class UserInfoCacheUtil {
	private static final Logger logger = LogManager.getLogger(UserInfoCacheUtil.class);
	/**
     * 配置文件
     */
    public static final Properties CFG = new Properties();
	/**
     * 用户匿名用户名
     */
    public static final String ANONYMOUS_USER_NAME = "someone";
    /**
     * 系统保留用户名
     */
    public static final String[] RESERVED_USER_NAMES;
    
    static {
    	//读取配置文件
        try {
            InputStream resourceAsStream;
            final String symPropsEnv = System.getenv("BLOG_CONFIG_PRO");
            if (StringUtils.isNotBlank(symPropsEnv)) {
            	logger.trace("用环境变量BLOG_CONFIG_PRO，读取配置文件 [$BLOG_CONFIG_PRO=" + symPropsEnv  + "\blog.properties" + "]");
                resourceAsStream = new FileInputStream(symPropsEnv + "\\blog.properties");
            } else {
            	logger.trace("从ClassPath中获取配置文件blog.properties [/blog.properties]");
            	resourceAsStream = UserInfoCacheUtil.class.getClassLoader().getResourceAsStream("/blog.properties");
            }
            CFG.load(resourceAsStream);
        } catch (final Exception e) {
        	logger.log(Level.ERROR, "获取blog.properties配置文件失败", e);
            //System.exit(-1);
        }
    }
    
    static {
    	//读取保留用户名名单
        final String reservedUserNames = CFG.getProperty("reservedUserNames");
        final String[] userNames = reservedUserNames.split(",");
        RESERVED_USER_NAMES = new String[userNames.length];
        for (int i = 0; i < userNames.length; i++) {
            final String userName = userNames[i];
            RESERVED_USER_NAMES[i] = userName.trim();
        }
    }
    
    /**
     * 获取当前配置文件中对应键的所属值为Long的值
     * @param 指定键值
     * @return 对应键的所属值, 如果未找到对应键值对 返回{@code null} 
     */
    public static Long getLong(final String key) {
        final String stringValue = CFG.getProperty(key);
        if (null == stringValue) {
            return null;
        }
        return Long.valueOf(stringValue);
    }
    
    
    /**
     * 获取当前配置文件中对应键的所属值为boolean的值
     * @param 指定键值
     * @return 对应键的所属值, 如果未找到对应键值对 返回{@code null}
     */
    public static Boolean getBoolean(final String key) {
        final String stringValue = CFG.getProperty(key);
        if (null == stringValue) {
            return null;
        }
        return Boolean.valueOf(stringValue);
    }

    /**
     * 获取当前配置文件中对应键的所属值为Float的值
     * @param 指定键值
     * @return 对应键的所属值, 如果未找到对应键值对 返回{@code null}
     */
    public static Float getFloat(final String key) {
        final String stringValue = CFG.getProperty(key);
        if (null == stringValue) {
            return null;
        }
        return Float.valueOf(stringValue);
    }

    /**
     * 获取当前配置文件中对应键的所属值为Integer的值
     * @param 指定键值
     * @return 对应键的所属值, 如果未找到对应键值对 返回{@code null}
     */
    public static Integer getInt(final String key) {
        final String stringValue = CFG.getProperty(key);
        if (null == stringValue) {
            return null;
        }
        return Integer.valueOf(stringValue);
    }
    
    /**
     * 获取当前配置文件中对应键的所属值
     * @param key 指定键值
     * @return 对应键的所属值, 如果未找到对应键值对 返回{@code null}
     */
    public static String get(final String key) {
        return CFG.getProperty(key);
    }
}
