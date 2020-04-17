package com.pp.dao;

import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;

public interface CinemaDao{
	//根据电影院名字查询
	public ArrayList<Cinema> selectCinemaDaolikeByCname(String cname);
	
	//点击table显示地址
	public ArrayList<Cinema> selectCinemaDaoByCname(String cname);
	
	//在出影院名时出影院中的影片  <根据想要的信息来写是那个bean类>
	public ArrayList<Movie>  selectMovieCinemaDaoByCname(String cname);
	
	//根据电影名查询信息
	public ArrayList<Movie>  selectMovieMinfoByMname(String mname);
	
	//根据电影名及电影院名查询票价及时间
	public ArrayList<PriceTimes> selectPriceTimesByCMname(String mname,String cname);
	
	
	//二，根据电影院名和电影名查询此场次的时间、价格
		public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname);
		
}
