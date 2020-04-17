package com.pp.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextPane;

import com.pp.bean.Cinema;
import com.pp.bean.PriceTimes;
import com.pp.service.MovieService;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovieCinemaView extends JPanel {
	private JTextField movieName;
	private JTable table;
	private JButton confirmButton ;
	private JTextPane cinemaInfo;
	private JTextPane timeT;
	private JTextPane priceT;
	private JLabel label_2;
	private JLabel label_3;

	
	

	/**
	 * Create the panel.
	 */

	public MovieCinemaView(final String selectedMname) {
		setSize(690, 508);
		setLayout(null);
		
/*//在构造方法中调用上个panel的方法::::显示MovieView界面选中的电影，以及包含此电影的影院	
		
		//跳转到本界面时显示在movieName框中显示上个界面选中的电影名
		//movieName框赋值
		System.out.println(selectedMname);
		*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 82, 613, 132);
		add(scrollPane);
		
		
//1，XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX写在上面会报错，空指针异常XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX		
		/*//根据电影名字显示包含此电影的影院
				MovieService movieService = new MovieServiceImpl();
				ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
				//从list取电影院名放到 table中
					//1,重画model
				DefaultTableModel dtm = new DefaultTableModel(list.size(),1);
				table.setModel(dtm);
				for(int i=0; i<list.size(); i++){
					Cinema c = list.get(i);
								System.out.println(c.getAddr());
					dtm.setValueAt(c.getAddr(), i, 0);
				}	*/
		table = new JTable();
		table.setFont(new Font("楷体_GB2312", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {
			@Override
			
//监听table的点击事件
			public void mouseClicked(MouseEvent e) {
//一，查询出所点击影院的信息
				//1,取值
				//取点到的行号
				int rowId = table.getSelectedRow();
				//根据行号（、列号）取其电影院名
				String cname = String.valueOf(table.getValueAt(rowId,0));
				
				//2,根据电影院名查询电影院信息，				
		MovieService m =new MovieServiceImpl();
				ArrayList<Cinema> list = m.selectCinemaByCname(cname);
				//3,判断list
				if(list==null || list.size()==0){
					return ;
				}else{
					/*for(int i=0; i<list.size(); i++){
						Cinema c =list.get(i);
						
						String addr = c.getAddr();
						cinemaInfo.setText(addr);
					}*/
					
					
					//一个电影院名对应的只有一家电影院，因此list中只有一条数据，不需要for循环
					Cinema c = list.get(0);
					String addr = c.getAddr();
					cinemaInfo.setText(addr);
				}
	
				
				
//二，根据电影院名和电影名查询此场次的时间、价格
				ArrayList<PriceTimes> list2 = m.selectPriceTimesByMnameAndCname (selectedMname,cname);
//上一个方法中为什么要求selectedMname是final的呢？
				//list2中只有一条数据，不需要写for循环
				PriceTimes pt = list2.get(0);
								
				timeT.setText(pt.getPtime());
				priceT.setText(String.valueOf(pt.getPrice()));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u8BF7\u9009\u62E9\u5F71\u9662\uFF1A"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		movieName = new JTextField();
		movieName.setEditable(false);
		movieName.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		movieName.setBounds(232, 10, 349, 48);
		add(movieName);
		movieName.setColumns(10);
//在此界面出现时显示上个界面中选中的电影名字
		movieName.setText(selectedMname);

		JLabel label = new JLabel("\u7535\u5F71\uFF1A");
		label.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label.setBounds(122, 7, 75, 48);
		add(label);
		
		confirmButton = new JButton("\u786E\u8BA4");
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
//确认  购票  按钮的点击事件
			public void mouseClicked(MouseEvent e) {
			//table 中 被选中的 电影院名
				int rowId = table.getSelectedRow();
				//根据行号（、列号）取其电影院名
				String cname = String.valueOf(table.getValueAt(rowId,0));
				
				
//从table中复制过来的，待理解
		MovieService m =new MovieServiceImpl();
		ArrayList<PriceTimes> list2 = m.selectPriceTimesByMnameAndCname (selectedMname,cname);
		PriceTimes pt = list2.get(0);
				
				SeatView seatView = new SeatView(selectedMname,cname, pt.getPtime(),pt.getPrice());
				
				
				
				
//把登录的帐号的uid传给SeatView
				/*seatView.setLoggedUid();*/
				
				
				
				MainView mainView = MainView.getMainView();
				mainView.setVisible(true);
				mainView.changePanel(seatView);
			}
		});
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		confirmButton.setForeground(Color.RED);
		confirmButton.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		confirmButton.setBounds(243, 405, 169, 61);
		add(confirmButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(122, 247, 528, 36);
		add(scrollPane_1);
		
		cinemaInfo = new JTextPane();
		cinemaInfo.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		cinemaInfo.setEditable(false);
		scrollPane_1.setViewportView(cinemaInfo);
		
		timeT = new JTextPane();
		timeT.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		timeT.setEditable(false);
		timeT.setBounds(122, 293, 528, 36);
		add(timeT);
		
		priceT = new JTextPane();
		priceT.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
		priceT.setEditable(false);
		priceT.setBounds(122, 339, 528, 36);
		add(priceT);
		
		JLabel label_1 = new JLabel("\u5730\u5740\uFF1A");
		label_1.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label_1.setBounds(37, 247, 75, 36);
		add(label_1);
		
		label_2 = new JLabel("\u65F6\u95F4\uFF1A");
		label_2.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label_2.setBounds(37, 293, 75, 36);
		add(label_2);
		
		label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setFont(new Font("楷体_GB2312", Font.BOLD, 20));
		label_3.setBounds(37, 339, 75, 36);
		add(label_3);
		
//3，XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX这样写有Bug：：不能根据查询出来的信息调整model的行数XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//根据电影名字显示包含此电影的影院
		MovieService movieService = new MovieServiceImpl();
		ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
		//从list取电影院名放到 table中
		for(int i=0; i<list.size(); i++){
			Cinema c = list.get(i);
			
			table.setValueAt(c.getCname(), i, 0);
		}		
		

		
		
//2，XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX，，写在下面，点击的时候没反应，不会显示时间和价格XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		
		
		/*//根据电影名字显示包含此电影的影院
				MovieService movieService = new MovieServiceImpl();
				ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
				//从list取电影院名放到 table中
					//1,重画model
				DefaultTableModel dtm = new DefaultTableModel(list.size(),1);
				table.setModel(dtm);
				for(int i=0; i<list.size(); i++){
					Cinema c = list.get(i);
								System.out.println(c.getAddr());
					dtm.setValueAt(c.getAddr(), i, 0);
				}	*/
	}
}
