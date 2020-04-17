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

	
	private static int lid = 1;//把此方法的参数lid设置为固定的;
		
	private static String strTel="";//不对，应该传值到	我的	界面

	/*//用户 id————登录界面传到选座界面
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
					//3.1:先查询是否已经登录
					LoginService loginService = new LoginServiceImpl();
					
					ArrayList<LoggedInfo> list2 = loginService.selectLoggedInfo(lid);
					//（根据定义的LoggedInfo的特性），如果LoggedInfo中 没有数据，就说明还没有登录，那就停留在登录界面
					//否则的话，就转到主界面
					if(list2 == null || list2.size()==0){
						
						
						LoginView window = new LoginView(strTel);//这里应该用无参构造的，只是刚开始只创建了有参构造，很多方法都写在有参构造里了。
						window.frame.setVisible(true);
						
						
					}else{	
						
						JOptionPane.showMessageDialog(null, "您已登录");
			//换了用数据库存放已登录用户信息的话，主界面和其他的几个界面的构造方法中是不是就不需要有参数来传递已登录信息的参数了？？？？————是的！！！
						
						MainView  mainView = MainView.getMainView();
						//切换到MainView
						mainView.setVisible(true);
						MovieView movieView = new MovieView();
						mainView.changePanel(movieView);
					//隐藏登录界面
						/*frame.setVisible(false);*///因为根本就没有打开登录界面，frame是不存在的，所以不需要设置为隐藏。
				
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
	
	//无参构造——————在		我的		界面登录后不会转到主界面。
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
		lblPp.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 40));
		lblPp.setForeground(Color.ORANGE);
		lblPp.setBounds(10, 10, 75, 47);
		frame.getContentPane().add(lblPp);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(72, 85, 41, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
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
// 登录中登录点击事件处理
			public void mouseClicked(MouseEvent e) {
				// 取值
				String strtel = Tel.getText();
				char[] pass = Pass.getPassword();
				String strpass = String.valueOf(pass);

				LoginService log = new LoginServiceImpl();
				boolean result = log.selectUser(strtel, strpass);
				if (result == true) {

					// 根据已登录的帐号loggedUid2取其相对应的电话tel和用户名uname，传到 我的 my界面中去。
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
					// 方案三 3：创建数据库存放已登录用户的信息

					boolean result2 = loginService.insetLoggedInfo(lid,
							loggedUid2);
					
//if 判断里面应该写什么？？？？？？？？？？？？？？？？？？？？？？？？？？？
/*
					if (result2 == true) {// 测试用的
						System.out.println("保存到已登录用户信息表中	成功");//为什么在控制台中会输出两次？？
						//执行了两遍？
					} else {
						System.out.println("保存到已登录用户信息表中	失败");
					}

					System.out.println("LoginView中		登陆用户的uid：		" + loggedUid2);*/
					
					
			//因为无参构造只是在		我的		界面中调用的，为了达到登录后依然停留在原来的界面的效果，不需要再新建主界面
					/*// 
					MainView mainView = MainView.getMainView();
					// 切换到MainView
					mainView.setVisible(true);
					MovieView movieView = new MovieView();
					mainView.changePanel(movieView);*/
					
					
					JOptionPane.showMessageDialog(null, "登录成功");
					// 隐藏登录界面
					frame.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "登录失败");
				}
			}
		});
		loginButton.setBounds(72, 248, 102, 31);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			
