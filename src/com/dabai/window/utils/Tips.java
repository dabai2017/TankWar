package com.dabai.window.utils;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tips extends JFrame{
	public Tips() {
		setBounds(0,0,200,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("坦克大战辅助工具");
	}
	
	public void loadwin() {
		setLayout(new FlowLayout());
		
		
		Container container = getContentPane();
		
		JButton jButton = new JButton("关闭游戏");
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		container.add(jButton);
		

		setVisible(true);
		
		
		//////////////////////////////////////////////
		
		
		Set<String> set = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.hashCode() - o2.hashCode();
			}
		});
		
		
		
		set.add("a");
		set.add("z");
		set.add("e");
		
		
		System.out.println(set);
		
		
		
	}
}
