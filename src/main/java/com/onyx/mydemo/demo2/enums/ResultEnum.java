package com.onyx.mydemo.demo2.enums;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.enums.
 */
public enum ResultEnum {
    UNKONOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"上小学"),
    MIDEL_SCHOOL(200,"上中学"),
    LADY(300,"大姑娘了")
    ;


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
