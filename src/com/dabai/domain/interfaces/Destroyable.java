package com.dabai.domain.interfaces;

import com.dabai.domain.Blast;

public interface Destroyable {
	// 被攻击力击中 返回爆炸物
	public Blast showDestroy();

	public boolean isDestroy();

}
