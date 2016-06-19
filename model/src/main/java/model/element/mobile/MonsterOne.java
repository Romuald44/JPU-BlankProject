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

	public Point movement(Lorann lorann, Point demons) {
		Point lorannIsMoving = new Point(lorann.getPosition().x, lorann.getPosition().y);
			if(lorannIsMoving.x != 0 || lorannIsMoving.y != 0) {
			
			Point diff;
			Point dir;
			if(lorann.getFireball() != null) {
				diff = new Point(lorann.getFireball().getPosition().x-demons.x, lorann.getFireball().getPosition().y-demons.y);
				dir = lorann.getFireball().getPosition();
			} else {
				diff = new Point(0, 0);
				dir = new Point(0, 0);
			}
			
			if(diff.x < 3 && diff.x > 0 && dir.x == -1) {
				demons.y++;
			} else if(diff.x > -3 && diff.x < 0 && dir.x == 1) {
				demons.y--;
			} else if(diff.y < 3 && diff.y > 0 && dir.y == -1) {
				demons.x++;
			} else if(diff.y > -3 && diff.y < 0 && dir.y == 1) {
				demons.x--;
			} else {
				diff = new Point(lorann.getPosition().x-demons.x, lorann.getPosition().y-demons.y);
				
				if(Math.abs(diff.x) > Math.abs(diff.y)) {
					if(diff.x > 0) {
						demons.x++;
					} else {
						demons.x--;
					}
					if(diff.y > 0) {
						demons.y++;
					} else if(diff.y < 0) {
						demons.y--;
					}
				} else {
					if(diff.y > 0) {
						demons.y++;
					} else {
						demons.y--;
					}
					if(diff.x > 0) {
						demons.x++;
					} else if(diff.x < 0) {
						demons.x--;
					}
				}
			}
		}
		return demons;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
