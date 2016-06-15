package model.element.mobile;

import model.element.Sprite;

public class MonsterOne implements IBehavior {
	
	private Sprite sprite;

	public MonsterOne() {
		this.sprite = new Sprite("monster_1");
	}

	public void movement() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
