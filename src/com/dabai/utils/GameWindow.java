package com.dabai.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.dabai.domain.*;
import com.dabai.game.Config;

public class GameWindow extends Window{

	
		//新建一组砖墙对象
		private ArrayList<Element> mElementList = new ArrayList<>();
		
	
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
		
	}

	@Override
	protected void onCreate() {
		

		

		try {
			//SoundUtils.play("res\\snd\\start.wav");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//窗体宽度/px = 一个窗体可以摆放几块
		//土墙
		for (int i = 0; i <Config.WIDTH/Config.PX-1; i++) {
				                        //  图片位子                           x轴               y轴
			Wall wall = new Wall("res\\img\\wall.gif", i*Config.PX, Config.PX);
			mElementList.add(wall);
			}
		//水墙
		for (int i = 1; i < Config.WIDTH/Config.PX; i++) {
			Water water = new Water("res\\img\\water.gif", i*Config.PX, Config.PX*3);
			mElementList.add(water);
		}
		//铁墙
		for (int i = 0; i < Config.WIDTH/Config.PX-1; i++) {
			Steel steel = new Steel("res\\img\\steel.gif", i*Config.PX, Config.PX*5);
			mElementList.add(steel);
		}
		//草墙
		for (int i = 1; i < Config.WIDTH/Config.PX; i++) {
			Grass grass = new Grass("res\\img\\grass.gif", i*Config.PX, Config.PX*7);
			mElementList.add(grass);
		}
		
	}

	@Override
	protected void onMouseEvent(int key, int x, int y) {
		
		
	}

	@Override
	protected void onKeyEvent(int key) {
		
		
		
		
		
		//上下左右事件
		if (key == Keyboard.KEY_UP) {
			
		}else if (key == Keyboard.KEY_DOWN) {
			
		}else if (key == Keyboard.KEY_LEFT) {
			
		}else if (key == Keyboard.KEY_RIGHT) {
			
		}else if(key == Keyboard.KEY_RETURN){
			
		}
		
		
		
	}

	@Override
	protected void onDisplayUpdate() {
		//刷新帧
		
		//遍历土墙集合 将一组
				Iterator it = mElementList.iterator();
				while (it.hasNext()) {
					Element ele = (Element)it.next();
					ele.draw();
				}
				
		
	}
	
	
	public static void playSound(String res) {
		try {
			SoundUtils.play(res);
		} catch (IOException e) {
			System.out.println("出了问题:"+e.getMessage());
		}
	}
	

	public static void drawImg(String res,int x,int y) {
		try {
			DrawUtils.draw(res,x, y);
		} catch (IOException e) {
			System.out.println("出了问题:"+e.getMessage());
		}
	}
	

}
