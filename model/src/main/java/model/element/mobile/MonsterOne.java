package model.element.mobile;
import java.awt.Point;

import model.Model;
import model.element.Sprite;

public class MonsterOne implements IBehavior {
	
	private Sprite sprite;

	/* Monstre déplacement vers Lorann*/
	public MonsterOne() {
		this.sprite = new Sprite("monster_1.png");
	}

	public Point movement(Lorann lorann, Point demons, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
