package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.UserInfo;

public interface RegisterService {
//ע�ᣬ��UserInfo���в�������
	public boolean register(String uname,String tel,String password,String password1);
	
	//�ж�Ҫע���ֻ����Ƿ��Ѿ�ע�����
		//��ѯUserInfo��������е绰�ţ�
	public ArrayList<UserInfo> selectUserInfo();
}
