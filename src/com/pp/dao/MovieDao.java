package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.bean.Ticket;
import com.pp.bean.UserInfo;

public interface MovieDao {
	//根据在输入框中输入的电影名查询相关的电影名称————模糊查询
	public ArrayList<Movie> selectMovieLikeMname(String mname); 
	
	//根据在table上点击的电影名查询相关的电影信息————精确查询
	public ArrayList<Movie> selectMovieByMname(String mname);
	
	
	//特惠选座的点击事件	
		//根据电影名字查询电影院及其简介————
	public ArrayList<Cinema> selectPriceTimesByMname(String mname);
	
	//根据电影院名查询电影院信息	
	public ArrayList<Cinema> selectCinemaByCname(String cname);
	
	//二，根据电影院名和电影名查询此场次的时间、价格
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname);
	
	//购票成功，向ticket表中存放数据
	public boolean insertTicket(int seat,int uid,int pid);
	
	
	//根据已登录账号的loggedUid2在UserInfo中查其uname，tel
		public ArrayList<UserInfo> selectUserInfoByUid(int loggedUid2);
		
		
		
		
	//把已购买的座位变成红色
		//seatView:根据pid查询 ticket 里的seat
	public ArrayList<Ticket> selectTicketByPid (int pid);
	
	
	//我的：已购电影票：
	public ArrayList<String[]>  selectBoughtTicketInfoFromAll(int uid);
	
}
