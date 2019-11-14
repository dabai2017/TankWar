package com.dabai.domain;

import com.dabai.domain.interfaces.Blockable;
import com.dabai.domain.interfaces.Moveable;
import com.dabai.game.Config;
import com.dabai.utils.CollsionUtils;
import com.dabai.utils.Direction;

public class MyTank extends Element implements Moveable{

	private int blood;
	private int speed = 16;
	private int power;
	private Direction direction = Direction.UP;

	private int bullettime = 400;
	
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

	
	String tank_u = "res\\img\\tank_u.gif";
	String tank_d = "res\\img\\tank_d.gif";
	String tank_l = "res\\img\\tank_l.gif";
	String tank_r = "res\\img\\tank_r.gif";
	
	@Override
	public void draw() {
		switch (direction) {
		case UP:
			this.imgPath = tank_u;
			break;
		case DOWN:
			this.imgPath = tank_d;
			break;
		case LEFT:
			this.imgPath = tank_l;
			break;
		case RIGHT:
			this.imgPath = tank_r;
			break;
		default:
			break;
		}
		super.draw();
	}
	
	
	/**
	 * 设置坦克皮肤
	 */
	String img_root = "res\\img\\";
	public void skin(int i) {
		
		switch (i) {
		case 1:
			tank_u = img_root + "tank2_u.gif";
			tank_d = img_root + "tank2_d.gif";
			tank_l = img_root + "tank2_l.gif";
			tank_r = img_root + "tank2_r.gif";
			break;
		case 2:
			
			break;
		default:
			break;
		}
	}
	
	public Bullet shot() {
		
		long nowTime = System.currentTimeMillis();//获得当前时间戳
		
		if ((nowTime - lastFire) < bullettime) {
			return null;
		}
		lastFire = nowTime;
		return new Bullet(this);
	}

	
	private Direction unmoveDirection;//不可移动的方向
	
	//实现接口中的方法  
	public boolean checkCollsion(Blockable blockable) {
		
		Element element = (Element)blockable;
		
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



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public void setBullettime(int bullettime) {
		this.bullettime = bullettime;
	}
	
	


}
