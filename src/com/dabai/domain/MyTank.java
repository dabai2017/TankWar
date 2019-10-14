package com.dabai.domain;

import com.dabai.utils.Direction;

public class MyTank extends Element{

	private int blood;
	private int speed;
	private int power;
	
	private Direction direction;
	
	public MyTank(String imgPath, int x, int y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}

}
