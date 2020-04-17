package com.pp.service.impl;

import java.util.ArrayList;






import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;
import com.pp.dao.LoggedInfoDao;
import com.pp.dao.UserInfoDao;
import com.pp.dao.impl.LoggedInfoDaoImpl;
import com.pp.dao.impl.UserInfoDaoImpl;
import com.pp.service.LoginService;
import com.pp.service.RegisterService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean selectUser(String tel, String password) {
		// TODO Auto-generated method stub
		UserInfoDao dao= new UserInfoDaoImpl();
		ArrayList<UserInfo> list=dao.selcetByTelAndPass(tel, password);
		if (list==null || list.size()==0) {//少写了|| list.size()==0
			return false;
		}
		else {
			return true;
		}
	}
//根据登录的帐号在UserInfo中查找对应的uid
		public ArrayList<UserInfo> selectUserInfoByTel(String tel){
			UserInfoDao u = new UserInfoDaoImpl();
			ArrayList<UserInfo> list = u.selectUserInfoByTel(tel);
			return list;
			
		}

		
		
		//向已登录帐户信息表中loggedInfo插入数据
		public boolean insetLoggedInfo(int lid, int uid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.insetLoggedInfo(lid, uid);
			return result;
		}
		
		
		//从已登录帐户信息表中loggedInfo查询数据，判断是否已经登录
		//此方法还可以用来查询已登录用户的信息。
		public ArrayList<LoggedInfo> selectLoggedInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			ArrayList<LoggedInfo> list = l.selectLoggedInfo(lid);
			return list;			
		}
		

		//查询已登录用户的所有信息————多表联查
		public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			ArrayList<UserInfo> list = l.selectLoggedInfoAndUserInfo(lid);
			return list;
		}
		

		//退出登录，本质上就是删除已登录信息表中的数据
		public boolean deleteLoggedInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.deleteLoggedInfo(lid);
			return result;
		}
		

		
}
