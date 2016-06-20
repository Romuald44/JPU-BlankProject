package contract;

import java.awt.Image;
import java.awt.Point;

public interface IMobile {

	/**
	 * get position X
	 */
	public int getX();
	
	/**
	 * get position Y
	 */
	public int getY();
	
	/**
	 * get Image
	 */
	public Image getImage();
	
	/**
	 * get Position
	 */
	public Point getPosition();
	
	/**
	 * get Thread
	 */
	public Thread getThread();
	
	/**
	 * get Thread active
	 */
	public boolean getThreadActive();
	
	/**
	 * set Thread
	 * 
	 * @param Runnable
	 * 		mobile
	 */
	public void setThread(Runnable mobile);
	
	/**
	 * start Thread
	 */
	public void startThread();
	
	/**
	 * set Thread active
	 * 
	 * @param boolean
	 * 		active
	 */
	public void setThreadActive(boolean active);
}
