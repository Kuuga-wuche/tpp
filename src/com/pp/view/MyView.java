package com.pp.view;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;
import com.pp.service.LoginService;
import com.pp.service.MovieService;
import com.pp.service.impl.LoginServiceImpl;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyView extends JPanel {
	private JTextField textField_1;
	private JTextField nickname;
	private JTextField Tel;
	private JComboBox boughtTicket;
	private JButton loginButton;
	private JButton logoutButton;
	private JTable boughtInfoTable;
	
	
	private int lid =1;
	

	/**
	 * Create the panel.
	 */
	
	
//	
	public MyView() {
		
		setSize(690, 508);
		setLayout(null);
		
//从loggedInfo表中查询数据，看是否已经登录
		LoginService loginService = new LoginServiceImpl();
		ArrayList<LoggedInfo> list = loginService.selectLoggedInfo(lid);
		
		
		
		if(list==null || list.size()==0){
			JOptionPane.showMessageDialog(null, "您还尚未登录PP，请先登录");
	//转到登录界面
			//调用无参构造——————登录后不会转到主界面。
			LoginView loginView = new LoginView();
			loginView.frame.setVisible(true);
			
		}else{
		
		
		
		
			//已登录的话，查询已登录用户的信息————多表联查
			ArrayList<UserInfo> list2 = loginService.selectLoggedInfoAndUserInfo(lid);
			UserInfo u = list2.get(0);
			
		String uname = u.getUname();
		String tel = u.getTel();
		int loggedUid = u.getUid();
		
			
			
			
			
			textField_1 = new JTextField();
			textField_1.setBounds(286, 102, -27, 21);
			add(textField_1);
			textField_1.setColumns(10);
			
			nickname = new JTextField();
			nickname.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			nickname.setEditable(false);
			nickname.setBounds(206, 137, 183, 31);
			add(nickname);
			nickname.setColumns(10);
			
	nickname.setText(uname);
			
			JLabel label_1 = new JLabel("\u6211");
			label_1.setForeground(Color.MAGENTA);
			label_1.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 35));
			label_1.setBounds(273, 35, 75, 67);
			add(label_1);
			
			loginButton = new JButton("\u7ACB\u5373\u767B\u5F55");
			loginButton.addMouseListener(new MouseAdapter() {
//立即登录	按钮的点击事件
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			loginButton.setForeground(Color.RED);
			loginButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
			loginButton.setBounds(115, 368, -1, -2);
			add(loginButton);
			
			logoutButton = new JButton("\u9000\u51FA\u767B\u5F55");
			logoutButton.addMouseListener(new MouseAdapter() {
				@Override
				
	//退出登录	按钮的点击事件
				
				public void mouseClicked(MouseEvent e) {
					//退出登录，本质上就是删除已登录信息表中的数据
					LoginService loginService = new LoginServiceImpl();
					boolean result = loginService.deleteLoggedInfo(lid);
					
					if(result==true){
						JOptionPane.showMessageDialog(null, "退出登录成功");
						nickname.setText("");
						Tel.setText("");
						
						DefaultTableModel dtmNull = new DefaultTableModel();
						boughtInfoTable.setModel(dtmNull);
						
						
					}else{
						JOptionPane.showMessageDialog(null, "退出登录失败");
					}
					
				}
			});
			logoutButton.setForeground(Color.MAGENTA);
			logoutButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
			logoutButton.setBounds(273, 368, 157, 53);
			add(logoutButton);
			
			Tel = new JTextField();
			Tel.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			Tel.setEditable(false);
			Tel.setColumns(10);
			Tel.setBounds(206, 198, 183, 31);
			add(Tel);
			
	Tel.setText(tel);
			
			JLabel label_4 = new JLabel("\u7684");
			label_4.setForeground(Color.RED);
			label_4.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 35));
			label_4.setBounds(380, 35, 60, 67);
			add(label_4);
			
			JLabel label_5 = new JLabel("PP");
			label_5.setForeground(Color.BLUE);
			label_5.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 60));
			label_5.setBounds(10, 20, 75, 47);
			add(label_5);
			
			JButton alterButton = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
			alterButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			alterButton.addMouseListener(new MouseAdapter() {
				
//修改	按钮的点击事件
				//可以修改昵称、电话、密码。
				@Override
				public void mouseClicked(MouseEvent e) {
					UpdateInfoView updateInfoView = new UpdateInfoView();
					
					updateInfoView.frame.setVisible(true);
				}
			});
			alterButton.setForeground(Color.BLUE);
			alterButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
			alterButton.setBounds(273, 445, 163, 53);
			add(alterButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(156, 239, 470, 102);
			add(scrollPane);
			
			boughtInfoTable = new JTable();
			boughtInfoTable.setFont(new Font("宋体", Font.PLAIN, 12));
			boughtInfoTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"\u7535\u5F71", "\u5F71\u9662", "\u5EA7\u4F4D", "\u65F6\u95F4", "\u4EF7\u683C"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, true, false
				};
				@Override
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(boughtInfoTable);
			
			

	
	//把本账号的已购信息填到table中
			MovieService movieService = new MovieServiceImpl();
			ArrayList<String[]> boughtTicketList = movieService
					.selectBoughtTicketInfoFromAll(loggedUid);
			/*
			 * if(boughtTicketList ==null || boughtTicketList.size()==0){
			 * System.out.println(""); }
			 */

			String[] boughtTicketInfo = new String[5];

			String[] titles = { "电影", "影院", "座位", "时间", "价格" };
			// 内容行数
			int rowCount = boughtTicketList.size();
			DefaultTableModel dtm = new DefaultTableModel(titles, rowCount);

			// model--》table上
			boughtInfoTable.setModel(dtm);
			
			JLabel label_3 = new JLabel("\u624B\u673A\u53F7:");
			label_3.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label_3.setBounds(115, 200, 82, 29);
			add(label_3);
			
			JLabel label = new JLabel("\u6635\u79F0:");
			label.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label.setBounds(115, 139, 82, 29);
			add(label);
			
			JLabel label_2 = new JLabel("\u5DF2\u8D2D\u7684");
			label_2.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label_2.setBounds(45, 239, 69, 29);
			add(label_2);
			
			JLabel label_6 = new JLabel("\u7535\u5F71\u7968");
			label_6.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label_6.setBounds(45, 278, 69, 29);
			add(label_6);
			
			JLabel label_7 = new JLabel("**");
			label_7.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label_7.setBounds(115, 239, 31, 29);
			add(label_7);
			
			JLabel label_8 = new JLabel("**");
			label_8.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
			label_8.setBounds(115, 278, 31, 29);
			add(label_8);

			// 2,从ArrayList上取数据---》model的内容
			for (int i = 0; i < boughtTicketList.size(); i++) {
				boughtTicketInfo = boughtTicketList.get(i);

				String mname = boughtTicketInfo[0];
				String cname = boughtTicketInfo[1];
				String seat = boughtTicketInfo[2];
				String ptime = boughtTicketInfo[3];
				String price = boughtTicketInfo[4];

				// 把数据放到model上
				dtm.setValueAt(mname, i, 0);
				dtm.setValueAt(cname, i, 1);
				dtm.setValueAt(seat, i, 2);
				dtm.setValueAt(ptime, i, 3);
				dtm.setValueAt(price, i, 4);

			}
								
		}
	}
}
