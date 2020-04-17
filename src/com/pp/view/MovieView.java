package com.pp.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.service.MovieService;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieView extends JPanel {
	private JTextField searchBox;
	private JTable table;
	private JButton searchButton;
	private JTextPane info;

	
	

	/**
	 * Create the panel.
	 */
	public MovieView() {
			setSize(690, 508);
			setLayout(null);
			
			searchBox = new JTextField();
			searchBox.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
			searchBox.setColumns(10);
			searchBox.setBounds(10, 10, 549, 35);
			add(searchBox);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 55, 680, 181);
			add(scrollPane);
			
			table = new JTable();
			table.setFont(new Font("楷体_GB2312", Font.PLAIN, 18));
			table.addMouseListener(new MouseAdapter() {
				
				@Override
				
//table 的点击事件
				//点击某一电影，显示电影信息
				public void mouseClicked(MouseEvent e) {
					//取值
					//取点到的行号
					int rowId = table.getSelectedRow();
		//电影名：根据点到的行号取那一行的数据,即电影名
					String mname = String.valueOf(table.getValueAt(rowId, 0));
					
					//根据电影名到movie表中取  其简介信息
							//这里是精确查询
					MovieService movieService = new MovieServiceImpl();
					ArrayList<Movie> list = movieService.selectMovieByMname(mname);
	//因为是在信息框中显示信息，所以不需要重画model
		//因为确定list中只有一条数据，所以也不需要for循环
					Movie m = list.get(0);					
					info.setText(m.getMinfo());
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
				},
				new String[] {
					"\u7535\u5F71"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false
				};
				@Override
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			scrollPane.setViewportView(table);
			
			searchButton = new JButton("\u641C\u7D22");
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			searchButton.addMouseListener(new MouseAdapter() {
				@Override
//搜索	按钮点击事件
				//根据输入的电影名字查询
				public void mouseClicked(MouseEvent e) {
					//取值
					String mname = searchBox.getText();
					
					MovieService movieService = new MovieServiceImpl();
					ArrayList<Movie> list = movieService.selectMovieLikeMname(mname);
					//判断list
					if(list==null || list.size()==0){
						return ;						
					}else{
						//从list中取出Movie对象，再取出电影名称mname放到model相应的位置上
						//1,画model
						String [] titles = {"电影"};
						int rowCount = list.size();
						DefaultTableModel dtm = new DefaultTableModel(titles, rowCount);
						//2,把model放到table上
						table.setModel(dtm);
						//3,把数据从ArrayList中取出来放到model上
						for(int i=0; i<list.size(); i++){
							Movie m = list.get(i);
																	
							dtm.setValueAt(m.getMname(), i, 0);
						}
					}
				}
			});
			searchButton.setFont(new Font("楷体_GB2312", Font.BOLD, 15));
			searchButton.setForeground(Color.RED);
			searchButton.setBounds(569, 5, 111, 45);
			add(searchButton);
			
			JButton selectButton = new JButton("\u7279\u60E0\u9009\u5EA7");
			selectButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			selectButton.addMouseListener(new MouseAdapter() {
				@Override
/*
 * //特惠选座     按钮      的点击事件 
//panel之间的切换--
								
		//有BUG！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
				*/
				//----------已解决！！！！！！！！！！！！！！！！！！！！！！！！
				
				public void mouseClicked(MouseEvent e) {
					//取点到的行号
					int rowId = table.getSelectedRow();
		//电影名：根据点到的行号取那一行的数据,即电影名
					String mname = String.valueOf(table.getValueAt(rowId, 0));
				
//新建要切换到panel的对象
					MovieCinemaView movieCinemaView = new MovieCinemaView(mname);
					//有参构造：：：界面之间传值，本质是类和类之间传值————两种方法：（1，构造方法，2，set get方法）
			
					
					
//把登录的帐号的uid传给MovieCinemaView
					MovieView movieView = new MovieView();
					/*movieCinemaView.setLoggedUid(loggedUid2);*/
					
					
					
					
					//把原主界面隐藏。						
					MainView frame = MainView.getMainView();
					frame.setVisible(true);
					frame.changePanel(movieCinemaView);
					
					
//把本界面中选中的电影名取出来，以备下个界面panel使用
					
					/*String mname = searchBox.getText();*/
					//在另一个界面中显示
					
					

					

					
				}
			});
			selectButton.setForeground(Color.RED);
			selectButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
			selectButton.setBounds(259, 433, 169, 61);
			add(selectButton);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 244, 680, 179);
			add(scrollPane_1);
			
			info = new JTextPane();
			info.setEditable(false);
			info.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			scrollPane_1.setViewportView(info);
			
			
			
			
			
			
			
//——————————————————————————————————————————————————————————————
			//电影界面一出现就显示所有的电影信息
			//把搜索 	点击事件中的代码复制过来，mname设置为空

			
			String mname = "";
			
			MovieService movieService = new MovieServiceImpl();
			ArrayList<Movie> list = movieService.selectMovieLikeMname(mname);
			//判断list
			if(list==null || list.size()==0){
				return ;						
			}else{
				//从list中取出Movie对象，再取出电影名称mname放到model相应的位置上
				//1,画model
				String [] titles = {"电影"};
				int rowCount = list.size();
				DefaultTableModel dtm = new DefaultTableModel(titles, rowCount);
				//2,把model放到table上
				table.setModel(dtm);
				//3,把数据从ArrayList中取出来放到model上
				for(int i=0; i<list.size(); i++){
					Movie m = list.get(i);
															
					dtm.setValueAt(m.getMname(), i, 0);
				}
			}
				
	}
	
}
