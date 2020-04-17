package com.pp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextPane;

import com.pp.bean.Movie;
import com.pp.bean.PriceTimes;
import com.pp.service.CinemaService;
import com.pp.service.impl.CinemaServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CinemaMovieView extends JPanel {
	public JFrame frame;
	public JTextField cinemaName;
	private JTable table;
	private JTextField ptimeinfo;
	private JTextField priceinfo;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	// 构造一个有参的构造方法 在这个方法中就有了这个值 已给这个界面给予了值
	// 前面放一个值 后面有个接收
	public CinemaMovieView(final String selectedCname) {
		setSize(690, 508);
		setLayout(null);
		// 取电影名

		/*
		 * Movie movie=new Movie(); String[] title ={"请选择电影"};
		 * 
		 * int rowcount=list1.size();
		 * 
		 * DefaultTableModel dtm=new DefaultTableModel(title,rowcount);
		 * 
		 * table1.setModel(dtm);
		 * 
		 * for(int i=0;i<list1 .size();i++){
		 * 
		 * Movie movie1=list1.get(i);
		 * 
		 * String mname=movie1.getMname();
		 * 
		 * dtm.setValueAt(mname, i, 0); }
		 */

		cinemaName = new JTextField();
		cinemaName.setEditable(false);
		cinemaName.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		cinemaName.addMouseListener(new MouseAdapter() {

		});
		cinemaName.setBounds(192, 10, 403, 50);
		add(cinemaName);
		cinemaName.setColumns(10);

		// 把带有的方法的值放到框中
		cinemaName.setText(selectedCname);

		JLabel label = new JLabel("\u5F71\u9662\uFF1A");
		label.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label.setBounds(89, 13, 63, 38);
		add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 93, 611, 108);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("楷体_GB2312", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {

			// table 的点击事件
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				
				String mname = String.valueOf(table.getValueAt(row,0));
				
				Object row1 = table.getValueAt(row, 0);
				String strrow = String.valueOf(row1);

				
				CinemaService service = new CinemaServiceImpl();
				ArrayList<Movie> list = service.selectMovieMinfoByMname(strrow);
				Movie movie = list.get(0);
				String info = movie.getMinfo();
				textPane.setText(info);

				// 构造方法中加了final 自动添加 否则报错
				ArrayList<PriceTimes> list1 = service.selectPriceTimesByCMname(
						strrow, selectedCname);
				PriceTimes pt = list1.get(0);
				// 这里需要转换类型 只有String类型才能放到文本框中
				Double price = pt.getPrice();
				String price1 = String.valueOf(price);
				String ptime = pt.getPtime();
				ptimeinfo.setText(ptime);
				priceinfo.setText(price1);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, },
				new String[] { "\u8BF7\u9009\u62E9\u7535\u5F71" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(578);
		scrollPane.setViewportView(table);

		JButton confirmButton = new JButton("\u786E\u8BA4\r\n");
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
			
//确认 	按钮的点击事件
			
			
			public void mouseClicked(MouseEvent e) {
			//table 中 被选中的 电影院名
				int rowId = table.getSelectedRow();
				//根据行号（、列号）取其电影院名
				String mname = String.valueOf(table.getValueAt(rowId,0));
				
				
//从table中复制过来的，待理解
		CinemaService c =new CinemaServiceImpl();
		ArrayList<PriceTimes> list2 = c.selectPriceTimesByMnameAndCname (mname,selectedCname);
		PriceTimes pt = list2.get(0);
				
				SeatView seatView = new SeatView(mname,selectedCname, pt.getPtime(),pt.getPrice());
				
				
				
				
//把登录的帐号的uid传给SeatView
				/*seatView.setLoggedUid();*/
				
				
				
				MainView mainView = MainView.getMainView();
				mainView.setVisible(true);
				mainView.changePanel(seatView);
			}
		});
		confirmButton.setForeground(Color.RED);
		confirmButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		confirmButton.setBounds(247, 447, 169, 61);
		add(confirmButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 212, 614, 120);
		add(scrollPane_1);

		textPane = new JTextPane();
		textPane.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		textPane.setEditable(false);
		scrollPane_1.setViewportView(textPane);

		ptimeinfo = new JTextField();
		ptimeinfo.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		ptimeinfo.setEditable(false);
		ptimeinfo.setBounds(124, 342, 521, 38);
		add(ptimeinfo);
		ptimeinfo.setColumns(10);

		priceinfo = new JTextField();
		priceinfo.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		priceinfo.setEditable(false);
		priceinfo.setColumns(10);
		priceinfo.setBounds(123, 398, 521, 38);
		add(priceinfo);

		CinemaService service1 = new CinemaServiceImpl();
		// 有参的构造方法 有有参的构造方法 再调用的方法中放有参构造方法的名
		ArrayList<Movie> list1 = service1
				.selectMovieCinemaDaoByCname(selectedCname);
		/*
		 * if((list1==null)||(list1.size()==0)){ return ; }
		 */

		String[] title = { "请选择电影" };

		int rowcount = list1.size();

		DefaultTableModel dtm = new DefaultTableModel(title, rowcount);

		table.setModel(dtm);
		
		JLabel label_1 = new JLabel("\u65F6\u95F4\uFF1A");
		label_1.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label_1.setBounds(29, 342, 63, 38);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label_2.setBounds(29, 398, 63, 38);
		add(label_2);
		// i 代表是列
		for (int i = 0; i < list1.size(); i++) {

			Movie movie1 = list1.get(i);
			String movie = movie1.getMname();
/*System.out.println(movie);*/
			table.setValueAt(movie, i, 0);
//————————————————————————————————————————————————————————————————————————————————
		}
	}
}
