package com.dabai.domain;

public class Bullet extends Element{

	public Bullet(String imgPath, int x, int y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}

	public Bullet(MyTank myTank) {
		
		super("res\\img\\bullet_u.gif",20,20);
		
	}
	
}
