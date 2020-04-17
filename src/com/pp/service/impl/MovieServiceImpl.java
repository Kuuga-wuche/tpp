package com.pp.service.impl;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.bean.Ticket;
import com.pp.bean.UserInfo;
import com.pp.dao.LoggedInfoDao;
import com.pp.dao.MovieDao;
import com.pp.dao.impl.LoggedInfoDaoImpl;
import com.pp.dao.impl.MovieDaoImpl;
import com.pp.service.LoginService;
import com.pp.service.MovieService;

public class MovieServiceImpl implements MovieService {
	// �����������������ĵ�Ӱ����ѯ��صĵ�Ӱ���ơ�������ģ����ѯ
	@Override
	public ArrayList<Movie> selectMovieLikeMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Movie> list = m.selectMovieLikeMname(mname);
		return list;
	}

	// ������table�ϵ���ĵ�Ӱ����ѯ��صĵ�Ӱ��Ϣ����������ȷ��ѯ
	@Override
	public ArrayList<Movie> selectMovieByMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Movie> list = m.selectMovieByMname(mname);
		return list;
	}

	@Override
	// �ػ�ѡ���ĵ���¼�
	// ����һ��panel����ʾ���������ݵ�Ӱ���ֲ�ѯ��ӰԺ�����顪������
	public ArrayList<Cinema> selectPriceTimesByMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Cinema> list = m.selectPriceTimesByMname(mname);
		return list;
	}

	@Override
	//���ݵ�ӰԺ����ѯ��ӰԺ��Ϣ	
	public ArrayList<Cinema> selectCinemaByCname(String cname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Cinema> list = m.selectCinemaByCname(cname);
		return list;
	}
	
	//111 		�������ݵ�ӰԺ���͵�Ӱ����ѯ�˳��ε�ʱ�䡢�۸�
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname){
		MovieDao m = new MovieDaoImpl();
		ArrayList<PriceTimes> list = m.selectPriceTimesByMnameAndCname(mname, cname);
		return list;
	}
	
	//��Ʊ�ɹ�����ticket���д������	//�������pid���ϸ���������,����		111
	public boolean insertTicket(int seat,int uid,int pid){
		MovieDao m = new MovieDaoImpl();
		boolean result = m.insertTicket(seat, uid, pid);
		return result;
	}
		
	
	//�����ѵ�¼�˺ŵ�loggedUid2��UserInfo�в���uname��tel
		public ArrayList<UserInfo> selectUserInfoByUid(int loggedUid2){
			MovieDao m = new  MovieDaoImpl();
			ArrayList<UserInfo> list = m.selectUserInfoByUid(loggedUid2);
			return list;
		}
		
		
		
		//���ѹ������λ��ɺ�ɫ
		//seatView:����pid��ѯ ticket ���seat
	public ArrayList<Ticket> selectTicketByPid (int pid){
		MovieDao m = new  MovieDaoImpl();
		ArrayList<Ticket> list = m.selectTicketByPid(pid);
		return list;
	}
	
	
	//�ҵģ��ѹ���ӰƱ��
	public ArrayList<String[]>  selectBoughtTicketInfoFromAll(int uid){
		MovieDao m = new  MovieDaoImpl();
		ArrayList<String[]> list = m.selectBoughtTicketInfoFromAll(uid);
		return list;
	}
	
	
	//�޸���Ϣ
	public boolean updateUserInfoByTel(String tel, String uname,String oldpassword, String newPassword1, String newPassword2){
		//1,�жϾ������Ƿ���ȷ
			//�Ȳ�ѯ������
		LoginService loginService = new LoginServiceImpl();
		ArrayList<UserInfo> list = loginService.selectUserInfoByTel(tel);
		UserInfo u = list.get(0);
	


		if (!oldpassword.equals(u.getPassword())) {
			System.out.println(oldpassword);
			System.out.println(u.getPassword());
			JOptionPane.showMessageDialog(null, "������ľ����벻��ȷ��");
			return false;
		}
		
			//2,�ж��������ȷ�������Ƿ���ͬ
			if(!newPassword1.equals(newPassword2)){
				JOptionPane.showMessageDialog(null, "�������ȷ������������벻��ͬ��");
				return false;
			}
			
			
			if (newPassword1.length()<8 || newPassword1.length()>16){
				JOptionPane.showMessageDialog(null, "���������8λС��16λ������");
				return false;
			}
			
	//3,��������洫����������û���߼����⣬�ٰ����ݴ������ݿ��н��и���
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.updateUserInfoByTel(tel, uname, newPassword1);
			return result;
		
			
		
	}
}
