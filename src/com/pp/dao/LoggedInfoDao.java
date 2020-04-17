package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface LoggedInfoDao {

	//向已登录帐户信息表中loggedInfo插入数据
	public boolean insetLoggedInfo(int lid, int uid);
	
	//从已登录帐户信息表中loggedInfo查询数据，判断是否已经登录
	//此方法还可以用来查询已登录用户的uid信息。
	public ArrayList<LoggedInfo> selectLoggedInfo(int lid);
	
	
	
	//查询已登录用户的所有信息————多表联查
	public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid);
	
	
	//退出登录，本质上就是删除已登录信息表中的数据
	public boolean deleteLoggedInfo(int lid);
	
	
	
	//修改信息
	public boolean updateUserInfoByTel(String tel, String uname, String password);
	
	
	
	
	
	
	
	
}
