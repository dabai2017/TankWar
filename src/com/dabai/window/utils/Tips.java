package com.dabai.window.utils;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tips extends JFrame{
	public Tips() {
		setBounds(0,0,500,200);
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
	}
}
