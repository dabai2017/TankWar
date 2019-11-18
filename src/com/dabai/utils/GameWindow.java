package com.dabai.utils;

import java.io.IOException;
import java.util.Comparator;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;

import com.dabai.domain.interfaces.*;
import com.dabai.domain.*;
import com.dabai.game.Config;

public class GameWindow extends Window {

	// 新建一组砖墙对象
	public List<Element> mElementList = new CopyOnWriteArrayList<Element>();

	private MyTank myTank;
	private MyTank myTank2;
	 
	
	public GameWindow(String title, int width, int height, int fps) {

		super(title, width, height, fps);
		System.out.println("游戏窗体加载完毕...");
		
		/**
		 * 切换输入法为 英文
		 */

		try {
			Runtime.getRuntime().exec("cmd /c CScript D:\\java\\TankWar-V1.0\\res\\shift.vbs");
		} catch (IOException e) {
		}
			
		

	}

	@Override
	protected void onCreate() {

		// System.out.println("载入游戏欢迎音乐...");
		// playSound("res\\snd\\start.wav");

		// 窗体宽度/px = 一个窗体可以摆放几块
		// 土墙
		for (int i = 0; i < Config.WIDTH / Config.PX - 1; i++) {

			// 改变一些砖墙对象
			Steel steel = new Steel("res\\img\\steel.gif", i * Config.PX,
					Config.PX);

			if (i > 4 && i < 14) {
				this.addElement(steel);
				continue;
			}
			// 图片位子 x轴 y轴
			Wall wall = new Wall("res\\img\\wall.gif", i * Config.PX, Config.PX);
			this.addElement(wall);
		}
		// 水墙
		for (int i = 1; i < Config.WIDTH / Config.PX; i++) {

			// 改变一些砖墙对象
			Water water2 = new Water("res\\img\\water.gif", i * Config.PX,
					Config.PX * 4);
			if (i > 7 && i < 15) {
				// this.addElement(water2);
				continue;
			}

			Water water = new Water("res\\img\\water.gif", i * Config.PX,
					Config.PX * 3);
			this.addElement(water);
		}
		// 铁墙
		for (int i = 0; i < Config.WIDTH / Config.PX - 1; i++) {

			// 改变一些砖墙对象
			Grass grass = new Grass("res\\img\\grass.gif", i * Config.PX,
					Config.PX * 5);
			if (i > 6 && i < 14) {
				this.addElement(grass);
				continue;
			}

			Steel steel = new Steel("res\\img\\steel.gif", i * Config.PX,
					Config.PX * 5);
			this.addElement(steel);

		}
		// 草墙
		for (int i = 1; i < Config.WIDTH / Config.PX; i++) {
			Grass grass = new Grass("res\\img\\grass.gif", i * Config.PX,
					Config.PX * 7);
			this.addElement(grass);
		}

		
		//坦克 1号
		myTank = new MyTank("res\\img\\tank2_u.gif", Config.WIDTH / 2
				- Config.PX / 2 - 80, Config.HEIGHT - Config.PX);
		
		//坦克2 号
		myTank2 = new MyTank("res\\img\\tank2_u.gif", Config.WIDTH / 2
				- Config.PX / 2 + 80, Config.HEIGHT - Config.PX);
		
		
		myTank2.setBullettime(10);
		//myTank2.skin(1);
	
		
		this.addElement(myTank);
		this.addElement(myTank2);

	}

	@Override
	protected void onMouseEvent(int key, int x, int y) {

	}

	@Override
	protected void onKeyEvent(int key) {


		// 上下左右事件  (	//坦克 1号)     WASD  空格
		if (key == Keyboard.KEY_W) {
			myTank.move(Direction.UP);
		} else if (key == Keyboard.KEY_S) {
			myTank.move(Direction.DOWN);
		} else if (key == Keyboard.KEY_A) {
			myTank.move(Direction.LEFT);
		} else if (key == Keyboard.KEY_D) {
			myTank.move(Direction.RIGHT);
		} else if (key == Keyboard.KEY_F5) {
			myTank.move(Direction.RESET);
		} else if (key == Keyboard.KEY_SPACE) {
			Bullet bullet = myTank.shot();// 开炮
			//bullet.setSpeed(1);
			if (bullet != null) {
				this.addElement(bullet);
			}
		}
		
		
		// 上下左右事件(	//坦克 2号)    上下左右    回车
		if (key == Keyboard.KEY_UP) {
			myTank2.move(Direction.UP);
		} else if (key == Keyboard.KEY_DOWN) {
			myTank2.move(Direction.DOWN);
		} else if (key == Keyboard.KEY_LEFT) {
			myTank2.move(Direction.LEFT);
		} else if (key == Keyboard.KEY_RIGHT) {
			myTank2.move(Direction.RIGHT);
		} else if (key == Keyboard.KEY_F5) {
			myTank2.move(Direction.RESET);
		} else if (key == Keyboard.KEY_RETURN) {
			Bullet bullet = myTank2.shot();// 开炮
			if (bullet != null) {
				this.addElement(bullet);
			}
		}

		

	}

	@Override
	protected void onDisplayUpdate() {

		// 刷新帧

//		try {

			Iterator<Element> it = mElementList.iterator();
			
			
			//System.out.println(mElementList.size());
			
			while (it.hasNext()) {
				Element ele = (Element) it.next();

				if (ele instanceof Bullet) {
					boolean bool = ((Bullet)ele).isDestroy();
					
					if (bool) {
					mElementList.remove(ele);
					}
				}
				
				// 判断当前元素是否为  可移动元素
				if (ele instanceof Moveable) {
					Moveable moveable = (Moveable) ele;
					
					Iterator<Element> it2 = mElementList.iterator();
					
					while (it2.hasNext()) {
						Element element2 = (Element) it2.next();

						if (element2 instanceof Blockable) {
							// 如果元素属于 不可通过元素
							Blockable block = (Blockable)element2;
							boolean bool = moveable.checkCollsion(block);
							if (bool) {
								break;// 如果发生碰撞就终止循环
							}
						}
					}
				}
				
				//判断元素一  是炮弹类   判断是否是 击中目标   如果是则 销毁炮弹  则播放销毁 场景。
		
				
				/*	
				 * 需要改需要改需要改需要改需要改
				 * 
				 * */
				if (ele instanceof Attackable) {
					Attackable attackable = (Attackable)ele;
					Iterator<Element> it3 = mElementList.iterator();
					while (it3.hasNext()) {
						Element element3 = (Element)it3.next();
						
						
						if(element3 instanceof Hitable){
							boolean bool = attackable.checkCollsion(element3);
							
							if (bool) {
								//移除此炮弹
								mElementList.remove(ele);
								
								Hitable hitable = (Hitable)element3;
								Blast blast = hitable.showExplosive();
								addElement(blast);
								
								break;
							}
						}
						

					}
				}
				
				if (ele instanceof Blast) {
					Blast blast = (Blast) ele;
					boolean bool = blast.isDestroy();
					if (bool) {
						mElementList.remove(blast);
					}
				}
				
				ele.draw();
			}

//		} catch (Exception e) {
//			System.out.println("有异常情况 ： " + e.getMessage());
//		}
	}


	/**
	 * 添加元素  到  集合
	 * @param element
	 */
	private void addElement(Element element) {
		this.mElementList.add(element);
		this.mElementList.sort(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o1.getOrder() - o2.getOrder();
			}
		});
	}

}
