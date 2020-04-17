package com.pp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
	//连接数据库相关成员变量
		//驱动地址
		private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库地址
			//协议 IP地址 端口号 数据库名 
		private static final String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=PP";
		//用户名
		private static final String userName="sa";
		//用户密码
		private static final String password="1234";
		
		
	//连接数据库方法
		public static Connection getConnection(){
			//1,加载驱动
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2,获取连接
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
