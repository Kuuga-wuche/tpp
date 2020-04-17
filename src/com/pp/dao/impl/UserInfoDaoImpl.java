package com.pp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pp.bean.LoggedInfo;
import com.pp.bean.Movie;
import com.pp.bean.UserInfo;
import com.pp.dao.ConnectFactory;
import com.pp.dao.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao{

	public boolean insertUserInfo(String uname, String tel, String password) {
		// TODO Auto-generated method stub
		Connection con=ConnectFactory.getConnection();
		String sql="insert into userInfo(uname,tel,password)values('"+uname+"','"+tel+"','"+password+"')";
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

	@Override
	public ArrayList<UserInfo> selcetByTelAndPass(String tel, String password) {
		// TODO Auto-generated method stub
		Connection con=ConnectFactory.getConnection();
		if (con==null) {
			return null;
		}
		String sql="select * from userInfo where tel='"+tel+"' and password='"+password+"'";
		Statement st=null;
		ResultSet result=null;
		try {
			st=con.createStatement();
			result=st.executeQuery(sql);
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			while(result.next()){
			UserInfo u = new UserInfo();
			u.setUid(result.getInt("uid"));
			u.setUname(result.getString("uname"));
			u.setTel(result.getString("tel"));
			u.setPassword(result.getString("password"));
			list.add(u);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				if (result!=null) {
					result.close();	
				}
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
	
	//根据登录的帐号tel在UserInfo中查找对应的uid
		public ArrayList<UserInfo> selectUserInfoByTel(String tel){
			Connection con = ConnectFactory.getConnection();

			String sql = "select * from userInfo where tel = '"+tel+"'";

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

			
		//判断要注册手机号是否已经注册过。
				//查询UserInfo表里的所有电话号，
		public ArrayList<UserInfo> selectUserInfo(){
			Connection con = ConnectFactory.getConnection();

			String sql = "select * from userInfo ";

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
}
