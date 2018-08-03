package com.zthack.drip.model.dto;

import lombok.Data;

/**
 * 返回的json数据
 *
 * Created by LiChao on 2018/8/2.
 */
@Data
public class JsonResponse {

    /**
     * 返回的状态码，0：失败，1：成功
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object result;

    /**
     * 不返回数据的构造方法
     *
     * @param code 状态码
     * @param msg  信息
     */
    public JsonResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回数据的构造方法
     *
     * @param code   状态码
     * @param msg    信息
     * @param result 数据
     */
    public JsonResponse(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 返回状态码和数据
     *
     * @param code   状态码
     * @param result 数据
     */
    public JsonResponse(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }
}
