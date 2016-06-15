package model.element.mobile;

import model.element.Sprite;

public class MonsterFour implements IBehavior {
	
	private Sprite sprite;

	public MonsterFour() {
		this.sprite = new Sprite("monster_4.png");
	}

	public void movement() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
