package com.onyx.mydemo.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public Object getStr(String key){
        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();

        return ops.get(key);
    }

    /**
     * 设置Str缓存
     * @param key
     * @param val
     */
    public void setStr(String key, String val){
        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
        ops.set(key,val);
    }


    /**
     * 删除指定key
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){
        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
        return ops.get(o);
    }

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2){
        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
        ops.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }

    /**
     * 获取所有的keys
     * @return
     */
    public Set<Object> getKeys(){
        Set<Object> keys = redisTemplate.keys("*");
        System.out.println(keys);
        return keys;
    }

}