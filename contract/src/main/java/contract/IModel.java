package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(int id);
	
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
	public void moveUpLeft();
	public void moveUpRight();
	public void moveDownLeft();
	public void moveDownRight();
	
	public void launchFireball();
	
	public void startThreadsMobiles();
	public Thread getThreadFireball();
	public void setStateThreadFinish();
	
	public void setMobileHasChanged();
	
	public IMotionLess[][] getArrayElement();
	public ArrayList<IMobile> getMobiles();
	
	public void replaceLand(final int x, final int y);
	public int getScore();
	public void setPointsPurse();
	
	public void setDeath(boolean dead);
	public boolean getDeath();
	
	public void setTheEnd(boolean finish);
	public boolean getTheEnd();
	
	public void openTheDoor();
	public IMotionLess getElements(final int x, final int y);
	public ILorann getLorann();
	
	public int getWidth();
	public int getHeight();
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
