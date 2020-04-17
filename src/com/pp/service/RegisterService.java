package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.UserInfo;

public interface RegisterService {
//注册，向UserInfo表中插入数据
	public boolean register(String uname,String tel,String password,String password1);
	
	//判断要注册手机号是否已经注册过。
		//查询UserInfo表里的所有电话号，
	public ArrayList<UserInfo> selectUserInfo();
}
