package com.blog.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * @file TestUserInfo.java
 * @author FuNian Cui
 * @date 2018年12月22日 上午11:47:02
 */
public class TestUserInfo {
	public static final Properties CFG = new Properties();
	@Test
	public void testSysEvn() throws IOException {
		InputStream resourceAsStream = null;
		final String symPropsEnv = System.getenv("BLOG_CONFIG_PRO");
        try {
			resourceAsStream = new FileInputStream(symPropsEnv + "\\blog.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        CFG.load(resourceAsStream);
	}
}
