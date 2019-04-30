package com.onyx.mydemo.demo2.controller;

import com.onyx.mydemo.demo2.domain.Girl;
import com.onyx.mydemo.demo2.domain.Result;
import com.onyx.mydemo.demo2.repository.GirlRepository;
import com.onyx.mydemo.demo2.service.GirlService;
import com.onyx.mydemo.demo2.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zk on 2017/12/21.
 * 作用: com.example.onyx.
 */
@RestController
public class GirlsController {
    private static final Logger LOGGER= LoggerFactory.getLogger(GirlsController.class);

    @Autowired
    private GirlRepository girlRepository;


    @Autowired
    private GirlService girlService;
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
    /*@PostMapping("/girls")
    public String addGirls(@RequestParam("cupSize")String  cupSize,@RequestParam("age")int age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        Girl save = girlRepository.save(girl);
        return save.toString();
    }*/

    /**
     * 接受一个对象作为参数
     * 添加一个女生
     * 验证对象
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> addGirls(@Valid Girl girl, BindingResult bindingResult){
        //验证是否通过,不通过返回.
        if(bindingResult.hasErrors()){
            LOGGER.info(bindingResult.getFieldError().getDefaultMessage());
           // System.out.println(bindingResult.getFieldError().getDefaultMessage());
           // return "有错误发生了";
           // return null;
           // return bindingResult.getFieldError().getDefaultMessage();

            //返回同意的格式:
            //第一种.不够好
            Result<Girl> result = new Result<Girl>();
            result.setCode(1);
            result.setMsg("发生错误");
            result.setData(null);

            //第二种,更好
            //使用同意工具类,进行传参,减少冗余代码
            Result fail = ResultUtil.fail(1,"发生错误");
            return fail;
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        Girl save = girlRepository.save(girl);
        //return save.toString();

       /* Result<Girl> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(save);
        return result;*/

        Result success = ResultUtil.success(save);
        return success;
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


    /**
     * 对年纪进行判断,分别进行返回
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value="grils/getAge/{id}")
    public void getAge(@PathVariable("id") int id) throws Exception {
        girlService.getAge(id);
    }

}
