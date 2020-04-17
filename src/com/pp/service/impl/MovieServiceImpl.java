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
	// 根据在输入框中输入的电影名查询相关的电影名称————模糊查询
	@Override
	public ArrayList<Movie> selectMovieLikeMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Movie> list = m.selectMovieLikeMname(mname);
		return list;
	}

	// 根据在table上点击的电影名查询相关的电影信息————精确查询
	@Override
	public ArrayList<Movie> selectMovieByMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Movie> list = m.selectMovieByMname(mname);
		return list;
	}

	@Override
	// 特惠选座的点击事件
	// 在下一个panel中显示：：：根据电影名字查询电影院及其简介————
	public ArrayList<Cinema> selectPriceTimesByMname(String mname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Cinema> list = m.selectPriceTimesByMname(mname);
		return list;
	}

	@Override
	//根据电影院名查询电影院信息	
	public ArrayList<Cinema> selectCinemaByCname(String cname) {
		MovieDao m = new MovieDaoImpl();
		ArrayList<Cinema> list = m.selectCinemaByCname(cname);
		return list;
	}
	
	//111 		二，根据电影院名和电影名查询此场次的时间、价格
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname){
		MovieDao m = new MovieDaoImpl();
		ArrayList<PriceTimes> list = m.selectPriceTimesByMnameAndCname(mname, cname);
		return list;
	}
	
	//购票成功，向ticket表中存放数据	//多表联查pid，上个方法中用,引用		111
	public boolean insertTicket(int seat,int uid,int pid){
		MovieDao m = new MovieDaoImpl();
		boolean result = m.insertTicket(seat, uid, pid);
		return result;
	}
		
	
	//根据已登录账号的loggedUid2在UserInfo中查其uname，tel
		public ArrayList<UserInfo> selectUserInfoByUid(int loggedUid2){
			MovieDao m = new  MovieDaoImpl();
			ArrayList<UserInfo> list = m.selectUserInfoByUid(loggedUid2);
			return list;
		}
		
		
		
		//把已购买的座位变成红色
		//seatView:根据pid查询 ticket 里的seat
	public ArrayList<Ticket> selectTicketByPid (int pid){
		MovieDao m = new  MovieDaoImpl();
		ArrayList<Ticket> list = m.selectTicketByPid(pid);
		return list;
	}
	
	
	//我的：已购电影票：
	public ArrayList<String[]>  selectBoughtTicketInfoFromAll(int uid){
		MovieDao m = new  MovieDaoImpl();
		ArrayList<String[]> list = m.selectBoughtTicketInfoFromAll(uid);
		return list;
	}
	
	
	//修改信息
	public boolean updateUserInfoByTel(String tel, String uname,String oldpassword, String newPassword1, String newPassword2){
		//1,判断旧密码是否正确
			//先查询旧密码
		LoginService loginService = new LoginServiceImpl();
		ArrayList<UserInfo> list = loginService.selectUserInfoByTel(tel);
		UserInfo u = list.get(0);
	


		if (!oldpassword.equals(u.getPassword())) {
			System.out.println(oldpassword);
			System.out.println(u.getPassword());
			JOptionPane.showMessageDialog(null, "您输入的旧密码不正确！");
			return false;
		}
		
			//2,判断新密码和确认密码是否相同
			if(!newPassword1.equals(newPassword2)){
				JOptionPane.showMessageDialog(null, "您输入的确认密码和新密码不相同！");
				return false;
			}
			
			
			if (newPassword1.length()<8 || newPassword1.length()>16){
				JOptionPane.showMessageDialog(null, "请输入大于8位小于16位的密码");
				return false;
			}
			
	//3,如果都界面传过来的数据没有逻辑问题，再把数据传到数据库中进行更新
			LoggedInfoDao l = new LoggedInfoDaoImpl();
			boolean result = l.updateUserInfoByTel(tel, uname, newPassword1);
			return result;
		
			
		
	}
}
