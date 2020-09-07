package com.hz.ssm.pojo;

import java.util.Date;

public class Profile {
    private Integer id;//人员编号

    private String name;//姓名

    private Date birthday;//生日

    private String gender;//性别

    private String career;//职业

    private String address;//住所

    private String picimage;//图像

    private String mobile;//手机号
    
    @Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", career=" + career
				+ ", address=" + address + ", picimage=" + picimage
				+ ", mobile=" + mobile + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPicimage() {
        return picimage;
    }

    public void setPicimage(String picimage) {
        this.picimage = picimage == null ? null : picimage.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    
}