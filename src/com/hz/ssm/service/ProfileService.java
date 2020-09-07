package com.hz.ssm.service;

import com.hz.ssm.pojo.Profile;
import com.hz.ssm.utils.PageBean;

public interface ProfileService {
	
	//分页查询
	//indexpage 当前页码
	PageBean<Profile> findProfileByPage(Integer indexpage, String career, String address);

	//根据id查询
	Profile findProfInfoById(Integer id);
	
	//编辑客户信息的方法
	int editprofInfoById(Profile profile);


	
	
}
