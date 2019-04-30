package com.onyx.mydemo.demo2.repository;

import com.onyx.mydemo.demo2.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zk on 2017/12/21.
 * 作用: com.example.onyx.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{


    //通过年纪查询
    public List<Girl> findByAge(int age);
}
