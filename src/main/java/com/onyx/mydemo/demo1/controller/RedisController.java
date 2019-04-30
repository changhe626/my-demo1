package com.onyx.mydemo.demo1.controller;

import com.onyx.mydemo.demo1.domain.Girl;
import com.onyx.mydemo.demo1.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by on 2017/3/1.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     * @return
     */
    @RequestMapping(value = "setStr")
    public String setStr(@RequestParam("key") String key, @RequestParam("val") String val) {
        redisService.setStr(key, val);
        Set<Object> keys = redisService.getKeys();
        return keys.toString();

    }

    /**
     * 根据key查询Str缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "getStr")
    public Object getStr(String key) {
        return redisService.getStr(key);
    }


    /**
     * 根据key产出Str缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "delStr")
    public String delStr(String key) {
        redisService.del(key);
        return "success";
    }


    /**
     * 设置obj缓存
     *
     * @param key
     * @param user
     * @return
     */
    @RequestMapping(value = "setObj")
    public String setObj(String key, Girl user) {
        redisService.setObj(key, user);
        Set<Object> keys = redisService.getKeys();
        return keys.toString();
    }

    /**
     * 获取obj缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "getObj")
    public Object getObj(String key) {
        return redisService.getObj(key);
    }


    /**
     * 删除obj缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "delObj")
    public Object delObj(String key) {

        redisService.delObj(key);
        return "success";

    }

}