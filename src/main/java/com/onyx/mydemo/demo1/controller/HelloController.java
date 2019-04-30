package com.onyx.mydemo.demo1.controller;

import com.onyx.mydemo.demo1.properties.OnyxProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zk on 2017/12/20.
 * 作用: com.example.onyx.
 */
@Controller
@RequestMapping(value = "/h")  //整个方法的
public class HelloController {

    @Autowired
    private OnyxProperties onyxProperties;

    //配置多个url
    @RequestMapping(value = {"/hello2","/hello3"},method = RequestMethod.GET)
    public String hello(){
        System.out.println(onyxProperties);
        return "index";  //到index.html
    }
}
