package com.pp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
	//�������ݿ���س�Ա����
		//������ַ
		private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//���ݿ��ַ
			//Э�� IP��ַ �˿ں� ���ݿ��� 
		private static final String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=PP";
		//�û���
		private static final String userName="sa";
		//�û�����
		private static final String password="1234";
		
		
	//�������ݿⷽ��
		public static Connection getConnection(){
			//1,��������
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2,��ȡ����
			try {
				Connection con = DriverManager.getConnection(url,userName,password);
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		public static void main(String[] args) {
			ConnectFactory cf = new ConnectFactory();
			Connection con = cf.getConnection();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
