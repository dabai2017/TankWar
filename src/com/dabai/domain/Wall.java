package com.dabai.domain;

import com.dabai.domain.interfaces.Blockable;
import com.dabai.domain.interfaces.Hitable;

/**
 * 
 * @author 故事与猫
 *
 */





/**
 * 砖墙对象
 * @author 故事与猫
 *19-9-19
 */

public class Wall extends Element implements Blockable,Hitable{

	private int blood;//血量
	//构造方法：无参,有参
	public Wall(String imgPath,int x,int y){
		super(imgPath, x, y);
	}
	@Override
	public Blast showExplosive() {
		// TODO Auto-generated method stub
		return new Blast(this);
	}



}
