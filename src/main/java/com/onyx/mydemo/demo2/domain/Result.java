package com.onyx.mydemo.demo2.domain;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.domain.
 * http返回结果最外层的对象
 */
public class Result<T> {

    private int code;
    private String msg;
    //具体内容用泛型
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
