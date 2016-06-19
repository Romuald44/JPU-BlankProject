package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	/* No dodge */
	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public Point movement(Lorann lorann, Point demons) {
		if(lorann.getPosition().x != 0 || lorann.getPosition().y != 0) {
			Point diff = new Point(lorann.getPosition().x-demons.x, lorann.getPosition().y-demons.y);
			if(diff.x > 0) {
				demons.x++;
			} else if(diff.x < 0) {
				demons.x--;
			}
			if(diff.y > 0) {
				demons.y++;
			} else if(diff.y < 0) {
				demons.y--;
			}
		}
		return demons;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
