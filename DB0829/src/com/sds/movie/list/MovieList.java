<<<<<<< HEAD
//영화상영정보 처리 화면...
=======
//영화상영정보 처리 화면..
>>>>>>> zenxen1/master
package com.sds.movie.list;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MovieList extends JPanel{
	//서쪽
	JPanel p_west;
<<<<<<< HEAD
	JTable table;
	JScrollPane scroll;
	MovieModel moviemodel;
	
	//센터
	
=======
	
	//센터 
	JScrollPane scroll;
	JTable table;
	MovieModel movieModel;
>>>>>>> zenxen1/master
	
	public MovieList() {
		p_west = new JPanel();
		p_west.setBackground(Color.YELLOW);
		p_west.setPreferredSize(new Dimension(150, 500));
		
<<<<<<< HEAD
		table = new JTable(moviemodel = new MovieModel());
		scroll = new JScrollPane(table);
		
		
		
		setLayout(new BorderLayout());
		add(p_west,BorderLayout.WEST);
		add(scroll);
	}
}
=======
		movieModel = new MovieModel();
		table = new JTable(movieModel);
		scroll = new JScrollPane(table);
		
		setLayout( new BorderLayout());
		add(p_west, BorderLayout.WEST);
		add(scroll);
	}
	
}





>>>>>>> zenxen1/master
