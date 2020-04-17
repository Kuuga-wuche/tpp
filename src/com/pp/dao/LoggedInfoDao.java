package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;

public interface LoggedInfoDao {

	//���ѵ�¼�ʻ���Ϣ����loggedInfo��������
	public boolean insetLoggedInfo(int lid, int uid);
	
	//���ѵ�¼�ʻ���Ϣ����loggedInfo��ѯ���ݣ��ж��Ƿ��Ѿ���¼
	//�˷���������������ѯ�ѵ�¼�û���uid��Ϣ��
	public ArrayList<LoggedInfo> selectLoggedInfo(int lid);
	
	
	
	//��ѯ�ѵ�¼�û���������Ϣ���������������
	public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid);
	
	
	//�˳���¼�������Ͼ���ɾ���ѵ�¼��Ϣ���е�����
	public boolean deleteLoggedInfo(int lid);
	
	
	
	//�޸���Ϣ
	public boolean updateUserInfoByTel(String tel, String uname, String password);
	
	
	
	
	
	
	
	
}
