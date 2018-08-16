package com.zthack.drip.utils;

/**
 * Created by LiChao on 2018/8/1.
 */
public class IDUtil {

    private static IdWorker instance = null;

    private static Integer workId = 0;

    private static Integer dataId = 0;

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
