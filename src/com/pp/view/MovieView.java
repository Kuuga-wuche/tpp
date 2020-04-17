package com.pp.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.service.MovieService;
import com.pp.service.impl.MovieServiceImpl;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieView extends JPanel {
	private JTextField searchBox;
	private JTable table;
	private JButton searchButton;
	private JTextPane info;

	
	

	/**
	 * Create the panel.
	 */
	public MovieView() {
			setSize(690, 508);
			setLayout(null);
			
			searchBox = new JTextField();
			searchBox.setFont(new Font("����_GB2312", Font.BOLD, 20));
			searchBox.setColumns(10);
			searchBox.setBounds(10, 10, 549, 35);
			add(searchBox);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 55, 680, 181);
			add(scrollPane);
			
			table = new JTable();
			table.setFont(new Font("����_GB2312", Font.PLAIN, 18));
			table.addMouseListener(new MouseAdapter() {
				
				@Override
				
//table �ĵ���¼�
				//���ĳһ��Ӱ����ʾ��Ӱ��Ϣ
				public void mouseClicked(MouseEvent e) {
					//ȡֵ
					//ȡ�㵽���к�
					int rowId = table.getSelectedRow();
		//��Ӱ�������ݵ㵽���к�ȡ��һ�е�����,����Ӱ��
					String mname = String.valueOf(table.getValueAt(rowId, 0));
					
					//���ݵ�Ӱ����movie����ȡ  ������Ϣ
							//�����Ǿ�ȷ��ѯ
					MovieService movieService = new MovieServiceImpl();
					ArrayList<Movie> list = movieService.selectMovieByMname(mname);
	//��Ϊ������Ϣ������ʾ��Ϣ�����Բ���Ҫ�ػ�model
		//��Ϊȷ��list��ֻ��һ�����ݣ�����Ҳ����Ҫforѭ��
					Movie m = list.get(0);					
					info.setText(m.getMinfo());
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
					{null},
				},
				new String[] {
					"\u7535\u5F71"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false
				};
				@Override
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			scrollPane.setViewportView(table);
			
			searchButton = new JButton("\u641C\u7D22");
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			searchButton.addMouseListener(new MouseAdapter() {
				@Override
//����	��ť����¼�
				//��������ĵ�Ӱ���ֲ�ѯ
				public void mouseClicked(MouseEvent e) {
					//ȡֵ
					String mname = searchBox.getText();
					
					MovieService movieService = new MovieServiceImpl();
					ArrayList<Movie> list = movieService.selectMovieLikeMname(mname);
					//�ж�list
					if(list==null || list.size()==0){
						return ;						
					}else{
						//��list��ȡ��Movie������ȡ����Ӱ����mname�ŵ�model��Ӧ��λ����
						//1,��model
						String [] titles = {"��Ӱ"};
						int rowCount = list.size();
						DefaultTableModel dtm = new DefaultTableModel(titles, rowCount);
						//2,��model�ŵ�table��
						table.setModel(dtm);
						//3,�����ݴ�ArrayList��ȡ�����ŵ�model��
						for(int i=0; i<list.size(); i++){
							Movie m = list.get(i);
																	
							dtm.setValueAt(m.getMname(), i, 0);
						}
					}
				}
			});
			searchButton.setFont(new Font("����_GB2312", Font.BOLD, 15));
			searchButton.setForeground(Color.RED);
			searchButton.setBounds(569, 5, 111, 45);
			add(searchButton);
			
			JButton selectButton = new JButton("\u7279\u60E0\u9009\u5EA7");
			selectButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			selectButton.addMouseListener(new MouseAdapter() {
				@Override
/*
 * //�ػ�ѡ��     ��ť      �ĵ���¼� 
//panel֮����л�--
								
		//��BUG������������������������������������������������������������������������������������������
				*/
				//----------�ѽ��������������������������������������������������
				
				public void mouseClicked(MouseEvent e) {
					//ȡ�㵽���к�
					int rowId = table.getSelectedRow();
		//��Ӱ�������ݵ㵽���к�ȡ��һ�е�����,����Ӱ��
					String mname = String.valueOf(table.getValueAt(rowId, 0));
				
//�½�Ҫ�л���panel�Ķ���
					MovieCinemaView movieCinemaView = new MovieCinemaView(mname);
					//�вι��죺��������֮�䴫ֵ�������������֮�䴫ֵ�����������ַ�������1�����췽����2��set get������
			
					
					
//�ѵ�¼���ʺŵ�uid����MovieCinemaView
					MovieView movieView = new MovieView();
					/*movieCinemaView.setLoggedUid(loggedUid2);*/
					
					
					
					
					//��ԭ���������ء�						
					MainView frame = MainView.getMainView();
					frame.setVisible(true);
					frame.changePanel(movieCinemaView);
					
					
//�ѱ�������ѡ�еĵ�Ӱ��ȡ�������Ա��¸�����panelʹ��
					
					/*String mname = searchBox.getText();*/
					//����һ����������ʾ
					
					

					

					
				}
			});
			selectButton.setForeground(Color.RED);
			selectButton.setFont(new Font("����_GB2312", Font.BOLD, 20));
			selectButton.setBounds(259, 433, 169, 61);
			add(selectButton);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 244, 680, 179);
			add(scrollPane_1);
			
			info = new JTextPane();
			info.setEditable(false);
			info.setFont(new Font("����_GB2312", Font.PLAIN, 20));
			scrollPane_1.setViewportView(info);
			
			
			
			
			
			
			
//����������������������������������������������������������������������������������������������������������������������������
			//��Ӱ����һ���־���ʾ���еĵ�Ӱ��Ϣ
			//������ 	����¼��еĴ��븴�ƹ�����mname����Ϊ��

			
			String mname = "";
			
			MovieService movieService = new MovieServiceImpl();
			ArrayList<Movie> list = movieService.selectMovieLikeMname(mname);
			//�ж�list
			if(list==null || list.size()==0){
				return ;						
			}else{
				//��list��ȡ��Movie������ȡ����Ӱ����mname�ŵ�model��Ӧ��λ����
				//1,��model
				String [] titles = {"��Ӱ"};
				int rowCount = list.size();
				DefaultTableModel dtm = new DefaultTableModel(titles, rowCount);
				//2,��model�ŵ�table��
				table.setModel(dtm);
				//3,�����ݴ�ArrayList��ȡ�����ŵ�model��
				for(int i=0; i<list.size(); i++){
					Movie m = list.get(i);
															
					dtm.setValueAt(m.getMname(), i, 0);
				}
			}
				
	}
	
}
