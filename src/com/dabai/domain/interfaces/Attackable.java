package com.dabai.domain.interfaces;

import com.dabai.domain.Element;

/**
 * 具有攻击能力接口
 * 实现此类的原始具有攻击力
 * @author 故事与猫
 * 2019-11-14	下午2:09:14
 */
public interface Attackable {
	//判断是否击中
	public boolean checkCollsion(Element element);
	public int getPower();
}
