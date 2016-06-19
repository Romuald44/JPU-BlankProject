package model.element.mobile;

import java.awt.Point;

import model.Model;
import model.element.Sprite;

public interface IBehavior {

	public Point movement(Lorann lorann, Point demons);

	public Sprite getSprite();
}
