package contract;

import javax.swing.JFrame;

public interface IView {

	/**
	 * get ViewFrame
	 */
	public JFrame getViewFrame();
	
	/**
	 * print message
	 * 	@param String
	 * 		message
	 */
	public void printMessage(String message);
	
	/**
	 * Swing
	 */
	public void Swing();
}
