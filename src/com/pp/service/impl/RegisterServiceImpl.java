package com.pp.service.impl;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pp.bean.UserInfo;
import com.pp.dao.UserInfoDao;
import com.pp.dao.impl.UserInfoDaoImpl;
import com.pp.service.RegisterService;


public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean register(String uname, String tel, String password,String password1) {
		// TODO Auto-generated method stub
		if (uname.length()>8) {
			JOptionPane.showMessageDialog(null, "请输入小于8位的昵称");
			return false;			
		}
		if (tel.length()!=11) {
			JOptionPane.showMessageDialog(null, "请输入11位的电话号码");
			return false;
		}
		/*if((int)tel.charAt(0) != 1){
			System.out.println((int)tel.charAt(0));
			JOptionPane.showMessageDialog(null, "手机号码首位应该为1");
			return false;
		}*/
		//逻辑上不需要这个判断，但如何判断一个字符串的首字母是不是某个数？（把char强转成int不行！！！）
		
		
		
		
//判断tel是否已经注册过		
		RegisterService registerService  =new RegisterServiceImpl();
		ArrayList<UserInfo> userInfoList = registerService.selectUserInfo();//这个方法在下面。
		//String 类型的数组，存放tel
		ArrayList<String []> tel_list = new ArrayList<String []>();
		for(int i=0; i<userInfoList.size(); i++){
			UserInfo u = new UserInfo();
		
			//判断tel是否已经注册过
			if (tel ==u.getTel()){
				JOptionPane.showMessageDialog(null, "这个手机号已经被注册过了");
				return false;
			} 
		}
		
		
		if (password.length()>16 || password.length()<8){
			JOptionPane.showMessageDialog(null, "请输入大于8位小于16位的密码");
			return false;
		}
		
		if(!password.equals(password1)){
			JOptionPane.showMessageDialog(null, "您输入的确认密码和密码不相同");
			return false;
		}
		
		
		
		UserInfoDao dao=new UserInfoDaoImpl();
		boolean result=dao.insertUserInfo(uname, tel, password);
		if (result==true) {
			return true;
		}
		else {
			return false;
		}
	}

	
	//判断要注册手机号是否已经注册过。
			//查询UserInfo表里的所有电话号，
	public ArrayList<UserInfo> selectUserInfo(){
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		ArrayList<UserInfo> list = userInfoDao.selectUserInfo();
		return list;
	}
}
