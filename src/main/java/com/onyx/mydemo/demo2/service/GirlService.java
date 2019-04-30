package com.onyx.mydemo.demo2.service;



import com.onyx.mydemo.demo2.domain.Girl;
import com.onyx.mydemo.demo2.enums.ResultEnum;
import com.onyx.mydemo.demo2.exception.GirlException;
import com.onyx.mydemo.demo2.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
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

	/**
	 * 获取年纪,进行判断,返回不同的状态码和异常信息
	 * @param id
	 */
	public void getAge(int id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		int age = girl.getAge();
		if(age<10){
			//使用枚举,这样能够更好地封装数据
			//throw new Exception("还在上小学");
			//throw new GirlException("还在上小学",100);
			//传递枚举,还是需要进行自定义异常的构造方法的修改的
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age>9 && age<16){
			//throw new Exception("还在上中学");
			//throw new GirlException("还在上中学",200);
			throw new GirlException(ResultEnum.MIDEL_SCHOOL);
		}else {
			//throw new Exception("大姑娘了哦");
			//throw new GirlException("大姑娘了哦",300);
			throw new GirlException(ResultEnum.LADY);
		}
	}


	/**
	 * 进行单元测试的方法
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id){
		return girlRepository.findOne(id);

	}

}