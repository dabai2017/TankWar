package com.dabai.game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static String TITLE = "坦克大战 - 配置失败";//标题
	public static int PX = 64;//像素
	
	public static int WIDTH = 960;//宽高
	public static int HEIGHT = 640;
	
	public static int FPS = 60;//刷新率
	private static Properties properties;
	

	
	static{
		

		properties = new Properties();
		try {properties.load(new FileInputStream("src/config.properties"));} catch (FileNotFoundException e) {} catch (IOException e) {}
		

		
		if (properties != null) {
			TITLE = properties.getProperty("TITLE");
			PX = Integer.parseInt(properties.getProperty("PX"));
			WIDTH = Integer.parseInt(properties.getProperty("WIDTH"));
			HEIGHT = Integer.parseInt(properties.getProperty("HEIGHT"));
			FPS = Integer.parseInt(properties.getProperty("FPS"));
			
		}

	}
	
}
