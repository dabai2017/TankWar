package com.dabai.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.dabai.domain.*;
import com.dabai.game.Config;
import com.dabai.window.utils.Tips;

public class GameWindow extends Window {

	// 新建一组砖墙对象
	private ArrayList<Element> mElementList = new ArrayList<>();

	private MyTank myTank;

	public GameWindow(String title, int width, int height, int fps) {
		
		super(title, width, height, fps);
		System.out.println("游戏窗体加载完毕...");
		
	}

	@Override
	protected void onCreate() {

		System.out.println("载入游戏欢迎音乐...");
		playSound("res\\snd\\start.wav");
		
	
		// 窗体宽度/px = 一个窗体可以摆放几块
		// 土墙
		for (int i = 0; i < Config.WIDTH / Config.PX - 1; i++) {
			// 图片位子 x轴 y轴
			Wall wall = new Wall("res\\img\\wall.gif", i * Config.PX, Config.PX);
			mElementList.add(wall);
		}
		// 水墙
		for (int i = 1; i < Config.WIDTH / Config.PX; i++) {
			Water water = new Water("res\\img\\water.gif", i * Config.PX,
					Config.PX * 3);
			mElementList.add(water);
		}
		// 铁墙
		for (int i = 0; i < Config.WIDTH / Config.PX - 1; i++) {
			Steel steel = new Steel("res\\img\\steel.gif", i * Config.PX,
					Config.PX * 5);
			mElementList.add(steel);
		}
		// 草墙
		for (int i = 1; i < Config.WIDTH / Config.PX; i++) {
			Grass grass = new Grass("res\\img\\grass.gif", i * Config.PX,
					Config.PX * 7);
			mElementList.add(grass);
		}

		myTank = new MyTank("res\\img\\tank_u.gif", Config.WIDTH / 2
				- Config.PX / 2, Config.HEIGHT - Config.PX);
		
	
		System.out.println("辅助工具加载...");
		Tips tips = new Tips();
		tips.loadwin();

	}

	@Override
	protected void onMouseEvent(int key, int x, int y) {

	}

	@Override
	protected void onKeyEvent(int key) {

		// 上下左右事件
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
		}else if (key == Keyboard.KEY_RETURN) {
			Bullet bullet = myTank.shot();//开炮
			if (bullet != null) {
				mElementList.add(bullet);
			}
		}

	}

	
	@Override
	protected void onDisplayUpdate() {
		// 刷新帧

		try {
			
			Iterator<Element> it = mElementList.iterator();
			while (it.hasNext()) {
				Element ele = (Element) it.next();
				ele.draw();
			}

			myTank.draw();
			
	
		} catch (Exception e) {
			System.out.println("有异常情况 ： "+e.getMessage());
		}

	}

	public static void playSound(String res) {
		try {
			SoundUtils.play(res);
		} catch (IOException e) {
			System.out.println("出了问题:" + e.getMessage());
		}
	}

	public static void drawImg(String res, int x, int y) {
		try {
			DrawUtils.draw(res, x, y);
		} catch (IOException e) {
			System.out.println("出了问题:" + e.getMessage());
		}
	}

}
