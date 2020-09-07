package com.hz.ssm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hz.ssm.dao.ProfileMapper;
import com.hz.ssm.pojo.Profile;
import com.hz.ssm.pojo.ProfileExample;
import com.hz.ssm.pojo.ProfileExample.Criteria;
import com.hz.ssm.utils.PageBean;



@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileMapper profilerMapper;
	
	@Override
	public PageBean<Profile> findProfileByPage(Integer indexpage,String career, String address) {
		//默认首页
		if(indexpage == null){
			indexpage=1;
		}
		if(career == null){
			career="";
		}
		career = "%"+career+"%";
		
		if(address == null){
			address="";
		}
		address = "%"+address+"%";
		
		//1、pageHelper参数初始化
		PageHelper.startPage(indexpage,4);
		ProfileExample example = new ProfileExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andCareerLike(career);
		criteria.andAddressLike(address);
		
		//2、去数据库获取当前页的数据
		List<Profile> profileList = profilerMapper.selectByExample(example);
	
		//3、把数据封装到封装分页数据的pageInfo对象中
		PageInfo<Profile> pageInfo = new PageInfo<Profile>(profileList);
		
		PageBean<Profile> pageBean = new PageBean<Profile>();
		pageBean.setIndexpage(indexpage);
		pageBean.setPageSize(pageInfo.getPageSize());
		pageBean.setCountRows(pageInfo.getTotal());
		
		pageBean.setDataList(profileList);
		
		return pageBean;
	}
	
	//根据id查询
	@Override
	public Profile findProfInfoById(Integer id) {
		Profile profile = profilerMapper.selectByPrimaryKey(id);
		return profile;
	}
	//修改
	public int editprofInfoById(Profile profile) {
		int rows =profilerMapper.updateByPrimaryKeySelective(profile);
		return rows;
	}


	
	
}
