package com.onyx.mydemo.demo1.controller;


import com.onyx.mydemo.demo1.domain.Girl;
import com.onyx.mydemo.demo1.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zk on 2017/12/21.
 * 作用: com.example.onyx.
 */
@RestController
public class GirlsController {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlsList(){
        List<Girl> girls = girlRepository.findAll();
        return girls;
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping("/girls")
    public String addGirls(@RequestParam("cupSize")String  cupSize,@RequestParam("age")int age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        Girl save = girlRepository.save(girl);
        return save.toString();
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl getOne(@PathVariable("id")int id){
        //Girl one = girlRepository.getOne(id);
        Girl one = girlRepository.findOne(id);
        return one;
    }

    /**
     * 更新一个
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable("id")int id,@RequestParam("age")int age,@RequestParam("cupSize")String cupSize){
        Girl girl = girlRepository.getOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRepository.save(girl);
        return save;
        //也可以直接new 一个Girl,然后设置值,进行直接保存
    }

    /**
     * 删除一个
     * @param id
     */
    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@PathVariable("id")int id){
        girlRepository.delete(id);
    }


    /**
     * 年纪查询列表
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> queryByAge(@PathVariable("age")int age){
        List<Girl> girls = girlRepository.findByAge(age);
        return girls;
    }

}
