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
		if (list==null || list.size()==0) {//��д��|| list.size()==0
			return false;
		}
		else {
			return true;
		}
	}
//���ݵ�¼���ʺ���UserInfo�в��Ҷ�Ӧ��uid
		public ArrayList<UserInfo> selectUserInfoByTel(String tel){
			UserInfoDao u = new UserInfoDaoImpl();
			ArrayList<UserInfo> list = u.selectUserInfoByTel(tel);
			return list;
			
		}

		
		
		//���ѵ�¼�ʻ���Ϣ����loggedInfo��������
		public boolean insetLoggedInfo(int lid, int uid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.insetLoggedInfo(lid, uid);
			return result;
		}
		
		
		//���ѵ�¼�ʻ���Ϣ����loggedInfo��ѯ���ݣ��ж��Ƿ��Ѿ���¼
		//�˷���������������ѯ�ѵ�¼�û�����Ϣ��
		public ArrayList<LoggedInfo> selectLoggedInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			ArrayList<LoggedInfo> list = l.selectLoggedInfo(lid);
			return list;			
		}
		

		//��ѯ�ѵ�¼�û���������Ϣ���������������
		public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			ArrayList<UserInfo> list = l.selectLoggedInfoAndUserInfo(lid);
			return list;
		}
		

		//�˳���¼�������Ͼ���ɾ���ѵ�¼��Ϣ���е�����
		public boolean deleteLoggedInfo(int lid){
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.deleteLoggedInfo(lid);
			return result;
		}
		

		
}
