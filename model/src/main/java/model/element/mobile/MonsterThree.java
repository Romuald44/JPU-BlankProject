package model.element.mobile;

import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public void movement() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
