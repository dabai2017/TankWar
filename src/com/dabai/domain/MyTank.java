package com.dabai.domain;

import com.dabai.game.Config;
import com.dabai.utils.CollsionUtils;
import com.dabai.utils.Direction;

public class MyTank extends Element {

	private int blood;
	private int speed = 16;
	private int power;
	private Direction direction = Direction.UP;

	private long lastFire = 0l;
	
	public MyTank(String imgPath, int x, int y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}
	


	public void move(Direction direction) {
		
		if (!this.direction.equals(direction)) {
			this.direction = direction;
			return;
		}
		
		//如果当前移动方向是不可移动方向，，则直接退出
		if (direction.equals(unmoveDirection)) {
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
		
		long nowTime = System.currentTimeMillis();//获得当前时间戳
		
		if ((nowTime - lastFire) < 500) {
			return null;
		}
		lastFire = nowTime;
		return new Bullet(this);
	}

	
	private Direction unmoveDirection;//不可移动的方向
	public boolean checkCollsion(Element element) {
		int x1 = element.x;
		int y1 = element.y;
		int w1 = element.width;
		int h1 = element.height;
		
		int x2 = this.x;
		int y2 = this.y;
		
		switch (direction) {
		case UP:
			y2 -= this.speed;
			break;
		case DOWN:
			y2 += this.speed;
			break;
		case LEFT:
			x2 -= this.speed;
			break;
		case RIGHT: 
			x2 += this.speed;
			break;

		default:
			break;
		}
		
		boolean bool = CollsionUtils.isCollsionWithRect(x1, y1, w1, h1, x2, y2, width, height);
		if (bool) {
			this.unmoveDirection = direction;
		}else {
			this.unmoveDirection = null;
		}
		return bool;
	}


	public int getPower() {
		return power;
	}


	public Direction getDirection() {
		return direction;
	}
	


}
