package com.dabai.domain;

import com.dabai.utils.PlaySrc;

public class Winner extends Element {
	public Winner(boolean win, String imgPath) {

		super(0, 0, imgPath);

		String sound = "res\\snd\\win.wav";// 胜利

		if (!win) {
			sound = "res\\snd\\failed.wav";// 失败音效
		}

		PlaySrc.playSound(sound);

	}
}
