package com.onyx.mydemo.demo2.utils;


import com.onyx.mydemo.demo2.domain.Result;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.utils.
 */
public class ResultUtil {

    /**
     * 成功的返回结果
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    //成功
    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    /**
     * 失败的返回结果
     * @return
     */
    public static Result fail(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
