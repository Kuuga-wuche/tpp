package com.pp.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;
import com.pp.dao.LoggedInfoDao;
import com.pp.dao.impl.LoggedInfoDaoImpl;
import com.pp.service.LoginService;
import com.pp.service.MovieService;
import com.pp.service.impl.LoginServiceImpl;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateInfoView {

	public JFrame frame;		//���Ҫ����Ϊ���еģ�������в��ܵ���
									//��������updateInfoView.frame.setVisible(true);
	private JTextField updateTel;
	private JTextField updatename;
	private JTextField textField_4;
	private JPasswordField oldPasswordT;

	
	private int lid=1;
	private JPasswordField newPassword1T;
	private JPasswordField newPassword2T;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UpdateInfoView window = new UpdateInfoView();
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
	public UpdateInfoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 511, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("���Ŀ���", Font.BOLD, 40));
		label.setBounds(128, 0, 264, 46);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u7535\u8BDD\u53F7\uFF1A\r\n");
		lblNewLabel.setFont(new Font("����_GB2312", Font.BOLD, 18));
		lblNewLabel.setBounds(24, 66, 95, 21);
		frame.getContentPane().add(lblNewLabel);
		
		updateTel = new JTextField();
		updateTel.setEditable(false);
		updateTel.setBounds(141, 65, 239, 28);
		frame.getContentPane().add(updateTel);
		updateTel.setColumns(10);
		

		updatename = new JTextField();
		updatename.setBounds(141, 103, 239, 28);
		frame.getContentPane().add(updatename);
		updatename.setColumns(10);
//ת���˽���ʱ 	����	�ѵ�¼�ʻ����ֻ���
	
//ת���˽���ʱ 	����	�ѵ�¼�ʻ����ǳ�
		LoginService loginService = new LoginServiceImpl();	
		
		ArrayList<UserInfo> list = loginService.selectLoggedInfoAndUserInfo(lid);
		
		
		
		
		if(list==null || list.size()==0){
			JOptionPane.showMessageDialog(null, "����δ��¼");
		}else{
			
			UserInfo u = list.get(0);
			String tel = u.getTel();
			String uname = u.getUname();
	updateTel.setText(tel);
	updatename.setText(uname);		
		}
		

		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 238, 9, 0);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		oldPasswordT = new JPasswordField();
		oldPasswordT.setBounds(140, 141, 239, 29);
		frame.getContentPane().add(oldPasswordT);
		
		JButton updateButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
//ȷ���޸�		��ť�ĵ���¼�
			
			public void mouseClicked(MouseEvent e) {
				//ȡֵ
				String tel = updateTel.getText();
				String uname = updatename.getText();
				
				char [] oldPasswordes = oldPasswordT.getPassword();
				String oldPassword  = String.valueOf(oldPasswordes);
				
				char [] newPassword1es = newPassword1T.getPassword();
				String newPassword1  = String.valueOf(newPassword1es);
				
				char [] newPassword2es = newPassword2T.getPassword();
				String newPassword2 = String.valueOf(newPassword2es);
//	
		MovieService movieService = new MovieServiceImpl();
				
	boolean result = movieService.updateUserInfoByTel(tel, uname,oldPassword,newPassword1,newPassword2 );
				if(result==true){
					JOptionPane.showMessageDialog(null, "�޸ĸ�����Ϣ�ɹ�");
				}else{
					JOptionPane.showMessageDialog(null, "�޸ĸ�����Ϣʧ��");
				}
			}
		});
		updateButton.setForeground(Color.BLUE);
		updateButton.setFont(new Font("����_GB2312", Font.BOLD, 20));
		updateButton.setBounds(42, 259, 183, 46);
		frame.getContentPane().add(updateButton);
		
		JButton cancelbutton = new JButton("\u53D6\u6D88");
		cancelbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelbutton.addMouseListener(new MouseAdapter() {
			@Override
//ȡ��	��ť�ĵ���¼�
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "ȷ�������ո��޸ĵ���Ϣ��");
				if(result==0){
					frame.setVisible(false);
				}
				
			}
		});
		cancelbutton.setForeground(Color.BLUE);
		cancelbutton.setFont(new Font("����_GB2312", Font.BOLD, 20));
		cancelbutton.setBounds(273, 259, 183, 44);
		frame.getContentPane().add(cancelbutton);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A\r\n");
		label_1.setFont(new Font("����_GB2312", Font.BOLD, 18));
		label_1.setBounds(24, 227, 95, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A\r\n");
		label_2.setFont(new Font("����_GB2312", Font.BOLD, 18));
		label_2.setBounds(24, 184, 95, 21);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u65E7\u5BC6\u7801\uFF1A\r\n");
		label_3.setFont(new Font("����_GB2312", Font.BOLD, 18));
		label_3.setBounds(24, 143, 95, 21);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u6635\u79F0\uFF1A\r\n");
		label_4.setFont(new Font("����_GB2312", Font.BOLD, 18));
		label_4.setBounds(24, 104, 95, 21);
		frame.getContentPane().add(label_4);
		
		newPassword1T = new JPasswordField();
		newPassword1T.setBounds(141, 180, 239, 29);
		frame.getContentPane().add(newPassword1T);
		
		newPassword2T = new JPasswordField();
		newPassword2T.setBounds(141, 219, 239, 29);
		frame.getContentPane().add(newPassword2T);
	}
}
