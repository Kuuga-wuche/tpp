package com.pp.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.pp.service.RegisterService;
import com.pp.service.impl.RegisterServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterView {

	public JFrame frame;
	private JTextField nickname;
	private JTextField Tel;
	private JPasswordField Pass;
	private JPasswordField Pass1;
	private JLabel lblPp;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegisterView window = new RegisterView();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("楷体_GB2312", Font.PLAIN, 14));
		frame.setBounds(100, 100, 493, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nickname = new JTextField();
		nickname.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		nickname.setBounds(187, 43, 173, 29);
		frame.getContentPane().add(nickname);
		nickname.setColumns(10);
		
		Tel = new JTextField();
		Tel.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		Tel.setColumns(10);
		Tel.setBounds(187, 96, 173, 29);
		frame.getContentPane().add(Tel);
		
		Pass = new JPasswordField();
		Pass.setFont(new Font("楷体_GB2312", Font.PLAIN, 14));
		Pass.setEchoChar('*');
		Pass.setBounds(187, 150, 173, 29);
		frame.getContentPane().add(Pass);
		
		JLabel label = new JLabel("\u6635\u79F0:");
		label.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label.setBounds(81, 41, 82, 29);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u6CE8\u518C");
		
		button.addMouseListener(new MouseAdapter() {
			@Override
//			注册的点击事件
			public void mouseClicked(MouseEvent e) {
//				取值
				String strname=nickname.getText();
				String strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
				char [] pass1=Pass1.getPassword();
				String strpass1=String.valueOf(pass1);
				
//	调用register
	RegisterService reg=new RegisterServiceImpl();
				boolean result=reg.register(strname, strtel, strpass,strpass1);
				if (result==true) {
					JOptionPane.showMessageDialog(null, "注册成功");
					
		LoginView view=new LoginView(strtel);
					frame.setVisible(false);
					view.frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "注册失败");
					nickname.setText("");
					Tel.setText("");
					Pass.setText("");
					Pass1.setText("");
				}
				
			}
		});
		button.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		button.setBounds(167, 279, 152, 47);
		frame.getContentPane().add(button);
		
		Pass1 = new JPasswordField();
		Pass1.setFont(new Font("楷体_GB2312", Font.PLAIN, 14));
		Pass1.setEchoChar('*');
		Pass1.setBounds(187, 208, 173, 29);
		frame.getContentPane().add(Pass1);
		
		lblPp = new JLabel("PP");
		lblPp.setForeground(Color.ORANGE);
		lblPp.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 40));
		lblPp.setBounds(10, 10, 75, 47);
		frame.getContentPane().add(lblPp);
		
		label_1 = new JLabel("\u624B\u673A\u53F7:");
		label_1.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label_1.setBounds(81, 94, 82, 29);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u5BC6\u7801:");
		label_2.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label_2.setBounds(81, 148, 82, 29);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		label_3.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label_3.setBounds(81, 206, 96, 29);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("\u8BF7\u8F93\u5165\u5C0F\u4E8E8\u4F4D\u7684\u6635\u79F0");
		label_4.setForeground(Color.RED);
		label_4.setBounds(187, 71, 190, 15);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("\u8BF7\u8F93\u516511\u4F4D\u7684\u7535\u8BDD\u53F7\u7801");
		label_5.setForeground(Color.RED);
		label_5.setBounds(187, 125, 190, 15);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("\u8BF7\u8F93\u5165\u5927\u4E8E8\u4F4D\u5C0F\u4E8E16\u4F4D\u7684\u5BC6\u7801");
		label_6.setForeground(Color.RED);
		label_6.setBounds(187, 183, 190, 15);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("\u8BF7\u786E\u8BA4\u60A8\u7684\u5BC6\u7801");
		label_7.setForeground(Color.RED);
		label_7.setBounds(187, 239, 190, 15);
		frame.getContentPane().add(label_7);
		
	}

}
