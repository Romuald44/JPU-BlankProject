package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public interface IBehavior {

	/**
	 * movement Demons
	 * @param lorann
	 * @param demons
	 * @return Point
	 */
	public Point movement(Lorann lorann, Point demons);

	/**
	 * get Sprite
	 * @return Sprite
	 */
	public Sprite getSprite();
}
