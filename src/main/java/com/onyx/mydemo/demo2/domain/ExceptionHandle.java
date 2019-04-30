package com.onyx.mydemo.demo2.domain;

import com.onyx.mydemo.demo2.exception.GirlException;
import com.onyx.mydemo.demo2.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.domain.
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 异常的捕获
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException e2=(GirlException)e;
            return ResultUtil.fail(e2.getCode(),e2.getMessage());
        }
        LOGGER.error("[系统异常]{}:",e);
        return ResultUtil.fail(-1,"未知错误");
    }
}
