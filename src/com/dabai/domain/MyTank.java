package com.dabai.domain;

import com.dabai.game.Config;
import com.dabai.utils.Direction;

public class MyTank extends Element {

	private int blood;
	private int speed = 32;
	private int power;

	private Direction direction = Direction.UP;

	public MyTank(String imgPath, int x, int y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}
	


	public void move(Direction direction) {
		
		if (!this.direction.equals(direction)) {
			this.direction = direction;
			return;
		}
		
		this.direction = direction;

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
//复位
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

	/**
	 * 重写父类draw 2019-10-17 下午2:48:31
	 */

	@Override
	public void draw() {
		switch (direction) {
		case UP:
			this.imgPath = "res\\img\\tank_u.gif";
			break;
		case DOWN:
			this.imgPath = "res\\img\\tank_d.gif";
			break;
		case LEFT:
			this.imgPath = "res\\img\\tank_l.gif";
			break;
		case RIGHT:
			this.imgPath = "res\\img\\tank_r.gif";
			break;
		default:
			break;
		}
		super.draw();
	}
	
	
	public Bullet shot() {
		return new Bullet(this);
	}



	public int getPower() {
		return power;
	}



	public Direction getDirection() {
		return direction;
	}
	


}
