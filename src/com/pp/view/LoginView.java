package com.pp.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import com.pp.bean.LoggedInfo;
import com.pp.bean.UserInfo;
import com.pp.service.LoginService;
import com.pp.service.MovieService;
import com.pp.service.RegisterService;
import com.pp.service.impl.LoginServiceImpl;
import com.pp.service.impl.MovieServiceImpl;
import com.pp.service.impl.RegisterServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	public JFrame frame;
	private JTextField Tel;
	private JPasswordField Pass;

	
	private static int lid = 1;//�Ѵ˷����Ĳ���lid����Ϊ�̶���;
		
	private static String strTel="";//���ԣ�Ӧ�ô�ֵ��	�ҵ�	����

	/*//�û� id����������¼���洫��ѡ������
		private int loggedUid;
		
		public int getLoggedUid() {
			return loggedUid;
		}
		public void setLoggedUid(int loggedUid) {
			this.loggedUid = loggedUid;
		}*/
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//3.1:�Ȳ�ѯ�Ƿ��Ѿ���¼
					LoginService loginService = new LoginServiceImpl();
					
					ArrayList<LoggedInfo> list2 = loginService.selectLoggedInfo(lid);
					//�����ݶ����LoggedInfo�����ԣ������LoggedInfo�� û�����ݣ���˵����û�е�¼���Ǿ�ͣ���ڵ�¼����
					//����Ļ�����ת��������
					if(list2 == null || list2.size()==0){
						
						
						LoginView window = new LoginView(strTel);//����Ӧ�����޲ι���ģ�ֻ�Ǹտ�ʼֻ�������вι��죬�ܶ෽����д���вι������ˡ�
						window.frame.setVisible(true);
						
						
					}else{	
						
						JOptionPane.showMessageDialog(null, "���ѵ�¼");
			//���������ݿ����ѵ�¼�û���Ϣ�Ļ���������������ļ�������Ĺ��췽�����ǲ��ǾͲ���Ҫ�в����������ѵ�¼��Ϣ�Ĳ����ˣ����������������ǵģ�����
						
						MainView  mainView = MainView.getMainView();
						//�л���MainView
						mainView.setVisible(true);
						MovieView movieView = new MovieView();
						mainView.changePanel(movieView);
					//���ص�¼����
						/*frame.setVisible(false);*///��Ϊ������û�д򿪵�¼���棬frame�ǲ����ڵģ����Բ���Ҫ����Ϊ���ء�
				
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */			//****************
	
	//�޲ι��졪������������		�ҵ�		�����¼�󲻻�ת�������档
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Tel = new JTextField();
		Tel.setColumns(10);
		Tel.setBounds(134, 81, 190, 31);
		frame.getContentPane().add(Tel);
	
		
		
		Pass = new JPasswordField();
		Pass.setEchoChar('*');
		Pass.setBounds(134, 141, 190, 31);
		frame.getContentPane().add(Pass);
		
		JLabel lblPp = new JLabel("PP");
		lblPp.setFont(new Font("����_GB2312", Font.BOLD | Font.ITALIC, 40));
		lblPp.setForeground(Color.ORANGE);
		lblPp.setBounds(10, 10, 75, 47);
		frame.getContentPane().add(lblPp);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(72, 85, 41, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(72, 149, 41, 15);
		frame.getContentPane().add(label_1);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
// ��¼�е�¼����¼�����
			public void mouseClicked(MouseEvent e) {
				// ȡֵ
				String strtel = Tel.getText();
				char[] pass = Pass.getPassword();
				String strpass = String.valueOf(pass);

				LoginService log = new LoginServiceImpl();
				boolean result = log.selectUser(strtel, strpass);
				if (result == true) {

					// �����ѵ�¼���ʺ�loggedUid2ȡ�����Ӧ�ĵ绰tel���û���uname������ �ҵ� my������ȥ��
					LoginService loginService = new LoginServiceImpl();
					ArrayList<UserInfo> list = loginService
							.selectUserInfoByTel(strtel);
					if (list == null || list.size() == 0) {
						return;
					}
					UserInfo u = list.get(0);
					String tel = u.getTel();
					String uname = u.getUname();

					int loggedUid2 = u.getUid();
					// ������ 3���������ݿ����ѵ�¼�û�����Ϣ

					boolean result2 = loginService.insetLoggedInfo(lid,
							loggedUid2);
					
//if �ж�����Ӧ��дʲô������������������������������������������������������
/*
					if (result2 == true) {// �����õ�
						System.out.println("���浽�ѵ�¼�û���Ϣ����	�ɹ�");//Ϊʲô�ڿ���̨�л�������Σ���
						//ִ�������飿
					} else {
						System.out.println("���浽�ѵ�¼�û���Ϣ����	ʧ��");
					}

					System.out.println("LoginView��		��½�û���uid��		" + loggedUid2);*/
					
					
			//��Ϊ�޲ι���ֻ����		�ҵ�		�����е��õģ�Ϊ�˴ﵽ��¼����Ȼͣ����ԭ���Ľ����Ч��������Ҫ���½�������
					/*// 
					MainView mainView = MainView.getMainView();
					// �л���MainView
					mainView.setVisible(true);
					MovieView movieView = new MovieView();
					mainView.changePanel(movieView);*/
					
					
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
					// ���ص�¼����
					frame.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "��¼ʧ��");
				}
			}
		});
		loginButton.setBounds(72, 248, 102, 31);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			
