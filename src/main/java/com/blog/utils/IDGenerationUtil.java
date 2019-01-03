package com.blog.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生成编号工具类
 * @file IDGenerationUtil.java
 * @author FuNian Cui
 * @date 2019年1月3日 下午2:52:01
 */
public class IDGenerationUtil {
	/**
     * 生成唯一ID的锁
     */
    private static final Lock ID_GEN_LOCK = new ReentrantLock();
    /**
     * 睡眠间隔时间
     */
    private static final long ID_GEN_SLEEP_MILLIS = 50;
    
    private IDGenerationUtil() {
    }

    /**
     * 获取当前时间字符串
     *
     * <p>
     * <b>Note</b>: 这种方法在集群环境中并不安全
     * </p>
     *
     * @return 时间字符串
     */
    public static synchronized String genTimeMillisId() {
        String ret;

        ID_GEN_LOCK.lock();
        try {
            ret = String.valueOf(System.currentTimeMillis());

            try {
                Thread.sleep(ID_GEN_SLEEP_MILLIS);
            } catch (final InterruptedException e) {
                throw new RuntimeException("Generates time millis id fail");
            }
        } finally {
            ID_GEN_LOCK.unlock();
        }

        return ret;
    }
}
