package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface LoginService {

	public boolean selectUser(String tel, String password);

	// ���ݵ�¼���ʺ���UserInfo�в��Ҷ�Ӧ��uid
	public ArrayList<UserInfo> selectUserInfoByTel(String tel);
	
	
	

	// ���ѵ�¼�ʻ���Ϣ��loggedInfo�в�������
	public boolean insetLoggedInfo(int lid, int uid);
	
	//���ѵ�¼�ʻ���Ϣ����loggedInfo��ѯ���ݣ��ж��Ƿ��Ѿ���¼
	public ArrayList<LoggedInfo> selectLoggedInfo(int lid);
	//�˷���������������ѯ�ѵ�¼�û�����Ϣ��
	

	//��ѯ�ѵ�¼�û���������Ϣ���������������
	public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid);	
	
	//�˳���¼�������Ͼ���ɾ���ѵ�¼��Ϣ���е�����
	public boolean deleteLoggedInfo(int lid);
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
