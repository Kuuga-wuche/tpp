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
		
/*//�ڹ��췽���е����ϸ�panel�ķ���::::��ʾMovieView����ѡ�еĵ�Ӱ���Լ������˵�Ӱ��ӰԺ	
		
		//��ת��������ʱ��ʾ��movieName������ʾ�ϸ�����ѡ�еĵ�Ӱ��
		//movieName��ֵ
		System.out.println(selectedMname);
		*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 82, 613, 132);
		add(scrollPane);
		
		
//1��XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXд������ᱨ����ָ���쳣XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX		
		/*//���ݵ�Ӱ������ʾ�����˵�Ӱ��ӰԺ
				MovieService movieService = new MovieServiceImpl();
				ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
				//��listȡ��ӰԺ���ŵ� table��
					//1,�ػ�model
				DefaultTableModel dtm = new DefaultTableModel(list.size(),1);
				table.setModel(dtm);
				for(int i=0; i<list.size(); i++){
					Cinema c = list.get(i);
								System.out.println(c.getAddr());
					dtm.setValueAt(c.getAddr(), i, 0);
				}	*/
		table = new JTable();
		table.setFont(new Font("����_GB2312", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {
			@Override
			
//����table�ĵ���¼�
			public void mouseClicked(MouseEvent e) {
//һ����ѯ�������ӰԺ����Ϣ
				//1,ȡֵ
				//ȡ�㵽���к�
				int rowId = table.getSelectedRow();
				//�����кţ����кţ�ȡ���ӰԺ��
				String cname = String.valueOf(table.getValueAt(rowId,0));
				
				//2,���ݵ�ӰԺ����ѯ��ӰԺ��Ϣ��				
		MovieService m =new MovieServiceImpl();
				ArrayList<Cinema> list = m.selectCinemaByCname(cname);
				//3,�ж�list
				if(list==null || list.size()==0){
					return ;
				}else{
					/*for(int i=0; i<list.size(); i++){
						Cinema c =list.get(i);
						
						String addr = c.getAddr();
						cinemaInfo.setText(addr);
					}*/
					
					
					//һ����ӰԺ����Ӧ��ֻ��һ�ҵ�ӰԺ�����list��ֻ��һ�����ݣ�����Ҫforѭ��
					Cinema c = list.get(0);
					String addr = c.getAddr();
					cinemaInfo.setText(addr);
				}
	
				
				
//�������ݵ�ӰԺ���͵�Ӱ����ѯ�˳��ε�ʱ�䡢�۸�
				ArrayList<PriceTimes> list2 = m.selectPriceTimesByMnameAndCname (selectedMname,cname);
//��һ��������ΪʲôҪ��selectedMname��final���أ�
				//list2��ֻ��һ�����ݣ�����Ҫдforѭ��
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
		movieName.setFont(new Font("����_GB2312", Font.BOLD, 20));
		movieName.setBounds(232, 10, 349, 48);
		add(movieName);
		movieName.setColumns(10);
//�ڴ˽������ʱ��ʾ�ϸ�������ѡ�еĵ�Ӱ����
		movieName.setText(selectedMname);

		JLabel label = new JLabel("\u7535\u5F71\uFF1A");
		label.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label.setBounds(122, 7, 75, 48);
		add(label);
		
		confirmButton = new JButton("\u786E\u8BA4");
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			
			
//ȷ��  ��Ʊ  ��ť�ĵ���¼�
			public void mouseClicked(MouseEvent e) {
			//table �� ��ѡ�е� ��ӰԺ��
				int rowId = table.getSelectedRow();
				//�����кţ����кţ�ȡ���ӰԺ��
				String cname = String.valueOf(table.getValueAt(rowId,0));
				
				
//��table�и��ƹ����ģ������
		MovieService m =new MovieServiceImpl();
		ArrayList<PriceTimes> list2 = m.selectPriceTimesByMnameAndCname (selectedMname,cname);
		PriceTimes pt = list2.get(0);
				
				SeatView seatView = new SeatView(selectedMname,cname, pt.getPtime(),pt.getPrice());
				
				
				
				
//�ѵ�¼���ʺŵ�uid����SeatView
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
		confirmButton.setFont(new Font("����_GB2312", Font.BOLD, 20));
		confirmButton.setBounds(243, 405, 169, 61);
		add(confirmButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(122, 247, 528, 36);
		add(scrollPane_1);
		
		cinemaInfo = new JTextPane();
		cinemaInfo.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		cinemaInfo.setEditable(false);
		scrollPane_1.setViewportView(cinemaInfo);
		
		timeT = new JTextPane();
		timeT.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		timeT.setEditable(false);
		timeT.setBounds(122, 293, 528, 36);
		add(timeT);
		
		priceT = new JTextPane();
		priceT.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		priceT.setEditable(false);
		priceT.setBounds(122, 339, 528, 36);
		add(priceT);
		
		JLabel label_1 = new JLabel("\u5730\u5740\uFF1A");
		label_1.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_1.setBounds(37, 247, 75, 36);
		add(label_1);
		
		label_2 = new JLabel("\u65F6\u95F4\uFF1A");
		label_2.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_2.setBounds(37, 293, 75, 36);
		add(label_2);
		
		label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setFont(new Font("����_GB2312", Font.BOLD, 20));
		label_3.setBounds(37, 339, 75, 36);
		add(label_3);
		
//3��XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX����д��Bug�������ܸ��ݲ�ѯ��������Ϣ����model������XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//���ݵ�Ӱ������ʾ�����˵�Ӱ��ӰԺ
		MovieService movieService = new MovieServiceImpl();
		ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
		//��listȡ��ӰԺ���ŵ� table��
		for(int i=0; i<list.size(); i++){
			Cinema c = list.get(i);
			
			table.setValueAt(c.getCname(), i, 0);
		}		
		

		
		
//2��XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX����д�����棬�����ʱ��û��Ӧ��������ʾʱ��ͼ۸�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		
		
		/*//���ݵ�Ӱ������ʾ�����˵�Ӱ��ӰԺ
				MovieService movieService = new MovieServiceImpl();
				ArrayList<Cinema> list = movieService.selectPriceTimesByMname(selectedMname);
				//��listȡ��ӰԺ���ŵ� table��
					//1,�ػ�model
				DefaultTableModel dtm = new DefaultTableModel(list.size(),1);
				table.setModel(dtm);
				for(int i=0; i<list.size(); i++){
					Cinema c = list.get(i);
								System.out.println(c.getAddr());
					dtm.setValueAt(c.getAddr(), i, 0);
				}	*/
	}
}
