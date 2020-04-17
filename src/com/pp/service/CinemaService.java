package com.pp.service;

import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;

public interface CinemaService {
	   public ArrayList<Cinema> selectCinemaServicelikeByCname (String cname);

	    //���table��ʾ��ַ
	    public ArrayList<Cinema> selectCinemaServiceByaddr(String cname);
	
	    //�ٳ�ӰԺ��ʱ��ӰԺ�е�ӰƬ  <������Ҫ����Ϣ��д���Ǹ�bean��>
		public ArrayList<Movie>  selectMovieCinemaDaoByCname(String mname);
		
		//���ݵ�Ӱ����ѯ��Ϣ
		public ArrayList<Movie>  selectMovieMinfoByMname(String mname);
		
		//���ݵ�Ӱ������ӰԺ����ѯƱ�ۼ�ʱ��
		public ArrayList<PriceTimes> selectPriceTimesByCMname(String mname,String cname);
		
		//�������ݵ�ӰԺ���͵�Ӱ����ѯ�˳��ε�ʱ�䡢�۸�
		public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname);
}
