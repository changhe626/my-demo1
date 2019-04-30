package com.onyx.mydemo.demo1.controller;


import com.onyx.mydemo.demo1.properties.OnyxProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zk on 2017/12/20.
 * 作用: com.example.onyx.
 */
@RestController
public class Hello {

    //获取配置文件的内容,如果没有话,就注释了,不然报错
  /*  @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;*/


    // 要加上@Component  这个注解才能注入
    @Autowired
    private OnyxProperties onyxProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
     /*   System.out.println(cupSize);
        System.out.println(age);
        System.out.println(content);*/
        //return "hello onyx,i love you very much";
        //return cupSize;
        //return content;
        System.out.println(onyxProperties);
        return onyxProperties.toString();
    }
}
