package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface UserInfoDao {
//	ע�᷽��
	public boolean insertUserInfo(String uname,String tel,String password);
//	��¼�ķ���
	public ArrayList<UserInfo> selcetByTelAndPass(String tel,String password);
	
	//���ݵ�¼���ʺ���UserInfo�в��Ҷ�Ӧ��uid
	public ArrayList<UserInfo> selectUserInfoByTel(String tel);
	
	
	//�ж�Ҫע���ֻ����Ƿ��Ѿ�ע�����
			//��ѯUserInfo��������е绰�ţ�
	public ArrayList<UserInfo> selectUserInfo();
	
}
