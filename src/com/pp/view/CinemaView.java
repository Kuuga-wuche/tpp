package com.pp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import com.pp.bean.Cinema;
import com.pp.bean.Movie;
import com.pp.service.CinemaService;
import com.pp.service.impl.CinemaServiceImpl;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CinemaView extends JPanel {
	public JFrame frame;
	private JTextField searchBox;
	private JTable table;
	private JTextPane Info;
	private JButton searchButton;
	private JButton selectButton;
	private JPanel oldPanel;

	/**
	 * Create the panel.
	 */

	public CinemaView() {
		setSize(690, 508);
		setLayout(null);

		searchBox = new JTextField();
		searchBox.setFont(new Font("����_GB2312", Font.BOLD, 20));
		searchBox.setBounds(10, 10, 549, 35);
		add(searchBox);
		searchBox.setColumns(10);

		searchButton = new JButton("\u641C\u7D22");
		searchButton.addMouseListener(new MouseAdapter() {

			// ������ť�ĵ���¼�
			// ���ݵ�ӰԺ��������
			@Override
			public void mouseClicked(MouseEvent e) {
				// ȡ��Ժ����
				String strname = searchBox.getText();

				CinemaService service = new CinemaServiceImpl();
				ArrayList<Cinema> list = service
						.selectCinemaServicelikeByCname(strname);
				if ((list == null) || list.size() == 0) {
					return;
				}

				// ��model
				// ��ͷ
				String[] title = { "ӰԺ" };

				int rowcount = list.size();
				// new model
				DefaultTableModel dtm = new DefaultTableModel(title, rowcount);
				// model�ŵ�table��
				table.setModel(dtm);
				// forѭ��
				for (int i = 0; i < list.size(); i++) {

					Cinema cinema = list.get(i);
					// ȡֵ
					String cname = cinema.getCname();

					// ��ֵ
					dtm.setValueAt(cname, i, 0);

				}

			}
		});
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		searchButton.setForeground(Color.RED);
		searchButton.setFont(new Font("����_GB2312", Font.BOLD, 15));
		searchButton.setBounds(569, 5, 123, 45);
		add(searchButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 680, 181);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("����_GB2312", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {

			// table�ĵ���¼�System.out.println(sql);
			@Override
			public void mouseClicked(MouseEvent e) {
				// ȡ��
				int rowid = table.getSelectedRow();

				// Object rid= table.getValueAt(rowid, 0);
				// ת������
				String cname = String.valueOf(table.getValueAt(rowid, 0));
				// String cname1=String.valueOf(table.getValueAt(rowid, 0));
				// new
				CinemaService service = new CinemaServiceImpl();
				ArrayList<Cinema> list = service
						.selectCinemaServiceByaddr(cname);
				if ((list == null) || (list.size() == 0)) {
					return;
				}

				// ȡֵ
				Cinema cinema = list.get(0);
				String addr = cinema.getAddr();
				String name = cinema.getCname();

				// �ŵ��ı�����
				Info.setText(addr);

			}

		});
		table.setModel(new DefaultTableModel(new Object[][] { { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, },
				new String[] { "\u5F71\u9662" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(632);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 244, 680, 179);
		add(scrollPane_1);

		Info = new JTextPane();
		Info.setFont(new Font("����_GB2312", Font.PLAIN, 20));
		Info.setEditable(false);
		scrollPane_1.setViewportView(Info);

		selectButton = new JButton("\u7279\u60E0\u9009\u5EA7");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		selectButton.addMouseListener(new MouseAdapter() {

			// �ػ�ѡ��
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * CinemaMovieView cmv=new CinemaMovieView(); changePanel(cmv);
				 * cmv.setVisible(ture); cmv. frame.setVisible(false);
				 */

				// �ڵ���ػ�ѡ���� �ڳ��ֵ��¸��������ѳ��������ֵ
				// ����Ҫ�ڸ����������ֵ
				int rowid = table.getSelectedRow();
				String cname = String.valueOf(table.getValueAt(rowid, 0));

				// ��newҪ��ת��ҳ���panel
				// ��new����ʱ�Ͱ�ֵ��������
				CinemaMovieView cmv = new CinemaMovieView(cname);
				// ��new������
				/* MainView mv=new MainView(); */
				MainView mv = MainView.getMainView();
				// ��ʾ������
				mv.setVisible(true);
				// ��panel�ŵ���������
				mv.changePanel(cmv);

			}
		});
		selectButton.setForeground(Color.RED);
		selectButton.setFont(new Font("����_GB2312", Font.BOLD, 20));
		selectButton.setBounds(259, 433, 169, 61);
		add(selectButton);
		
		
		
		
		
		
//����������������������������������������������������������������������������������������������������������������������������
		//ӰԺ����һ���־���ʾ���еĵ�Ӱ��Ϣ
		//������ 	����¼��еĴ��븴�ƹ�����strname����Ϊ��		
		
		
		

		// ȡ��Ժ����
		String strname = "";

		CinemaService service = new CinemaServiceImpl();
		ArrayList<Cinema> list = service
				.selectCinemaServicelikeByCname(strname);
		if ((list == null) || list.size() == 0) {
			return;
		}

		// ��model
		// ��ͷ
		String[] title = { "ӰԺ" };

		int rowcount = list.size();
		// new model
		DefaultTableModel dtm = new DefaultTableModel(title, rowcount);
		// model�ŵ�table��
		table.setModel(dtm);
		// forѭ��
		for (int i = 0; i < list.size(); i++) {

			Cinema cinema = list.get(i);
			// ȡֵ
			String cname = cinema.getCname();

			// ��ֵ
			dtm.setValueAt(cname, i, 0);

		}

	
		
		
		
	}

	/*public void changePanel(JPanel newPanel) {
		
		 * if(oldPanel!=null){ panel1.remove(oldPanel); } panel1.add(newPanel);
		 * 
		 * oldPanel=newPanel;
		 * 
		 * //��ʾ�ɼ� getRootPane().repaint();
		 * 
		 * getRootPane().setVisible(true);
		 * 
		 * 
		 * }
		 
	}*/
}
