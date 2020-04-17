package com.pp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.bean.Ticket;
import com.pp.bean.UserInfo;
import com.pp.dao.ConnectFactory;
import com.pp.dao.MovieDao;



public class MovieDaoImpl implements MovieDao{

	@Override
	public ArrayList<Movie> selectMovieLikeMname(String mname) {
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from movie where mname like '%"+mname+"%'";

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);

			ArrayList<Movie> list = new ArrayList<Movie>();
			while (rs.next()) {
				Movie m = new Movie();
				
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMinfo(rs.getString("minfo"));
				
				list.add(m);
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
	

	@Override
	public ArrayList<Movie> selectMovieByMname(String mname) {
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from movie where mname = '"+mname+"'";

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);

			ArrayList<Movie> list = new ArrayList<Movie>();
			while (rs.next()) {
				Movie m = new Movie();
				
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMinfo(rs.getString("minfo"));
				
				list.add(m);
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


	@Override
	public ArrayList<Cinema> selectPriceTimesByMname(String mname) {
		Connection con = ConnectFactory.getConnection();

		String sql = "select *  from movie m left join priceTimes pt on "
				+ "m.mid=pt.mid left join cinema c on "
				+ "pt.cid=c.cid where mname='"+mname+"'"; 
		

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);
			

			ArrayList<Cinema> list = new ArrayList<Cinema>();
			while (rs.next()) {
				Cinema c = new Cinema();
				
				c.setCid(rs.getInt("cid"));//没报错。。。。。。。。。。。。。。。
				c.setAddr(rs.getString("addr"));
				c.setCname(rs.getString("cname"));
				
				list.add(c);
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

	//根据电影院名查询电影院信息，	
	@Override
	public ArrayList<Cinema> selectCinemaByCname(String cname) {
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from cinema where cname = '"+cname+"'";

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);

			ArrayList<Cinema> list = new ArrayList<Cinema>();
			while (rs.next()) {
				Cinema c = new Cinema();
				
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setAddr(rs.getString("addr"));
				
				list.add(c);
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


	@Override
	//二，根据电影院名和电影名查询此场次的时间、价格
	public ArrayList<PriceTimes> selectPriceTimesByMnameAndCname(String mname,
			String cname) {
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
	
	//购票成功，向ticket表中存放数据
	public boolean insertTicket(int seat,int uid,int pid){
		// 1,通过连接工厂连接数据库
		Connection con = ConnectFactory.getConnection();
		// 2,写SQL文
		String sql = "insert into ticket(seat,uid,pid) values("+seat+","+uid+","+pid+")";
		// 3,通过Connection获取Statement对象用以执行SQL文
		Statement st = null;
		try {
			st = con.createStatement();
/*System.out.println("ceshi "+uid);*/
			// 4，执行SQL文
			int result = st.executeUpdate(sql);
			// 5,判断
			if (result < 1) {
				/*System.out.println("向数据库中添加数据失败");*/
				return false;
			} else {
				/*System.out.println("向数据库中添加数据成功");*/
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}// 6，关闭Statement，Connection
		finally {

			try {
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
	
	
	//根据已登录账号的loggedUid2在UserInfo中查其uname，tel
	public ArrayList<UserInfo> selectUserInfoByUid(int loggedUid2){
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from userInfo where uid = '"+loggedUid2+"'";

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
	
	
	
	//把已购买的座位变成红色
			//seatView:根据pid查询 ticket 里的seat
	public ArrayList<Ticket> selectTicketByPid (int pid){
		Connection con = ConnectFactory.getConnection();

		String sql = "select * from ticket where pid="+pid; 
		

		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();

			rs = st.executeQuery(sql);
			

			ArrayList<Ticket> list = new ArrayList<Ticket>();
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setTid(rs.getInt("tid"));
				ticket.setSeat(rs.getInt("seat"));
				ticket.setPid(rs.getInt("pid"));
				ticket.setUid(rs.getInt("uid"));
				
				list.add(ticket);
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
	
	
	
	//我的：已购电影票：
		public ArrayList<String[]>  selectBoughtTicketInfoFromAll(int uid){
			Connection con = ConnectFactory.getConnection();

			String sql = "select mname, cname, seat, ptime, price  from ticket t left join priceTimes pt on"
					+ " t.pid=pt.pid left join cinema c on"
					+ " pt.cid=c.cid left join movie m on"
					+ " pt.mid=m.mid where uid="+uid; 
			

			Statement st = null;
			ResultSet rs = null;
			try {
				st = con.createStatement();

				rs = st.executeQuery(sql);
				
				
				ArrayList<String[]> list = new ArrayList<String[]>();
				
				while (rs.next()) {
					String [] boughtTicketInfo = new String[5];
					
					boughtTicketInfo[0]=rs.getString("mname");
					boughtTicketInfo[1]=rs.getString("cname");
					boughtTicketInfo[2]=rs.getString("seat");
					boughtTicketInfo[3]=rs.getString("ptime");
					boughtTicketInfo[4]=rs.getString("price");
					
					list.add(boughtTicketInfo);
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
		
/*	public static void main(String[] args) {};*/
	
}
