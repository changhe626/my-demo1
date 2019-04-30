package com.onyx.mydemo.demo2.exception;

import com.onyx.mydemo.demo2.enums.ResultEnum;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.exception.
 * spring 只对你抛出的RuntimeException进行实物回滚
 * 自定义异常类
 */
public class GirlException extends RuntimeException{

    private int code;

    /*public GirlException(String message, int code) {
        super(message);
        this.code = code;
    }*/

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
