package model.element.mobile;

import java.awt.Point;
import model.element.Sprite;

public class MonsterFour implements IBehavior {
	
	/**
	 * Sprite sprite
	 */
	private Sprite sprite;

	/**
	 * Instantiate Monster Four
	 */
	public MonsterFour() {
		this.sprite = new Sprite("monster_4.png");/* No diagonal */
	}
	
	/**
	 * movement
	 * @param lorann
	 * @param demons
	 * @return Point
	 */
	public Point movement(Lorann lorann, Point demons) {
		if(lorann.getPosition().x != 0 || lorann.getPosition().y != 0) {
			Point diff = new Point(0, 0);
			Point dir = new Point(0, 0);
			if(lorann.getFireball().getActive()) {
				diff.setLocation(lorann.getFireball().getPosition().x-demons.x, lorann.getFireball().getPosition().y-demons.y);
				dir.setLocation(lorann.getFireball().getDirection());
			}
			
			if(diff.x > 0 && diff.x < 3 && diff.y == 0 && dir.x == -1) {
				demons.y++;
			} else if(diff.x > -3 && diff.x < 0 && diff.y == 0 && dir.x == 1) {
				demons.y--;
			} else if(diff.y > 0 && diff.y < 3 && diff.x == 0 && dir.y == -1) {
				demons.x++;
			} else if(diff.y > -3 && diff.y < 0 && diff.x == 0 && dir.y == 1) {
				demons.x--;
			} else {
				diff.setLocation(lorann.getPosition().x-demons.x, lorann.getPosition().y-demons.y);
				if(diff.x > 0) {
					demons.x++;
				} else if(diff.x < 0) {
					demons.x--;
				} else if(diff.y > 0) {
					demons.y++;
				} else if(diff.y < 0) {
					demons.y--;
				}
			}
		}
		return demons;
	}

	/**
	 * get Sprite
	 * @return Sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	
}
