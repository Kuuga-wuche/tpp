package com.pp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;
import com.pp.dao.ConnectFactory;
import com.pp.dao.LoggedInfoDao;

public class LoggedInfoDaoImpl implements LoggedInfoDao{
	//���ѵ�¼�ʻ���Ϣ��loggedInfo�в�������
	public boolean insetLoggedInfo(int lid, int uid){
		// TODO Auto-generated method stub
		Connection con=ConnectFactory.getConnection();
		String sql="insert loggedInfo(lid, uid) values("+lid+","+uid+")";
		Statement st=null;
		try {
			st=con.createStatement();
			int result=st.executeUpdate(sql);
			if (result<=0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		finally{
			try {
				if (st!=null) {
					st.close();	
				}
				if (con!=null) {
					con.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//���ѵ�¼�ʻ���Ϣ����loggedInfo��ѯ���ݣ��ж��Ƿ��Ѿ���¼
	//�˷���������������ѯ�ѵ�¼�û���uid��Ϣ��
	public ArrayList<LoggedInfo> selectLoggedInfo(int lid){
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from loggedInfo where lid = "+lid;

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);

			ArrayList<LoggedInfo> list = new ArrayList<LoggedInfo>();
			while (rs.next()) {
				LoggedInfo l = new LoggedInfo();
				l.setLid(rs.getInt("lid"));
				l.setUid(rs.getInt("uid"));
				
				list.add(l);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}	

//��ѯ�ѵ�¼�û���������Ϣ���������������
	public ArrayList<UserInfo> selectLoggedInfoAndUserInfo(int lid){
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from loggedInfo l left join userInfo u on"
				+ " l.uid=u.uid where lid = "+lid;

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);

			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo u = new UserInfo();
				
				u.setUid(rs.getInt("uid"));
				u.setTel(rs.getString("tel"));
				u.setUname(rs.getString("uname"));
				u.setPassword(rs.getString("password"));
				
				list.add(u);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	
	//�˳���¼�������Ͼ���ɾ���ѵ�¼��Ϣ���е�����
	public boolean deleteLoggedInfo(int lid){
		// TODO Auto-generated method stub
		Connection con=ConnectFactory.getConnection();
		String sql="delete from loggedInfo where lid = "+lid;
		Statement st=null;
		try {
			st=con.createStatement();
			int result=st.executeUpdate(sql);
			if (result<=0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		finally{
			try {
				if (st!=null) {
					st.close();	
				}
				if (con!=null) {
					con.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//�޸���Ϣ
	public boolean updateUserInfoByTel(String tel,String uname, String password){
		// TODO Auto-generated method stub
		Connection con=ConnectFactory.getConnection();
		String sql="update userInfo set uname='"+uname+"' , password='"+password+"' where tel = '"+tel+"'";
		Statement st=null;
		try {
			st=con.createStatement();
			int result=st.executeUpdate(sql);
			if (result<=0) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		finally{
			try {
				if (st!=null) {
					st.close();	
				}
				if (con!=null) {
					con.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
