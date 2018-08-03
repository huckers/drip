package com.zthack.drip.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by LiChao on 2018/8/1.
 */
public class IDUtil {

    private static IdWorker instance = null;

    @Value("${IdWorker.workerId}")
    private static Integer workId;

    @Value("${IdWorker.dataId}")
    private static Integer dataId;

    private IDUtil() {

    }

    public static IdWorker getInstance() {
        if (instance == null) {
            synchronized (IDUtil.class) {
                if (instance == null) {
                    instance = new IdWorker(workId, dataId);
                }
            }
        }
        return instance;
    }

    public static long getId() {
        return getInstance().nextId();
    }
}
