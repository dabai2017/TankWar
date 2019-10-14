package com.dabai.game;

import com.dabai.utils.GameWindow;

public class TankApp {

	public static void main(String[] args) {
		
		System.out.println(TankApp.class+"类运行,开始加载UI线程");
		
		GameWindow gw = new GameWindow(Config.TITLE, Config.WIDTH, Config.HEIGHT, Config.FPS);
		gw.start();
		
		
		
		
	}
	
	
	
}