//登录表中的注册监控
			
			public void mouseClicked(MouseEvent e) {
/*//				取值
				String Strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
//				调用loginservice
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
	
	
	
	
	
		
	
	
//有参构造：：：从注册界面跳转过来时带有刚注册的	帐号（tel）
	
	
	
	
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
		Tel.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		Tel.setColumns(10);
		Tel.setBounds(134, 81, 190, 31);
		frame.getContentPane().add(Tel);
Tel.setText(strtel);
		
		
		
		Pass = new JPasswordField();
		Pass.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		Pass.setEchoChar('*');
		Pass.setBounds(134, 141, 190, 31);
		frame.getContentPane().add(Pass);
		
		JLabel lblPp = new JLabel("PP");
		lblPp.setFont(new Font("楷体_GB2312", Font.BOLD | Font.ITALIC, 40));
		lblPp.setForeground(Color.ORANGE);
		lblPp.setBounds(10, 10, 75, 47);
		frame.getContentPane().add(lblPp);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
//登录中登录点击事件处理
			public void mouseClicked(MouseEvent e) {
//				取值
				String strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
				
				LoginService log=new LoginServiceImpl();
		boolean result=log.selectUser(strtel, strpass);
				if (result==true) {	

					
					//根据已登录的帐号loggedUid2取其相对应的电话tel和用户名uname，传到		我的	my界面中去。
					LoginService loginService = new LoginServiceImpl();
					ArrayList<UserInfo> list = loginService.selectUserInfoByTel(strtel);
					if(list==null || list.size()==0){
							return;
					}
					UserInfo u = list.get(0);
					String tel = u.getTel();
					String uname = u.getUname();
					
			int loggedUid2 = u.getUid();
//方案三	3：创建数据库存放已登录用户的信息
					
			boolean result2 = loginService.insetLoggedInfo(lid, loggedUid2);
			
			
			if(result2==true){//测试用的
			/*	System.out.println("保存到已登录用户信息表中	成功");*/
			}else{
				System.out.println("保存到已登录用户信息表中	失败");
			}
			
					
					
					/*
//					方案二．1,传值到	我的		界面					
MyView myView = new MyView(loggedUid2,tel,uname);//不对，构造方法传数据是在切换界面时用的，
//但这里并不是切换到	我的	界面，而是切换到	主界面，，此时传数据过去是没有用的，因为接下来都是从主界面转到我的界面的，但那时都没有传数据过去，所以我的界面不会有数据显示。

*/
					/*MovieService movieService =new MovieServiceImpl();
					ArrayList<UserInfo> list = movieService.selectUserInfoByUid(loggedUid2);
					if(list==null || list.size()==0){
						System.out.println("空");
						return;
					}
					UserInfo u = list.get(0);
					String tel = u.getTel();
					String uname = u.getUname();	*/
					
					
//切换到MainView
					
//把登录的帐号的uid传给MainView
					//根据登录的帐号在UserInfo中查找对应的uid
					/*LoginService loginService = new LoginServiceImpl();
					
					ArrayList<UserInfo> list = loginService.selectUserInfoByTel(strtel);
					if(list==null || list.size()==0){
						System.out.println(0);
						return ;
					}
					UserInfo u = list.get(0);*/
					
		
	/*System.out.println(uid);
					MainView.setLoggedUid(uid);
					
		
	System.out.println("登录中   "+MainView.getLoggedUid());*/
					
			
			JOptionPane.showMessageDialog(null, "登录成功");
			
			
	/*System.out.println("LoginView中		登陆用户的uid：		"+loggedUid2);*/
	//调整：把MainView从上面移到这里
	MainView  mainView = MainView.getMainView();
					//切换到MainView
					mainView.setVisible(true);
					MovieView movieView = new MovieView();
					mainView.changePanel(movieView);
				//隐藏登录界面
					frame.setVisible(false);

				}
				else {
					JOptionPane.showMessageDialog(null, "登录失败");
				}
			}
		});
		loginButton.setBounds(72, 232, 102, 47);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
//	登录表中的	注册	监控
			public void mouseClicked(MouseEvent e) {
/*//				取值
				String Strtel=Tel.getText();
				char [] pass=Pass.getPassword();
				String strpass=String.valueOf(pass);
//				调用loginservice
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
		label.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label.setBounds(42, 83, 82, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		label_1.setBounds(42, 140, 82, 29);
		frame.getContentPane().add(label_1);
	}
}
