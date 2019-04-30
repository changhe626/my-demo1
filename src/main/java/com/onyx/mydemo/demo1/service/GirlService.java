package com.onyx.mydemo.demo1.service;

import com.onyx.mydemo.demo1.domain.Girl;
import com.onyx.mydemo.demo1.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService{

	@Autowired
    private GirlRepository girlRepository;
	
	@Transactional  //事务
	public void insertTwo(){
		Girl g1=new Girl();
		Girl g2=new Girl();
		//同时成功或者失败
		girlRepository.save(g1);
		int i=1/0;
		girlRepository.save(g2);
	}
}