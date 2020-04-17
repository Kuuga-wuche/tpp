package com.pp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.service.CinemaService;
import com.pp.service.impl.CinemaServiceImpl;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CinemaView extends JPanel {
	public JFrame frame;
	private JTextField searchBox;
	private JTable table;
	private JTextPane Info;
	private JButton searchButton;
	private JButton selectButton;
	private JPanel oldPanel;

	/**
	 * Create the panel.
	 */

	public CinemaView() {
		setSize(690, 508);
		setLayout(null);

		searchBox = new JTextField();
		searchBox.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		searchBox.setBounds(10, 10, 549, 35);
		add(searchBox);
		searchBox.setColumns(10);

		searchButton = new JButton("\u641C\u7D22");
		searchButton.addMouseListener(new MouseAdapter() {

			// 搜索按钮的点击事件
			// 根据电影院名字搜索
			@Override
			public void mouseClicked(MouseEvent e) {
				// 取电院名字
				String strname = searchBox.getText();

				CinemaService service = new CinemaServiceImpl();
				ArrayList<Cinema> list = service
						.selectCinemaServicelikeByCname(strname);
				if ((list == null) || list.size() == 0) {
					return;
				}

				// 画model
				// 开头
				String[] title = { "影院" };

				int rowcount = list.size();
				// new model
				DefaultTableModel dtm = new DefaultTableModel(title, rowcount);
				// model放到table中
				table.setModel(dtm);
				// for循环
				for (int i = 0; i < list.size(); i++) {

					Cinema cinema = list.get(i);
					// 取值
					String cname = cinema.getCname();

					// 放值
					dtm.setValueAt(cname, i, 0);

				}

			}
		});
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		searchButton.setForeground(Color.RED);
		searchButton.setFont(new Font("楷体_GB2312", Font.BOLD, 15));
		searchButton.setBounds(569, 5, 123, 45);
		add(searchButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 680, 181);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("楷体_GB2312", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {

			// table的点击事件System.out.println(sql);
			@Override
			public void mouseClicked(MouseEvent e) {
				// 取行
				int rowid = table.getSelectedRow();

				// Object rid= table.getValueAt(rowid, 0);
				// 转换类型
				String cname = String.valueOf(table.getValueAt(rowid, 0));
				// String cname1=String.valueOf(table.getValueAt(rowid, 0));
				// new
				CinemaService service = new CinemaServiceImpl();
				ArrayList<Cinema> list = service
						.selectCinemaServiceByaddr(cname);
				if ((list == null) || (list.size() == 0)) {
					return;
				}

				// 取值
				Cinema cinema = list.get(0);
				String addr = cinema.getAddr();
				String name = cinema.getCname();

				// 放到文本框中
				Info.setText(addr);

			}

		});
		table.setModel(new DefaultTableModel(new Object[][] { { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, },
				new String[] { "\u5F71\u9662" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(632);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 244, 680, 179);
		add(scrollPane_1);

		Info = new JTextPane();
		Info.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		Info.setEditable(false);
		scrollPane_1.setViewportView(Info);

		selectButton = new JButton("\u7279\u60E0\u9009\u5EA7");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		selectButton.addMouseListener(new MouseAdapter() {

			// 特惠选座
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * CinemaMovieView cmv=new CinemaMovieView(); changePanel(cmv);
				 * cmv.setVisible(ture); cmv. frame.setVisible(false);
				 */

				// 在点击特惠选座是 在出现的下个界面中已出现了这个值
				// 所以要在复制你点的这个值
				int rowid = table.getSelectedRow();
				String cname = String.valueOf(table.getValueAt(rowid, 0));

				// 先new要跳转的页面的panel
				// 在new界面时就把值放入其中
				CinemaMovieView cmv = new CinemaMovieView(cname);
				// 再new主界面
				/* MainView mv=new MainView(); */
				MainView mv = MainView.getMainView();
				// 显示主界面
				mv.setVisible(true);
				// 把panel放到主界面中
				mv.changePanel(cmv);

			}
		});
		selectButton.setForeground(Color.RED);
		selectButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		selectButton.setBounds(259, 433, 169, 61);
		add(selectButton);
		
		
		
		
		
		
//——————————————————————————————————————————————————————————————
		//影院界面一出现就显示所有的电影信息
		//把搜索 	点击事件中的代码复制过来，strname设置为空		
		
		
		

		// 取电院名字
		String strname = "";

		CinemaService service = new CinemaServiceImpl();
		ArrayList<Cinema> list = service
				.selectCinemaServicelikeByCname(strname);
		if ((list == null) || list.size() == 0) {
			return;
		}

		// 画model
		// 开头
		String[] title = { "影院" };

		int rowcount = list.size();
		// new model
		DefaultTableModel dtm = new DefaultTableModel(title, rowcount);
		// model放到table中
		table.setModel(dtm);
		// for循环
		for (int i = 0; i < list.size(); i++) {

			Cinema cinema = list.get(i);
			// 取值
			String cname = cinema.getCname();

			// 放值
			dtm.setValueAt(cname, i, 0);

		}

	
		
		
		
	}

	/*public void changePanel(JPanel newPanel) {
		
		 * if(oldPanel!=null){ panel1.remove(oldPanel); } panel1.add(newPanel);
		 * 
		 * oldPanel=newPanel;
		 * 
		 * //显示可见 getRootPane().repaint();
		 * 
		 * getRootPane().setVisible(true);
		 * 
		 * 
		 * }
		 
	}*/
}
