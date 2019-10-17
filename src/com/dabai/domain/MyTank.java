package com.dabai.domain;

import com.dabai.game.Config;
import com.dabai.utils.Direction;

public class MyTank extends Element {

	private int blood;
	private int speed = 32;
	private int power;

	private Direction direction;

	public MyTank(String imgPath, int x, int y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}

	public void move(Direction direction) {

	
		switch (direction) {
		case UP:
			y -= speed;
			break;

		case DOWN:
			y += speed;
			break;

		case LEFT:
			x -= speed;
			break;

		case RIGHT:
			x += speed;
			break;

		case RESET:

			x = Config.WIDTH / 2 - Config.PX / 2;
			y = Config.HEIGHT - Config.PX;

			break;
		default:
			break;
		}
		
		/**
		 * 越界检测
		 */
		if (x <= 0) {
			x = 0;
		} else if (x >= Config.WIDTH - this.width) {
			x = Config.WIDTH - this.width;
		}
		
		if (y <= 0) {
			y = 0;
		} else if (y >= Config.HEIGHT - this.height) {
			y = Config.HEIGHT - this.height;
		}

		
		
		
	}
}
