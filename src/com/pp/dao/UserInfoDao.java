package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface UserInfoDao {
//	注册方法
	public boolean insertUserInfo(String uname,String tel,String password);
//	登录的方法
	public ArrayList<UserInfo> selcetByTelAndPass(String tel,String password);
	
	//根据登录的帐号在UserInfo中查找对应的uid
	public ArrayList<UserInfo> selectUserInfoByTel(String tel);
	
	
	//判断要注册手机号是否已经注册过。
			//查询UserInfo表里的所有电话号，
	public ArrayList<UserInfo> selectUserInfo();
	
}
