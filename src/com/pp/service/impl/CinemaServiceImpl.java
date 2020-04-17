package com.pp.service.impl;

import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.dao.CinemaDao;
import com.pp.dao.impl.CinemaDaoImpl;
import com.pp.service.CinemaService;

public class CinemaServiceImpl implements CinemaService {

	@Override
	public ArrayList<Cinema> selectCinemaServicelikeByCname(String cname) {
		// TODO Auto-generated method stub
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<Cinema> list=dao.selectCinemaDaolikeByCname(cname);
		return list;
		
	}

	@Override
	public ArrayList<Cinema> selectCinemaServiceByaddr(String cname) {
		// TODO Auto-generated method stub
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<Cinema> list=dao.selectCinemaDaoByCname(cname);
		return list;
	}

	public ArrayList<Movie> selectMovieCinemaDaoByCname(String cname) {
		// TODO Auto-generated method stub
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<Movie> list=dao.selectMovieCinemaDaoByCname(cname);
		
		return list;
	}

	@Override
	public ArrayList<Movie> selectMovieMinfoByMname(String mname) {
		// TODO Auto-generated method stub
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<Movie> list=dao.selectMovieMinfoByMname(mname);
		
		return list;
	}

	@Override
	public ArrayList<PriceTimes> selectPriceTimesByCMname(String mname,
			String cname) {
		// TODO Auto-generated method stub
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<PriceTimes> list=dao.selectPriceTimesByCMname(mname, cname);
		return list;
	}

	
	//二，根据电影院名和电影名查询此场次的时间、价格
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname){
		CinemaDao dao=new CinemaDaoImpl();
		ArrayList<PriceTimes> list=dao.selectPriceTimesByMnameAndCname(mname, cname);
		return list;
	}
}
