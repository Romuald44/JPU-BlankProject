package model.element.mobile;

import java.awt.Point;

import model.Model;
import model.element.Sprite;

public class MonsterTwo implements IBehavior {
	
	private Sprite sprite;

	/* Monstre déplacement random */
	public MonsterTwo() {
		this.sprite = new Sprite("monster_2.png");
	}

	public Point movement(Lorann lorann, Point demons, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
