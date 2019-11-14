package com.dabai.domain;

import com.dabai.utils.PlaySrc;

public class Blast extends Element {

	boolean isDestroy;
	int index = 0;
	
	private String[] imgArray = { "res\\img\\blast_1.gif",
			"res\\img\\blast_2.gif", "res\\img\\blast_3.gif",
			"res\\img\\blast_4.gif", "res\\img\\blast_5.gif" };

	public Blast(Element element) {
		this.x = element.x;
		this.y = element.y;
	}
	
	public void draw() {
		this.imgPath = imgArray[index++];
		if (index >= imgArray.length) {
			index = 0;
			this.isDestroy = true;
			
		}
		
		PlaySrc.drawImg("res\\img\\blast_5.gif", x, y);
	}
	
	public boolean isDestroy() {
		return this.isDestroy;
	}

}