//��¼���е�ע����
			
			public void mouseClicked(MouseEvent e) {
/*//				ȡֵ
				String Strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
//				����loginservice
				LoginService log=new LoginServiceImpl();
				boolean result=log.selectUser(Strtel, strpass);
				if (result==true) {*/
					RegisterView view=new RegisterView();
					frame.setVisible(false);
					view.frame.setVisible(true);
				/*}*/
			}
		});
		registerButton.setBounds(251, 248, 102, 31);
		frame.getContentPane().add(registerButton);
	}
	
	
	
	
	
		
	
	
//�вι��죺������ע�������ת����ʱ���и�ע���	�ʺţ�tel��
	
	
	
	
	public LoginView(String strtel) {
		initialize( strtel);
	}

/*	*//**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String strtel) {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Tel = new JTextField();
		Tel.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		Tel.setColumns(10);
		Tel.setBounds(134, 81, 190, 31);
		frame.getContentPane().add(Tel);
Tel.setText(strtel);
		
		
		
		Pass = new JPasswordField();
		Pass.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		Pass.setEchoChar('*');
		Pass.setBounds(134, 141, 190, 31);
		frame.getContentPane().add(Pass);
		
		JLabel lblPp = new JLabel("PP");
		lblPp.setFont(new Font("����_GB2312", Font.BOLD | Font.ITALIC, 40));
		lblPp.setForeground(Color.ORANGE);
		lblPp.setBounds(10, 10, 75, 47);
		frame.getContentPane().add(lblPp);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
//��¼�е�¼����¼�����
			public void mouseClicked(MouseEvent e) {
//				ȡֵ
				String strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
				
				LoginService log=new LoginServiceImpl();
		boolean result=log.selectUser(strtel, strpass);
				if (result==true) {	

					
					//�����ѵ�¼���ʺ�loggedUid2ȡ�����Ӧ�ĵ绰tel���û���uname������		�ҵ�	my������ȥ��
					LoginService loginService = new LoginServiceImpl();
					ArrayList<UserInfo> list = loginService.selectUserInfoByTel(strtel);
					if(list==null || list.size()==0){
							return;
					}
					UserInfo u = list.get(0);
					String tel = u.getTel();
					String uname = u.getUname();
					
			int loggedUid2 = u.getUid();
//������	3���������ݿ����ѵ�¼�û�����Ϣ
					
			boolean result2 = loginService.insetLoggedInfo(lid, loggedUid2);
			
			
			if(result2==true){//�����õ�
			/*	System.out.println("���浽�ѵ�¼�û���Ϣ����	�ɹ�");*/
			}else{
				System.out.println("���浽�ѵ�¼�û���Ϣ����	ʧ��");
			}
			
					
					
					/*
//					��������1,��ֵ��	�ҵ�		����					
MyView myView = new MyView(loggedUid2,tel,uname);//���ԣ����췽�������������л�����ʱ�õģ�
//�����ﲢ�����л���	�ҵ�	���棬�����л���	�����棬����ʱ�����ݹ�ȥ��û���õģ���Ϊ���������Ǵ�������ת���ҵĽ���ģ�����ʱ��û�д����ݹ�ȥ�������ҵĽ��治����������ʾ��

*/
					/*MovieService movieService =new MovieServiceImpl();
					ArrayList<UserInfo> list = movieService.selectUserInfoByUid(loggedUid2);
					if(list==null || list.size()==0){
						System.out.println("��");
						return;
					}
					UserInfo u = list.get(0);
					String tel = u.getTel();
					String uname = u.getUname();	*/
					
					
//�л���MainView
					
//�ѵ�¼���ʺŵ�uid����MainView
					//���ݵ�¼���ʺ���UserInfo�в��Ҷ�Ӧ��uid
					/*LoginService loginService = new LoginServiceImpl();
					
					ArrayList<UserInfo> list = loginService.selectUserInfoByTel(strtel);
					if(list==null || list.size()==0){
						System.out.println(0);
						return ;
					}
					UserInfo u = list.get(0);*/
					
		
	/*System.out.println(uid);
					MainView.setLoggedUid(uid);
					
		
	System.out.println("��¼��   "+MainView.getLoggedUid());*/
					
			
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			
			
	/*System.out.println("LoginView��		��½�û���uid��		"+loggedUid2);*/
	//��������MainView�������Ƶ�����
	MainView  mainView = MainView.getMainView();
					//�л���MainView
					mainView.setVisible(true);
					MovieView movieView = new MovieView();
					mainView.changePanel(movieView);
				//���ص�¼����
					frame.setVisible(false);

				}
				else {
					JOptionPane.showMessageDialog(null, "��¼ʧ��");
				}
			}
		});
		loginButton.setBounds(72, 232, 102, 47);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
//	��¼���е�	ע��	���
			public void mouseClicked(MouseEvent e) {
/*//				ȡֵ
				String Strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
//				����loginservice
				LoginService log=new LoginServiceImpl();
				boolean result=log.selectUser(Strtel, strpass);
				if (result==true) {*/
					RegisterView registerView=new RegisterView();
					frame.setVisible(false);
					registerView.frame.setVisible(true);
				/*}*/
			}
		});
		registerButton.setBounds(251, 232, 102, 47);
		frame.getContentPane().add(registerButton);
		
		JLabel label = new JLabel("\u624B\u673A\u53F7:");
		label.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		label.setBounds(42, 83, 82, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		label_1.setBounds(42, 140, 82, 29);
		frame.getContentPane().add(label_1);
	}
}
