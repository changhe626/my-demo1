package com.onyx.mydemo.demo1.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by zk on 2017/12/20.
 * 作用: com.example.onyx.
 */
@RestController
public class HelloController3 {

    //请求参数的获取,还可以写成/{id}/hello4
    @RequestMapping(value = "/hello4/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable("id") Integer id){
        return id+"";
    }

    //id 和url上是一样的
    //设置默认值,为0,只能是字符0,"0",非必须的
    //@RequestMapping(value = "/hello5",method = RequestMethod.GET)
    @GetMapping(value = "/hello5")  //和上面一样的,还有PostMapping 就是Post
    public String hello2(@RequestParam(value = "id",required = false,defaultValue = "0") int myId){
        System.out.println(myId);
        return "id:"+myId;
    }
}
