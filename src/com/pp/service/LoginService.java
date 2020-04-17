package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface LoginService {

	public boolean selectUser(String tel, String password);

	// 根据登录的帐号在UserInfo中查找对应的uid
	public ArrayList<UserInfo> selectUserInfoByTel(String tel);
	
	
	

	// 向已登录帐户信息表loggedInfo中插入数据
	public boolean insetLoggedInfo(int lid, int uid);
	
	//从已登录帐户信息表中loggedInfo查询数据，判断是否已经登录
	public ArrayList<LoggedInfo> selectLoggedInfo(int lid);
	//此方法还可以用来查询已登录用户的信息。
	

	//查询已登录用户的所有信息————多表联查
	public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid);	
	
	//退出登录，本质上就是删除已登录信息表中的数据
	public boolean deleteLoggedInfo(int lid);
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
