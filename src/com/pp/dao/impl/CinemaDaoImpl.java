package com.pp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.dao.CinemaDao;
import com.pp.dao.ConnectFactory;

public class CinemaDaoImpl implements CinemaDao {
	//���ݵ�ӰԺ���ֲ�ѯ
	@Override
	public ArrayList<Cinema> selectCinemaDaolikeByCname(String cname) {

		Connection con = ConnectFactory.getConnection();
		if (con == null) {
			return null;
		}

		// ƴдSQL��
		String sql = "select *from cinema where cname like '%" + cname + "%'";

		// ��ȡstatement����
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			// ִ��SQL��
			rs = st.executeQuery(sql);
			ArrayList<Cinema> list = new ArrayList<Cinema>();
			/* rs.getString("cname"); */
			while (rs.next()) {
				Cinema cinema = new Cinema();
				cinema.setCname(rs.getString("cname"));
				list.add(cinema);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// �ر����ݿ�
		finally {
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
				System.out.println("�ر�ʧ��");
			}

		}

	}
/*public static void main(String[] args) {
	CinemaDaoImpl v=new CinemaDaoImpl();
	ArrayList<Cinema> list=v.selectCinemaDaolikebycname("1");
	for(Cinema a:list){
		System.out.println(a.getCname());
	}
	
}*/

	@Override
	public ArrayList<Cinema> selectCinemaDaoByCname(String cname) {
		Connection con = ConnectFactory.getConnection();
		if (con == null) {
			return null;
		}

		// ƴдSQL��
		String sql = "select*from cinema where cname='"
				+ cname
				+ "'";

		// ��ȡstatement����
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			// ִ��SQL��
			rs = st.executeQuery(sql);
			ArrayList<Cinema> list = new ArrayList<Cinema>();
			/* rs.getString("cname"); */
			while (rs.next()) {
				Cinema cinema = new Cinema();
				cinema.setCname(rs.getString("cname"));
				cinema.setAddr(rs.getString("addr"));
				list.add(cinema);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// �ر����ݿ�
		finally {
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
				System.out.println("�ر�ʧ��");
			}

		}

	}

	@Override
	public ArrayList<Movie> selectMovieCinemaDaoByCname(String cname) {
		Connection con = ConnectFactory.getConnection();
		if (con == null) {
			return null;
		}

		// ƴдSQL��
		String sql = "select*from cinema c "
					+"left join priceTimes p "
					+"on c.cid=p.cid "
					+"left join movie m "
					+"on m.mid=p.mid "
					+"where c.cname='"
					+ cname
					+ "' ";
/*System.out.println(sql);
*/		// ��ȡstatement����
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			// ִ��SQL��
			rs = st.executeQuery(sql);
			ArrayList<Movie> list = new ArrayList<Movie>();
			/* rs.getString("cname"); */
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMname(rs.getString("mname"));
				movie.setMinfo(rs.getString("minfo"));
				
				list.add(movie);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// �ر����ݿ�
		finally {
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
				System.out.println("�ر�ʧ��");
			}

		}

	}

	@Override
	public ArrayList<Movie> selectMovieMinfoByMname(String mname) {
		// TODO Auto-generated method stub
		Connection con = ConnectFactory.getConnection();
		if (con == null) {
			return null;
		}

		// ƴдSQL��
		String sql = "select*from movie where mname='"
				+ mname
				+ "'";
/*			System.out.println(sql);
*/		// ��ȡstatement����
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			// ִ��SQL��
			rs = st.executeQuery(sql);
			ArrayList<Movie> list = new ArrayList<Movie>();
			/* rs.getString("cname"); */
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMname(rs.getString("mname"));
				movie.setMinfo(rs.getString("minfo"));
				
				list.add(movie);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// �ر����ݿ�
		finally {
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
				System.out.println("�ر�ʧ��");
			}

		}

	}

	@Override
	public ArrayList<PriceTimes> selectPriceTimesByCMname(String mname,String cname) {
		// TODO Auto-generated method stub
				Connection con = ConnectFactory.getConnection();
				if (con == null) {
					return null;
				}

				// ƴдSQL��
				String sql = "select*from cinema c "
								+"left join priceTimes p "
								+"on c.cid=p.cid " 
								+"left join movie m "
								+"on m.mid=p.mid "
								+"where c.cname='"
								+ cname
								+ "'and m.mname='"
								+ mname
								+ "'";
					/*System.out.println(sql);*/
				// ��ȡstatement����
				Statement st = null;
				ResultSet rs = null;
				try {
					st = con.createStatement();
					// ִ��SQL��
					rs = st.executeQuery(sql);
					ArrayList<PriceTimes> list = new ArrayList<PriceTimes>();
					/* rs.getString("cname"); */
					while (rs.next()) {
						PriceTimes pt=new PriceTimes();
						pt.setPrice(rs.getDouble("price"));
						pt.setPtime(rs.getString("ptime"));
						
						list.add(pt);
					}
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;

				}

				// �ر����ݿ�
				finally {
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
						System.out.println("�ر�ʧ��");
					}

				}
	}
	
	//�������ݵ�ӰԺ���͵�Ӱ����ѯ�˳��ε�ʱ�䡢�۸�
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname (String mname,String cname){
		Connection con = ConnectFactory.getConnection();

		String sql = "select *  from movie m left join priceTimes pt on "
				+ "m.mid=pt.mid left join cinema c on "
				+ "pt.cid=c.cid where mname='"+mname+"' and cname='"+cname+"'"; 
		

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);
			

			ArrayList<PriceTimes> list = new ArrayList<PriceTimes>();
			while (rs.next()) {
				PriceTimes pt = new PriceTimes();
				
				pt.setCid(rs.getInt("cid"));
				pt.setMid(rs.getInt("mid"));
				pt.setPid(rs.getInt("pid"));
				pt.setPrice(rs.getDouble("price"));
				pt.setPtime(rs.getString("ptime"));
				
				list.add(pt);
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

	
	













