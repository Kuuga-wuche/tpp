package com.pp.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.pp.bean.LoggedInfo;
import com.pp.bean.PriceTimes;
import com.pp.bean.Ticket;
import com.pp.service.LoginService;
import com.pp.service.MovieService;
import com.pp.service.impl.LoginServiceImpl;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class SeatView extends JPanel {
	private JTextField movieName;
	private JTextField cinemaMame;
	
	private JTextField dateTime;
	private JTextField priceT;
//ѡ�е���λ��
	private int seat;
	
	private int lid =1;
	
	
	//BUTTON
		private JButton button_1;
		private JButton button_2;
		private JButton button_3;
		private JButton button_4;
		private JButton button_5;
		private JButton button_6;
		private JButton button_7;
		private JButton button_8;
		private JButton button_9;
		private JButton button_10;
		private JButton button_11;
		private JButton button_12;
		private JButton button_13;
		private JButton button_14;
		private JButton button_15;
		private JButton button_16;
		private JButton button_17;
		private JButton button_18;
		private JButton button_19;
		private JButton button_20;
		private JButton button_21;
		private JButton button_22;
		private JButton button_23;
		private JButton button_24;
		private JButton button_25;
		private JButton button_26;
		private JButton button_27;
		private JButton button_28;
		private JButton button_29;
		private JButton button_30;
		private JButton button_31;
		private JButton button_32;
		private JButton button_33;
		private JButton button_34;
		private JButton button_35;
		private JButton button_36;
		private JButton button_37;
		private JButton button_38;
		private JButton button_39;
		private JButton button_40;
		private JButton button_41;
		private JButton button_42;
		private JButton button_43;
		private JButton button_44;
		private JButton button_45;
		private JButton button_46;
		private JButton button_47;
		private JButton button_48;
		private JButton button_49;
		private JButton button_50;
		private JButton button_59;
		private JButton confirmButton;

	
	/**
	 * Create the panel.
	 */
	public SeatView(final String mname, final String cname,String time,double price) {
		
		//�������������Ҫ�ĳ�final���͵ģ������������¼��в��ܵ���
//��������
		setSize(690, 508);
		setLayout(null);
		
		JLabel label = new JLabel("\u7535\u5F71\uFF1A");
		label.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label.setBounds(17, 10, 70, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\u5F71\u9662\uFF1A");
		label_1.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_1.setBounds(357, 10, 63, 48);
		add(label_1);
		
		movieName = new JTextField();
		movieName.setEditable(false);
		movieName.setFont(new Font("����_GB2312", Font.BOLD, 20));
		movieName.setBounds(97, 10, 250, 48);
		add(movieName);
		movieName.setColumns(10);
//�ڴ˽������ʱ��ʾ�ϸ�������ѡ�еĵ�Ӱ����
		movieName.setText(mname);
		
		cinemaMame = new JTextField();
		cinemaMame.setEditable(false);
		cinemaMame.setFont(new Font("����_GB2312", Font.BOLD, 20));
		cinemaMame.setColumns(10);
		cinemaMame.setBounds(430, 10, 250, 48);
		add(cinemaMame);
//�ڴ˽������ʱ��ʾ�ϸ�������ѡ�еĵ�Ӱ����
		cinemaMame.setText(cname);

		
		
		
		
//������������������������������������  һ���Ȱ��ѱ��������λ��ɺ�ɫ����������������������������������������������������������������������������������������������������������������������������������������		
		
		MovieService movieService = new MovieServiceImpl();
		//���ݵ�Ӱ����mname �� ӰԺ����cname	�������pid
		ArrayList<PriceTimes> list =  movieService.selectPriceTimesByMnameAndCname(mname, cname);
		PriceTimes priceTimes = list.get(0);
		int pid = priceTimes.getPid();
		/*System.out.println(pid);*/
		//���ݳ���pid����γ������ѱ��������λ
		ArrayList<Ticket> list2 =  movieService.selectTicketByPid(pid);
		
		
			
		
		
		
		
//������������������������������������������������һ���Ȱ��ѱ��������λ��ɺ�ɫ����������ɣ�����������������������������������������������������������������������������������������������������������������������������������������
		
		
		
		
		

		
//��������������������������������������������������������������ȷ��ѡ��  ��ť�ĵ���¼�����������������������������������������������������������������
		
		
		confirmButton = new JButton("\u786E\u8BA4\u9009\u5EA7");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmButton.addMouseListener(new MouseAdapter() {
				
				
	//ȷ��ѡ��  ��ť�ĵ���¼�
				//��ticket���в�������
				@Override
		public void mouseClicked(MouseEvent e) {
			
			LoginService loginService = new LoginServiceImpl();
			ArrayList<LoggedInfo> list2 = loginService.selectLoggedInfo(lid);
			if(list2==null || list2.size()==0){
				return ;
			}
			LoggedInfo l = list2.get(0);
			int loggedUid2 = l.getUid();
			
	//�ж��Ƿ��Ѿ���¼				
			if (loggedUid2 > 0) {// loggedUid2>0���������Ѿ���¼����Ϊuid���õ��Ǵ�1��ʼ�����ģ�uid����0����uid���ڵ�����£���˵���Ѿ���¼
	
				/* System.out.println("seat����		"+loggedUid2); */
				MovieService movieService = new MovieServiceImpl();
				// ȡpid
				ArrayList<PriceTimes> list = movieService
						.selectPriceTimesByMnameAndCname(mname, cname);
				PriceTimes p = list.get(0);
				int pid = p.getPid();
	
				/*
				 * if(seat!=0){ movieService.insertTicket( seat
				 * ,loggedUid2,pid); JOptionPane.showMessageDialog(null,
				 * "��Ʊ�ɹ�"); }
				 */
	
				// һ�ι������Ʊ
				
				
// ���	ȷ�Ϲ�Ʊ�������ı��ѱ�������λ����ɫ������������ɫ�ĸ�Ϊ��ɫ
				
				if (button_1.getBackground().equals(Color.green)) {
					movieService.insertTicket(1, loggedUid2, pid);
					button_1.setBackground(Color.red);
				}
	
				if (button_2.getBackground().equals(Color.green)) {
					movieService.insertTicket(2, loggedUid2, pid);
					button_2.setBackground(Color.red);
				}
	
				if (button_3.getBackground().equals(Color.green)) {
					movieService.insertTicket(3, loggedUid2, pid);
					button_3.setBackground(Color.red);
				}
	
				if (button_4.getBackground().equals(Color.green)) {
					movieService.insertTicket(4, loggedUid2, pid);
					button_4.setBackground(Color.red);
				}
	
				if (button_5.getBackground().equals(Color.green)) {
					movieService.insertTicket(5, loggedUid2, pid);
					button_5.setBackground(Color.red);
				}
	
				if (button_6.getBackground().equals(Color.green)) {
					movieService.insertTicket(6, loggedUid2, pid);
					button_6.setBackground(Color.red);
				}
	
				if (button_7.getBackground().equals(Color.green)) {
					movieService.insertTicket(7, loggedUid2, pid);
					button_7.setBackground(Color.red);
				}
	
				if (button_8.getBackground().equals(Color.green)) {
					movieService.insertTicket(8, loggedUid2, pid);
					button_8.setBackground(Color.red);
				}
	
				if (button_9.getBackground().equals(Color.green)) {
					movieService.insertTicket(9, loggedUid2, pid);
					button_9.setBackground(Color.red);
				}
	
				if (button_10.getBackground().equals(Color.green)) {
					movieService.insertTicket(10, loggedUid2, pid);
					button_10.setBackground(Color.red);
				}
	
				if (button_11.getBackground().equals(Color.green)) {
					movieService.insertTicket(11, loggedUid2, pid);
					button_11.setBackground(Color.red);
				}
	
				if (button_12.getBackground().equals(Color.green)) {
					movieService.insertTicket(12, loggedUid2, pid);
					button_12.setBackground(Color.red);
				}
	
				if (button_13.getBackground().equals(Color.green)) {
					movieService.insertTicket(13, loggedUid2, pid);
					button_13.setBackground(Color.red);
				}
	
				if (button_14.getBackground().equals(Color.green)) {
					movieService.insertTicket(14, loggedUid2, pid);
					button_14.setBackground(Color.red);
				}
	
				if (button_15.getBackground().equals(Color.green)) {
					movieService.insertTicket(15, loggedUid2, pid);
					button_15.setBackground(Color.red);
				}
	
				if (button_16.getBackground().equals(Color.green)) {
					movieService.insertTicket(16, loggedUid2, pid);
					button_16.setBackground(Color.red);
				}
	
				if (button_17.getBackground().equals(Color.green)) {
					movieService.insertTicket(17, loggedUid2, pid);
					button_17.setBackground(Color.red);
				}
	
				if (button_18.getBackground().equals(Color.green)) {
					movieService.insertTicket(18, loggedUid2, pid);
					button_18.setBackground(Color.red);
				}
	
				if (button_19.getBackground().equals(Color.green)) {
					movieService.insertTicket(19, loggedUid2, pid);
					button_19.setBackground(Color.red);
				}
	
				if (button_20.getBackground().equals(Color.green)) {
					movieService.insertTicket(20, loggedUid2, pid);
					button_20.setBackground(Color.red);
				}
	
				if (button_21.getBackground().equals(Color.green)) {
					movieService.insertTicket(21, loggedUid2, pid);
					button_21.setBackground(Color.red);
				}
	
				if (button_22.getBackground().equals(Color.green)) {
					movieService.insertTicket(22, loggedUid2, pid);
					button_22.setBackground(Color.red);
				}
	
				if (button_23.getBackground().equals(Color.green)) {
					movieService.insertTicket(23, loggedUid2, pid);
					button_23.setBackground(Color.red);
				}
	
				if (button_24.getBackground().equals(Color.green)) {
					movieService.insertTicket(24, loggedUid2, pid);
					button_24.setBackground(Color.red);
				}
	
				if (button_25.getBackground().equals(Color.green)) {
					movieService.insertTicket(25, loggedUid2, pid);
					button_25.setBackground(Color.red);
				}
	
				if (button_26.getBackground().equals(Color.green)) {
					movieService.insertTicket(26, loggedUid2, pid);
					button_26.setBackground(Color.red);
				}
	
				if (button_27.getBackground().equals(Color.green)) {
					movieService.insertTicket(27, loggedUid2, pid);
					button_27.setBackground(Color.red);
				}
	
				if (button_28.getBackground().equals(Color.green)) {
					movieService.insertTicket(28, loggedUid2, pid);
					button_28.setBackground(Color.red);
				}
	
				if (button_29.getBackground().equals(Color.green)) {
					movieService.insertTicket(29, loggedUid2, pid);
					button_29.setBackground(Color.red);
				}
	
				if (button_30.getBackground().equals(Color.green)) {
					movieService.insertTicket(30, loggedUid2, pid);
					button_30.setBackground(Color.red);
				}
	
				if (button_31.getBackground().equals(Color.green)) {
					movieService.insertTicket(31, loggedUid2, pid);
					button_31.setBackground(Color.red);
				}
	
				if (button_32.getBackground().equals(Color.green)) {
					movieService.insertTicket(32, loggedUid2, pid);
					button_32.setBackground(Color.red);
				}
	
				if (button_33.getBackground().equals(Color.green)) {
					movieService.insertTicket(33, loggedUid2, pid);
					button_33.setBackground(Color.red);
				}
	
				if (button_34.getBackground().equals(Color.green)) {
					movieService.insertTicket(34, loggedUid2, pid);
					button_34.setBackground(Color.red);
				}
	
				if (button_35.getBackground().equals(Color.green)) {
					movieService.insertTicket(35, loggedUid2, pid);
					button_35.setBackground(Color.red);
				}
	
				if (button_36.getBackground().equals(Color.green)) {
					movieService.insertTicket(36, loggedUid2, pid);
					button_36.setBackground(Color.red);
				}
	
				if (button_37.getBackground().equals(Color.green)) {
					movieService.insertTicket(37, loggedUid2, pid);
					button_37.setBackground(Color.red);
				}
	
				if (button_38.getBackground().equals(Color.green)) {
					movieService.insertTicket(38, loggedUid2, pid);
					button_38.setBackground(Color.red);
				}
	
				if (button_39.getBackground().equals(Color.green)) {
					movieService.insertTicket(39, loggedUid2, pid);
					button_39.setBackground(Color.red);
				}
	
				if (button_40.getBackground().equals(Color.green)) {
					movieService.insertTicket(40, loggedUid2, pid);
					button_40.setBackground(Color.red);
				}
	
				if (button_41.getBackground().equals(Color.green)) {
					movieService.insertTicket(41, loggedUid2, pid);
					button_41.setBackground(Color.red);
				}
	
				if (button_42.getBackground().equals(Color.green)) {
					movieService.insertTicket(42, loggedUid2, pid);
					button_42.setBackground(Color.red);
				}
	
				if (button_43.getBackground().equals(Color.green)) {
					movieService.insertTicket(43, loggedUid2, pid);
					button_43.setBackground(Color.red);
				}
	
				if (button_44.getBackground().equals(Color.green)) {
					movieService.insertTicket(44, loggedUid2, pid);
					button_44.setBackground(Color.red);
				}
	
				if (button_45.getBackground().equals(Color.green)) {
					movieService.insertTicket(45, loggedUid2, pid);
					button_45.setBackground(Color.red);
				}
	
				if (button_46.getBackground().equals(Color.green)) {
					movieService.insertTicket(46, loggedUid2, pid);
					button_46.setBackground(Color.red);
				}
	
				if (button_47.getBackground().equals(Color.green)) {
					movieService.insertTicket(47, loggedUid2, pid);
					button_47.setBackground(Color.red);
				}
	
				if (button_48.getBackground().equals(Color.green)) {
					movieService.insertTicket(48, loggedUid2, pid);
					button_48.setBackground(Color.red);
				}
	
				if (button_49.getBackground().equals(Color.green)) {
					movieService.insertTicket(49, loggedUid2, pid);
					button_49.setBackground(Color.red);
				}
	
				if (button_50.getBackground().equals(Color.green)) {
					movieService.insertTicket(50, loggedUid2, pid);
					button_50.setBackground(Color.red);
				}
	
				JOptionPane.showMessageDialog(null, "��Ʊ�ɹ�");
	
			}else{
				JOptionPane.showMessageDialog(null, "������δ��¼�����ȵ�¼");
				LoginView  loginView = new LoginView("");
				loginView.frame.setVisible(true);
			}
			
		}
			});
		
		
		confirmButton.setForeground(Color.RED);
		confirmButton.setFont(new Font("����_GB2312", Font.BOLD, 20));
		confirmButton.setBounds(233, 425, 169, 61);
		add(confirmButton);
		
		JLabel label_2 = new JLabel("\u65F6\u95F4\uFF1A");
		label_2.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_2.setBounds(17, 68, 70, 48);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_3.setBounds(357, 68, 63, 48);
		add(label_3);
		
		dateTime = new JTextField();
		dateTime.setText("<dynamic>");
		dateTime.setFont(new Font("����_GB2312", Font.BOLD, 20));
		dateTime.setEditable(false);
		dateTime.setColumns(10);
		dateTime.setBounds(97, 69, 250, 48);
		add(dateTime);
//�����ڳ���ʱ��ʾֵ
		dateTime.setText(time);
		
		priceT = new JTextField();
		priceT.setText("<dynamic>");
		priceT.setFont(new Font("����_GB2312", Font.BOLD, 20));
		priceT.setEditable(false);
		priceT.setColumns(10);
		priceT.setBounds(430, 68, 250, 48);
		add(priceT);
//�����ڳ���ʱ��ʾֵ
		priceT.setText(String.valueOf(price));
		
		
		
		
		
//������λ��ť��������������������������������������������������������������������������������������������������������������������������������
		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(18, 126, 625, 48);
		add(panel1);
		panel1.setLayout(null);

		button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_1.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_1.setBackground(Color.green);
						i = 1;
					} else {
						button_1.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(554, 10, 60, 34);
		panel1.add(button_1);

		button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_2.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_2.setBackground(Color.green);
						i = 2;
					} else {
						button_2.setBackground(Color.orange);
						i = 0;
System.out.println("button_2	"+button_2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_2.setBackground(Color.ORANGE);
		button_2.setBounds(494, 10, 60, 34);
		panel1.add(button_2);

		button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_3.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_3.setBackground(Color.green);
						i = 3;
					} else {
						button_3.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_3.setBackground(Color.ORANGE);
		button_3.setBounds(434, 10, 60, 34);
		panel1.add(button_3);

		button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_4.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_4.setBackground(Color.green);
						i = 4;
					} else {
						button_4.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_4.setBackground(Color.ORANGE);
		button_4.setBounds(374, 10, 60, 34);
		panel1.add(button_4);

		button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_5.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_5.setBackground(Color.green);
						i = 5;
					} else {
						button_5.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_5.setBackground(Color.ORANGE);
		button_5.setBounds(314, 10, 60, 34);
		panel1.add(button_5);

		button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_6.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_6.setBackground(Color.green);
						i = 6;
					} else {
						button_6.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_6.setBackground(Color.ORANGE);
		button_6.setBounds(254, 10, 60, 34);
		panel1.add(button_6);

		button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_7.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_7.setBackground(Color.green);
						i = 7;
					} else {
						button_7.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_7.setBackground(Color.ORANGE);
		button_7.setBounds(194, 10, 60, 34);
		panel1.add(button_7);

		button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_8.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_8.setBackground(Color.green);
						i = 8;
					} else {
						button_8.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_8.setBackground(Color.ORANGE);
		button_8.setBounds(134, 10, 60, 34);
		panel1.add(button_8);

		button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_9.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_9.setBackground(Color.green);
						i = 9;
					} else {
						button_9.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_9.setBackground(Color.ORANGE);
		button_9.setBounds(74, 10, 60, 34);
		panel1.add(button_9);

		button_10 = new JButton("10");
		button_10.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_10.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_10.setBackground(Color.green);
						i = 10;
					} else {
						button_10.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_10.setBackground(Color.ORANGE);
		button_10.setBounds(14, 10, 60, 34);
		panel1.add(button_10);

		JPanel panel2 = new JPanel();
		panel2.setBounds(55, 184, 625, 48);
		add(panel2);
		panel2.setLayout(null);

		button_11 = new JButton("11");
		button_11.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_11.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_11.setBackground(Color.green);
						i = 11;
					} else {
						button_11.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_11.setBackground(Color.ORANGE);
		button_11.setBounds(554, 10, 60, 34);
		panel2.add(button_11);

		button_12 = new JButton("12");
		button_12.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_12.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_12.setBackground(Color.green);
						i = 12;
					} else {
						button_12.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_12.setBackground(Color.ORANGE);
		button_12.setBounds(494, 10, 60, 34);
		panel2.add(button_12);

		button_13 = new JButton("13");
		button_13.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_13.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_13.setBackground(Color.green);
						i = 13;
					} else {
						button_13.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_13.setBackground(Color.ORANGE);
		button_13.setBounds(434, 10, 60, 34);
		panel2.add(button_13);

		button_14 = new JButton("14");
		button_14.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_14.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_14.setBackground(Color.green);
						i = 14;
					} else {
						button_14.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_14.setBackground(Color.ORANGE);
		button_14.setBounds(374, 10, 60, 34);
		panel2.add(button_14);

		button_15 = new JButton("15");
		button_15.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_15.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_15.setBackground(Color.green);
						i = 15;
					} else {
						button_15.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_15.setBackground(Color.ORANGE);
		button_15.setBounds(314, 10, 60, 34);
		panel2.add(button_15);

		button_16 = new JButton("16");
		button_16.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_16.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_16.setBackground(Color.green);
						i = 16;
					} else {
						button_16.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_16.setBackground(Color.ORANGE);
		button_16.setBounds(254, 10, 60, 34);
		panel2.add(button_16);

		button_17 = new JButton("17");
		button_17.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_17.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_17.setBackground(Color.green);
						i = 17;
					} else {
						button_17.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_17.setBackground(Color.ORANGE);
		button_17.setBounds(194, 10, 60, 34);
		panel2.add(button_17);

		button_18 = new JButton("18");
		button_18.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_18.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_18.setBackground(Color.green);
						i = 18;
					} else {
						button_18.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_18.setBackground(Color.ORANGE);
		button_18.setBounds(134, 10, 60, 34);
		panel2.add(button_18);

		button_19 = new JButton("19");
		button_19.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_19.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_19.setBackground(Color.green);
						i = 19;
					} else {
						button_19.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_19.setBackground(Color.ORANGE);
		button_19.setBounds(74, 10, 60, 34);
		panel2.add(button_19);

		button_20 = new JButton("20");
		button_20.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_20.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_20.setBackground(Color.green);
						i = 20;
					} else {
						button_20.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_20.setBackground(Color.ORANGE);
		button_20.setBounds(14, 10, 60, 34);
		panel2.add(button_20);

		JPanel panel3 = new JPanel();
		panel3.setBounds(18, 242, 625, 48);
		add(panel3);
		panel3.setLayout(null);

		button_21 = new JButton("21");
		button_21.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_21.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_21.setBackground(Color.green);
						i = 21;
					} else {
						button_21.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_21.setBackground(Color.ORANGE);
		button_21.setBounds(554, 10, 60, 34);
		panel3.add(button_21);

		button_22 = new JButton("22");
		button_22.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_22.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_22.setBackground(Color.green);
						i = 22;
					} else {
						button_22.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_22.setBackground(Color.ORANGE);
		button_22.setBounds(494, 10, 60, 34);
		panel3.add(button_22);

		button_23 = new JButton("23");
		button_23.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_23.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_23.setBackground(Color.green);
						i = 23;
					} else {
						button_23.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_23.setBackground(Color.ORANGE);
		button_23.setBounds(434, 10, 60, 34);
		panel3.add(button_23);

		button_24 = new JButton("24");
		button_24.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_24.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_24.setBackground(Color.green);
						i = 24;
					} else {
						button_24.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_24.setBackground(Color.ORANGE);
		button_24.setBounds(374, 10, 60, 34);
		panel3.add(button_24);

		button_25 = new JButton("25");
		button_25.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_25.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_25.setBackground(Color.green);
						i = 25;
					} else {
						button_25.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_25.setBackground(Color.ORANGE);
		button_25.setBounds(314, 10, 60, 34);
		panel3.add(button_25);

		button_26 = new JButton("26");
		button_26.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_26.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_26.setBackground(Color.green);
						i = 26;
					} else {
						button_26.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_26.setBackground(Color.ORANGE);
		button_26.setBounds(254, 10, 60, 34);
		panel3.add(button_26);

		button_27 = new JButton("27");
		button_27.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_27.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_27.setBackground(Color.green);
						i = 27;
					} else {
						button_27.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_27.setBackground(Color.ORANGE);
		button_27.setBounds(194, 10, 60, 34);
		panel3.add(button_27);

		button_28 = new JButton("28");
		button_28.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_28.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_28.setBackground(Color.green);
						i = 28;
					} else {
						button_28.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_28.setBackground(Color.ORANGE);
		button_28.setBounds(134, 10, 60, 34);
		panel3.add(button_28);

		button_29 = new JButton("29");
		button_29.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_29.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_29.setBackground(Color.green);
						i = 29;
					} else {
						button_29.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_29.setBackground(Color.ORANGE);
		button_29.setBounds(74, 10, 60, 34);
		panel3.add(button_29);

		button_30 = new JButton("30");
		button_30.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_30.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_30.setBackground(Color.green);
						i = 30;
					} else {
						button_30.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_30.setBackground(Color.ORANGE);
		button_30.setBounds(14, 10, 60, 34);
		panel3.add(button_30);

		JPanel panel4 = new JPanel();
		panel4.setBounds(55, 300, 625, 48);
		add(panel4);
		panel4.setLayout(null);

		button_31 = new JButton("31");
		button_31.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_31.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_31.setBackground(Color.green);
						i = 31;
					} else {
						button_31.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_31.setBackground(Color.ORANGE);
		button_31.setBounds(554, 10, 60, 34);
		panel4.add(button_31);

		button_32 = new JButton("32");
		button_32.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_32.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_32.setBackground(Color.green);
						i = 32;
					} else {
						button_32.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_32.setBackground(Color.ORANGE);
		button_32.setBounds(494, 10, 60, 34);
		panel4.add(button_32);

		button_33 = new JButton("33");
		button_33.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_33.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_33.setBackground(Color.green);
						i = 33;
					} else {
						button_33.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_33.setBackground(Color.ORANGE);
		button_33.setBounds(434, 10, 60, 34);
		panel4.add(button_33);

		button_34 = new JButton("34");
		button_34.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_34.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_34.setBackground(Color.green);
						i = 34;
					} else {
						button_34.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_34.setBackground(Color.ORANGE);
		button_34.setBounds(374, 10, 60, 34);
		panel4.add(button_34);

		button_35 = new JButton("35");
		button_35.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_35.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_35.setBackground(Color.green);
						i = 35;
					} else {
						button_35.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_35.setBackground(Color.ORANGE);
		button_35.setBounds(314, 10, 60, 34);
		panel4.add(button_35);

		button_36 = new JButton("36");
		button_36.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_36.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_36.setBackground(Color.green);
						i = 36;
					} else {
						button_36.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_36.setBackground(Color.ORANGE);
		button_36.setBounds(254, 10, 60, 34);
		panel4.add(button_36);

		button_37 = new JButton("37");
		button_37.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_37.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_37.setBackground(Color.green);
						i = 37;
					} else {
						button_37.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_37.setBackground(Color.ORANGE);
		button_37.setBounds(194, 10, 60, 34);
		panel4.add(button_37);

		button_38 = new JButton("38");
		button_38.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_38.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_38.setBackground(Color.green);
						i = 38;
					} else {
						button_38.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_38.setBackground(Color.ORANGE);
		button_38.setBounds(134, 10, 60, 34);
		panel4.add(button_38);

		button_39 = new JButton("39");
		button_39.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_39.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_39.setBackground(Color.green);
						i = 39;
					} else {
						button_39.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_39.setBackground(Color.ORANGE);
		button_39.setBounds(74, 10, 60, 34);
		panel4.add(button_39);

		button_40 = new JButton("40");
		button_40.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_40.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_40.setBackground(Color.green);
						i = 40;
					} else {
						button_40.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_40.setBackground(Color.ORANGE);
		button_40.setBounds(14, 10, 60, 34);
		panel4.add(button_40);

		JPanel panel5 = new JPanel();
		panel5.setBounds(18, 358, 625, 48);
		add(panel5);
		panel5.setLayout(null);

		button_41 = new JButton("41");
		button_41.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_41.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_41.setBackground(Color.green);
						i = 41;
					} else {
						button_41.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_41.setBackground(Color.ORANGE);
		button_41.setBounds(554, 10, 60, 34);
		panel5.add(button_41);

		button_42 = new JButton("42");
		button_42.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_42.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_42.setBackground(Color.green);
						i = 42;
					} else {
						button_42.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_42.setBackground(Color.ORANGE);
		button_42.setBounds(494, 10, 60, 34);
		panel5.add(button_42);

		button_43 = new JButton("43");
		button_43.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_43.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_43.setBackground(Color.green);
						i = 43;
					} else {
						button_43.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_43.setBackground(Color.ORANGE);
		button_43.setBounds(434, 10, 60, 34);
		panel5.add(button_43);

		button_44 = new JButton("44");
		button_44.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_44.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_44.setBackground(Color.green);
						i = 44;
					} else {
						button_44.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_44.setBackground(Color.ORANGE);
		button_44.setBounds(374, 10, 60, 34);
		panel5.add(button_44);

		button_45 = new JButton("45");
		button_45.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_45.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_45.setBackground(Color.green);
						i = 45;
					} else {
						button_45.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_45.setBackground(Color.ORANGE);
		button_45.setBounds(314, 10, 60, 34);
		panel5.add(button_45);

		button_46 = new JButton("46");
		button_46.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_46.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_46.setBackground(Color.green);
						i = 46;
					} else {
						button_46.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_46.setBackground(Color.ORANGE);
		button_46.setBounds(254, 10, 60, 34);
		panel5.add(button_46);

		button_47 = new JButton("47");
		button_47.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_47.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_47.setBackground(Color.green);
						i = 47;
					} else {
						button_47.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_47.setBackground(Color.ORANGE);
		button_47.setBounds(194, 10, 60, 34);
		panel5.add(button_47);

		button_48 = new JButton("48");
		button_48.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_48.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_48.setBackground(Color.green);
						i = 48;
					} else {
						button_48.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_48.setBackground(Color.ORANGE);
		button_48.setBounds(134, 10, 60, 34);
		panel5.add(button_48);

		button_49 = new JButton("49");
		button_49.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_49.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_49.setBackground(Color.green);
						i = 49;
					} else {
						button_49.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_49.setBackground(Color.ORANGE);
		button_49.setBounds(74, 10, 60, 34);
		panel5.add(button_49);

		button_50 = new JButton("50");
		button_50.addMouseListener(new MouseAdapter() {
			int i = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!button_50.getBackground().equals(Color.red)) {
					if (i == 0) {
						button_50.setBackground(Color.green);
						i = 50;
					} else {
						button_50.setBackground(Color.orange);
						i = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������Ӵ�������λ�Ѿ�������ѡ����");
				}
			}
		});

		button_50.setBackground(Color.ORANGE);
		button_50.setBounds(14, 10, 60, 34);
		panel5.add(button_50);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//ԭ���Ƿŵ�λ�������⣺����Ҫ��	button_i��	����	�ŵ�������button֮��
		//���������������У���Ա�������߳�Ա����д��λ�ò���Ӱ��	�����ڵĵ��ã����磬һ���������м䣬����������ڵ���д��������ķ���Ҳû���⡣��
		//�������������ڷ����У��������췽��Ҳ�������ڣ��������Ǵ�������ִ�е�!!!!
//�쵰����Ȼ��Ϊ�������������˷��˼���Сʱ��ʱ�䣡����������������������������������������������������������������
		
		
		for (int i = 0; i < list2.size(); i++) {//��Ϊ���list2д����list���˷��˰��Сʱ
			if(list2!=null && list2.size()!=0){

			Ticket t = list2.get(i);
			
			seat = t.getSeat();
			
/*System.out.println("seat		"+seat);
System.out.println("0000"+button_1+"  "+button_2+"  "+button_35+"  "+button_50);
*/
			//��ôbutton�����null�ˣ�

// ������ı��������λ�Ŷ������֣�Ҫ��������ֶ�Ӧ�� button ��ɺ�ɫ
			if (seat == 1) {
				button_1.setBackground(Color.red);//���ݲ��ԣ�1��seat==0(Ĭ��ֵ)ʱ��Ҳ����˵if�ж�Ϊfalseʱ��������ʾ����λ
			}//2��������������ԣ�button_i��ֵȫ��Ϊnull��������2�����seat������һ�������������һ���жϵı�����ǿ�ָ���쳣

			if (seat == 2) {
				button_2.setBackground(Color.red);
			}

			if (seat == 3) {
				button_3.setBackground(Color.red);
			}

			if (seat == 4) {
				button_4.setBackground(Color.red);
			}

			if (seat == 5) {
				button_5.setBackground(Color.red);
			}

			if (seat == 6) {
				button_6.setBackground(Color.red);
			}

			if (seat == 7) {
				button_7.setBackground(Color.red);
			}

			if (seat == 8) {
				button_8.setBackground(Color.red);
			}

			if (seat == 9) {
				button_9.setBackground(Color.red);
			}

			if (seat == 10) {
				button_10.setBackground(Color.red);
			}

			if (seat == 11) {
				button_11.setBackground(Color.red);
			}

			if (seat == 12) {
				button_12.setBackground(Color.red);
			}

			if (seat == 13) {
				button_13.setBackground(Color.red);
			}

			if (seat == 14) {
				button_14.setBackground(Color.red);
			}

			if (seat == 15) {
				button_15.setBackground(Color.red);
			}

			if (seat == 16) {
				button_16.setBackground(Color.red);
			}

			if (seat == 17) {
				button_17.setBackground(Color.red);
			}

			if (seat == 18) {
				button_18.setBackground(Color.red);
			}

			if (seat == 19) {
				button_19.setBackground(Color.red);
			}

			if (seat == 20) {
				button_20.setBackground(Color.red);
			}

			if (seat == 21) {
				button_21.setBackground(Color.red);
			}

			if (seat == 22) {
				button_22.setBackground(Color.red);
			}

			if (seat == 23) {
				button_23.setBackground(Color.red);
			}

			if (seat == 24) {
				button_24.setBackground(Color.red);
			}

			if (seat == 25) {
				button_25.setBackground(Color.red);
			}

			if (seat == 26) {
				button_26.setBackground(Color.red);
			}

			if (seat == 27) {
				button_27.setBackground(Color.red);
			}

			if (seat == 28) {
				button_28.setBackground(Color.red);
			}

			if (seat == 29) {
				button_29.setBackground(Color.red);
			}

			if (seat == 30) {
				button_30.setBackground(Color.red);
			}

			if (seat == 31) {
				button_31.setBackground(Color.red);
			}

			if (seat == 32) {
				button_32.setBackground(Color.red);
			}

			if (seat == 33) {
				button_33.setBackground(Color.red);
			}

			if (seat == 34) {
				button_34.setBackground(Color.red);
			}

			if (seat == 35) {
				button_35.setBackground(Color.red);
			}

			if (seat == 36) {
				button_36.setBackground(Color.red);
			}

			if (seat == 37) {
				button_37.setBackground(Color.red);
			}

			if (seat == 38) {
				button_38.setBackground(Color.red);
			}

			if (seat == 39) {
				button_39.setBackground(Color.red);
			}

			if (seat == 40) {
				button_40.setBackground(Color.red);
			}

			if (seat == 41) {
				button_41.setBackground(Color.red);
			}

			if (seat == 42) {
				button_42.setBackground(Color.red);
			}

			if (seat == 43) {
				button_43.setBackground(Color.red);
			}

			if (seat == 44) {
				button_44.setBackground(Color.red);
			}

			if (seat == 45) {
				button_45.setBackground(Color.red);
			}

			if (seat == 46) {
				button_46.setBackground(Color.red);
			}

			if (seat == 47) {
				button_47.setBackground(Color.red);
			}

			if (seat == 48) {
				button_48.setBackground(Color.red);
			}

			if (seat == 49) {
				button_49.setBackground(Color.red);
			}

			if (seat == 50) {
				button_50.setBackground(Color.red);
			}
	/*		System.out.println("forѭ��������"+button_1+"  "+button_2+"  "+button_35+"  "+button_50);*/
		}
	}

	}
	

	/*}*/
	
	
	
}
