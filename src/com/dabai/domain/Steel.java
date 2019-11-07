package com.dabai.domain;

import com.dabai.domain.interfaces.Blockable;


/**
 * 铁墙对象
 * @author 故事与猫
 *19-9-19
 */

public class Steel extends Element implements Blockable{
	
	//构造方法：无参,有参
	public Steel(String imgPath,int x,int y){
		super(imgPath, x, y);
	}
	//公有的普通方法
	

}
