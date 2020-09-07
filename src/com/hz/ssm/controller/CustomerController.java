package com.hz.ssm.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hz.ssm.pojo.Profile;
import com.hz.ssm.service.ProfileService;
import com.hz.ssm.utils.PageBean;


@Controller
@RequestMapping("/cust/api/v_1/")
public class CustomerController {
	
	@Resource(name="profileService")
	private ProfileService profileService;

	// 小海: IPv4 地址:	192.168.43.68   你好

	
	//使用@ResponseBody注解可以完成后台数据转换为json格式返回,分页+搜索
	@ResponseBody
	@RequestMapping("/findProfileByPage")
	public PageBean<Profile> findProfileByPage(Integer indexpage,String career,String address){
		//System.out.println("i===================");
		PageBean<Profile> pageBean = profileService.findProfileByPage(indexpage, career, address);
	
		return pageBean;
	}
	
	//根据主键ID修改
	@RequestMapping("/findProfInfoById/{id}")
	public  String findProfInfoById(@PathVariable("id") Integer id,Model model){
		//System.out.println("custId==="+id);
		Profile profile = profileService.findProfInfoById(id);
		
		model.addAttribute("cust",profile);
		
		return "update";
	}
	
	/// 我叫hamapi
	public void str() {
		System.out.println("hhhhhhhhhh");
	}
	
	@RequestMapping("/editprofInfoById")
	public String editprofInfoById(MultipartFile picFile,Profile profile){
		//获取图片名称
		String fileName = picFile.getOriginalFilename();
		//StringUtils.isEmpty(fileName)  判断传过来的值是否温控
		//如果没选中修改图片
		if (StringUtils.isEmpty(fileName)) {
			
			int rows = profileService.editprofInfoById(profile);
		//如果不为空
		}else if(StringUtils.isNotBlank(fileName)){
			//给图片重命名0
			String newName = com.hz.ssm.utils.StringUtils.subStringName(fileName);
			
			profile.setPicimage(fileName);
			File file = new File("D:\\image\\"+newName);
			try {
				picFile.transferTo(file);
				
				int rows = profileService.editprofInfoById(profile);
				
				
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return "redirect:/list.jsp";
	}
	
	/*@RequestMapping("/editprofInfoById")
	public String editprofInfoById(MultipartFile picFile,Profile profile){
		String picName= picFile.getOriginalFilename();
		
		//防止图片保存到目标地址因图片名称一致而覆盖
	     String newPicName = StringUtils.subStringName(picName);
	     //把新的图片名保存到对象中
	     profile.setPicimage(newPicName);
		//指定图片上传的位置
	     File file = new File("D://picmage//"+newPicName); 
		//执行文件上传 pictureFile.transferTo(arg0);执行文件上传
	     try {
	    	 picFile.transferTo(file);
			
			int rows = profileService.editprofInfoById(profile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/list.jsp";
	}*/
	
}
