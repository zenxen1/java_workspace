//��ȭ������ ó�� ȭ��...
package com.sds.movie.list;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MovieList extends JPanel{
	//����
	JPanel p_west;
	JTable table;
	JScrollPane scroll;
	MovieModel moviemodel;
	
	//����
	
	
	public MovieList() {
		p_west = new JPanel();
		p_west.setBackground(Color.YELLOW);
		p_west.setPreferredSize(new Dimension(150, 500));
		
		table = new JTable(moviemodel = new MovieModel());
		scroll = new JScrollPane(table);
		
		
		
		setLayout(new BorderLayout());
		add(p_west,BorderLayout.WEST);
		add(scroll);
	}
}
