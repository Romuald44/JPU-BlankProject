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
	 * @throws Exception
	 */
	void loadMap(int id) throws Exception;
	
	/**
	 * Move Up
	 */
	public void moveUp();
	
	/**
	 * Move Down
	 */
	public void moveDown();
	
	/**
	 * Move Left
	 */
	public void moveLeft();
	
	/**
	 * Move Right
	 */
	public void moveRight();
	
	/**
	 * Move Up Left
	 */
	public void moveUpLeft();
	
	/**
	 * Move Up Right
	 */
	public void moveUpRight();
	
	/**
	 * Move Down Left
	 */
	public void moveDownLeft();
	
	/**
	 * Move Down Right
	 */
	public void moveDownRight();
	
	/**
	 * Launch Fireball
	 */
	public void launchFireball();
	
	/**
	 * start Threads Mobiles
	 */
	public void startThreadsMobiles();
	
	/**
	 * get Threads Fireball
	 */
	public Thread getThreadFireball();
	
	/**
	 * set State Thread Finish
	 */
	public void setStateThreadFinish();
	
	/**
	 * set change Observer
	 */
	public void setMobileHasChanged();
	
	/**
	 * get Array Element
	 */
	public IMotionLess[][] getArrayElement();
	
	/**
	 * get Array Mobiles
	 */
	public ArrayList<IMobile> getMobiles();
	
	/**
	 * Replace position x, y to land
	 */
	public void replaceLand(final int x, final int y);
	
	/**
	 * get Score
	 */
	public int getScore();
	
	/**
	 * get Points Purse
	 */
	public int getPointsPurse();
	
	/**
	 * set Points Purse
	 */
	public void setPointsPurse();
	
	/**
	 * set Points Purse zero
	 */
	public void setPointsPurseZero();
	
	/**
	 * set Death
	 * 	@param boolean
	 * 			dead
	 */
	public void setDeath(boolean dead);
	
	/**
	 * get death
	 */
	public boolean getDeath();
	
	/**
	 * set the end of game
	 * 	@param boolean
	 * 			finish
	 */
	public void setTheEnd(boolean finish);
	
	/**
	 * get the end
	 */
	public boolean getTheEnd();
	
	/**
	 * open the door
	 */
	public void openTheDoor();
	
	/**
	 * get Element at position x, y
	 * 	@param int
	 * 			x
	 * 	@param int
	 * 			y
	 * @throws Exception
	 */
	public IMotionLess getElements(final int x, final int y) throws Exception;
	
	/**
	 * get Lorann
	 */
	public ILorann getLorann();
	
	/**
	 * get Width
	 */
	public int getWidth();
	
	/**
	 * get Height
	 */
	public int getHeight();
	
	/**
	 * close Gate
	 */
	public void closeGate();
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
