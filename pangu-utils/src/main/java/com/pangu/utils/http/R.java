package com.pangu.utils.http;

import com.pangu.utils.enums.ResponseEnum;

/**
 * 通用Response
 *
 * @author LZG
 * @date 2018/11/6
 */
public class R<T> {
    private String code;
    private String msg;
    private T data;

    public static R build(String statusCode, String msg, Object data) {
        return new R(statusCode, msg, data);
    }

    public static R build(String statusCode, String msg) {
        return new R(statusCode, msg, null);
    }

    public static R build(ResponseEnum responseEnum, Object data) {
        return new R(responseEnum.getCode(), responseEnum.getMsg(), data);
    }

    public static R build(ResponseEnum responseEnum) {
        return new R(responseEnum.getCode(), responseEnum.getMsg(), null);
    }

    //参数
    public static R build(ResponseEnum responseEnum, String param) {
        return new R(responseEnum.getCode(), param + responseEnum.getMsg(), null);
    }


    public static R ok(Object data) {
        return new R(data);
    }

    public static R ok() {
        return new R(null);
    }

    public R() {

    }

    public R(String statusCode, String msg, T data) {
        this.code = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public R(T data) {
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}