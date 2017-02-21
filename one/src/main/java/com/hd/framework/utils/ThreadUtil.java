package com.hd.framework.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author yj
 * 线程池管理
 *
 */
public abstract class ThreadUtil {
	
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(16);

    public static ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }
    
}
