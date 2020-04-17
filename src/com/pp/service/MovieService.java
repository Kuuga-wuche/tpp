package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.bean.Ticket;
import com.pp.bean.UserInfo;

public interface MovieService {
	//�����������������ĵ�Ӱ����ѯ��صĵ�Ӱ���ơ�������ģ����ѯ
		public ArrayList<Movie> selectMovieLikeMname(String mname); 
		
		//������table�ϵ���ĵ�Ӱ����ѯ��صĵ�Ӱ��Ϣ����������ȷ��ѯ
		public ArrayList<Movie> selectMovieByMname(String mname);
		
		//�ػ�ѡ���ĵ���¼�	
				//����һ��panel����ʾ���������ݵ�Ӱ���ֲ�ѯ��ӰԺ�����顪������
		public ArrayList<Cinema> selectPriceTimesByMname(String mname);
		
	//���ݵ�ӰԺ����ѯ��ӰԺ��Ϣ	
	public ArrayList<Cinema> selectCinemaByCname(String cname);
		
		////		111		�������ݵ�ӰԺ���͵�Ӱ����ѯ�˳��ε�ʱ�䡢�۸�
		public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname);
		
		//��Ʊ�ɹ�����ticket���д������
		public boolean insertTicket(int seat,int uid,int pid);		
		//�������pid���ϸ���������,����		111
		
		//�����ѵ�¼�˺ŵ�loggedUid2��UserInfo�в���uname��tel
		public ArrayList<UserInfo> selectUserInfoByUid(int loggedUid2);

		
		
		
		
		//���ѹ������λ��ɺ�ɫ
		//seatView:����pid��ѯ ticket ���seat
	public ArrayList<Ticket> selectTicketByPid (int pid);
	
	
	//�ҵģ��ѹ���ӰƱ��
	public ArrayList<String[]>  selectBoughtTicketInfoFromAll(int uid);
	
	//�޸���Ϣ
	
	public boolean updateUserInfoByTel(String tel, String uname,  String oldpassword, String newPassword1, String newPassword2);
		

}