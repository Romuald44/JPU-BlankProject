package model.element.mobile;

import model.element.Sprite;

public class MonsterOne implements IBehavior {
	
	private Sprite sprite;

	/* Monstre déplacement vers Lorann*/
	public MonsterOne() {
		this.sprite = new Sprite("monster_1.png");
	}

	public void movement() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
