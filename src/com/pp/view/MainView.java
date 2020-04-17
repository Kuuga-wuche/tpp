package com.pp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import com.pp.bean.UserInfo;
import com.pp.service.MovieService;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2 ;
	private JButton movieButton;
	private JPanel oldPanel;
	
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					MainView mainView = MainView.getMainView();
					MovieView movieView = new MovieView();
						
					mainView.setVisible(true);
//把电影界面当做主界面
					mainView.changePanel(movieView);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
//模仿单态模式————只能创建一个主界面，再创建一个新主界面时把原来的隐藏。
	
	//2,提供静态公共的方法获得该类的对象
	public static MainView getMainView( ){
		/*System.out.println("mainview 主方法     "+loggedUid2);*/
		if(mainView!=null){
			mainView.setVisible(false);
			MainView mainView2 = new MainView();
			return mainView2;
		}else{
			mainView = new MainView();
			return mainView;
		}		
	}
	//1,创建私有的构造方法，
	private static MainView mainView =null;
	private MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 116, 508);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		movieButton = new JButton("\u7535\u5F71");
		movieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		movieButton.addMouseListener(new MouseAdapter() {
			@Override
			
//电影 按钮的点击事件
			public void mouseClicked(MouseEvent e) {
				MovieView movieView = new MovieView();
				changePanel(movieView);
			
			}
		});
		movieButton.setForeground(Color.BLUE);
		movieButton.setFont(new Font("楷体_GB2312", Font.BOLD, 30));
		movieButton.setBounds(0, 0, 116, 165);
		panel1.add(movieButton);
		
		JButton cinemaButton = new JButton("\u5F71\u9662");
		cinemaButton.addMouseListener(new MouseAdapter() {
			@Override
//影院按钮的点击事件
			public void mouseClicked(MouseEvent e) {
				CinemaView cinemaView = new CinemaView();
				changePanel(cinemaView);
			}
		});
		cinemaButton.setForeground(Color.BLUE);
		cinemaButton.setFont(new Font("楷体_GB2312", Font.BOLD, 30));
		cinemaButton.setBounds(0, 165, 116, 171);
		panel1.add(cinemaButton);
		
		JButton button_1 = new JButton("\u6211\u7684");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
//我的   点击事件
			public void mouseClicked(MouseEvent e) {

				MyView myView = new MyView();
				changePanel(myView);
			}
		});
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("楷体_GB2312", Font.BOLD, 30));
		button_1.setBounds(0, 337, 116, 171);
		panel1.add(button_1);
		
		panel2 = new JPanel();
		panel2.setBounds(114, 0, 690, 508);
		contentPane.add(panel2);
		panel2.setLayout(null);
	}
	
	
	
//切换panel的方法
	public void changePanel(JPanel newPanel){
		if(oldPanel!=null){
			panel2.remove(oldPanel);//这里必须要加上panel2，否则的话切换的时候会卡。
		}
			panel2.add(newPanel);
			oldPanel = newPanel;
			//重画
			getContentPane().repaint();
			getContentPane().setVisible(true);
		
		
	}
}
