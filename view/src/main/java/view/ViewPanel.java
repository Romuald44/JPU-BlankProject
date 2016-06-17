package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import contract.ILorann;
import contract.IMobile;
import contract.IMotionLess;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7138488664502639606L;

	/** The view frame. */
	private ViewFrame viewFrame;
	
	private IMotionLess[][] element;
	private ArrayList<IMobile> mobile = new ArrayList<IMobile>();

	private Graphics graphics;
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.setGraphics(this.getGraphics());
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object element) {
		//this.element = viewFrame.getModel().getArrayElement();
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		this.viewFrame.setBackground(Color.BLACK);
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.element = this.getViewFrame().getModel().getArrayElement();
		this.mobile = this.getViewFrame().getModel().getMobiles();

		for(int y = 0; y < this.getViewFrame().getModel().getHeight(); y++) {
			for(int x = 0; x < this.getViewFrame().getModel().getWidth(); x++) {
				graphics.drawImage(this.element[x][y].getImage(), x*46, y*46, 46, 46, this);
			}
		}

		for(IMobile test : mobile) {
			graphics.drawImage(test.getImage(), test.getX()*46, test.getY()*46, 46, 46, this);
			if(test instanceof ILorann && ((ILorann) test).getFireball().getActive()) {
				graphics.drawImage(((ILorann) test).getFireball().getImage(), 
						((ILorann) test).getFireball().getX()*46, 
						((ILorann) test).getFireball().getY()*46, 46, 46, this);
				
			}
		}
		
		Font font = new Font("Courrier", Font.BOLD, 40);
		graphics.setFont(font);
		graphics.setColor(Color.YELLOW);
		graphics.drawString("SCORE : "+this.viewFrame.getModel().getScore(), 50, 600);
		
		if(this.viewFrame.getModel().getTheEnd()) {
			graphics.setColor(Color.WHITE);
			graphics.drawString("FINISH !", 600, 600);
			//this.closeWindow();
		}
		else if(this.viewFrame.getModel().getDeath()) {
			graphics.setColor(Color.RED);
			graphics.drawString("YOU DIED", 600, 600);
			//this.closeWindow();
		}
	}
	
	public void closeWindow() {
		this.viewFrame.dispose();
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
}
