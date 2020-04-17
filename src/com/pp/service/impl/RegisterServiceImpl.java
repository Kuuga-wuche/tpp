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
			JOptionPane.showMessageDialog(null, "������С��8λ���ǳ�");
			return false;			
		}
		if (tel.length()!=11) {
			JOptionPane.showMessageDialog(null, "������11λ�ĵ绰����");
			return false;
		}
		/*if((int)tel.charAt(0) != 1){
			System.out.println((int)tel.charAt(0));
			JOptionPane.showMessageDialog(null, "�ֻ�������λӦ��Ϊ1");
			return false;
		}*/
		//�߼��ϲ���Ҫ����жϣ�������ж�һ���ַ���������ĸ�ǲ���ĳ����������charǿת��int���У�������
		
		
		
		
//�ж�tel�Ƿ��Ѿ�ע���		
		RegisterService registerService  =new RegisterServiceImpl();
		ArrayList<UserInfo> userInfoList = registerService.selectUserInfo();//������������档
		//String ���͵����飬���tel
		ArrayList<String []> tel_list = new ArrayList<String []>();
		for(int i=0; i<userInfoList.size(); i++){
			UserInfo u = new UserInfo();
		
			//�ж�tel�Ƿ��Ѿ�ע���
			if (tel ==u.getTel()){
				JOptionPane.showMessageDialog(null, "����ֻ����Ѿ���ע�����");
				return false;
			} 
		}
		
		
		if (password.length()>16 || password.length()<8){
			JOptionPane.showMessageDialog(null, "���������8λС��16λ������");
			return false;
		}
		
		if(!password.equals(password1)){
			JOptionPane.showMessageDialog(null, "�������ȷ����������벻��ͬ");
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

	
	//�ж�Ҫע���ֻ����Ƿ��Ѿ�ע�����
			//��ѯUserInfo��������е绰�ţ�
	public ArrayList<UserInfo> selectUserInfo(){
		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		ArrayList<UserInfo> list = userInfoDao.selectUserInfo();
		return list;
	}
}
