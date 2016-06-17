package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
		this.graphics = this.getGraphics();
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
		graphics.setColor(Color.black);
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.setBackground(Color.black);
		this.element = this.getViewFrame().getModel().getArrayElement();
		this.mobile = this.getViewFrame().getModel().getMobiles();
		
		/*int i=0;
		for(IMotionLess[] test : element) {
			System.out.println(test[i].getSymbol());
			graphics.drawImage(test[i].getImage(), 0, 0, this);
			i++;
		}*/

		for(int y = 0; y < this.getViewFrame().getModel().getHeight(); y++) {
			for(int x = 0; x < this.getViewFrame().getModel().getWidth(); x++) {
				graphics.drawImage(this.element[x][y].getImage(), x*64, y*64, 64, 64, this);
			}
		}

		for(IMobile test : mobile) {
			graphics.drawImage(test.getImage(), test.getX()*64, test.getY()*64, 64, 64, this);
			if(test instanceof ILorann && ((ILorann) test).getFireball().getActive()) {
				graphics.drawImage(((ILorann) test).getFireball().getImage(), 
						((ILorann) test).getFireball().getX()*64, 
						((ILorann) test).getFireball().getY()*64, 64, 64, this);
				
			}
		}
		
		Font font = new Font("Courrier", Font.BOLD, 40);
		/*try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../view/src/main/resources/Minecraft.ttf")));
		} catch (IOException e) {
		     //Handle exception
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		graphics.setFont(font);
		graphics.setColor(Color.YELLOW);
		graphics.drawString("SCORE : "+this.viewFrame.getModel().getScore(), 50, 750);
		
		if(this.viewFrame.getModel().getTheEnd()) {
			this.closeWindow();
		}
		else if(this.viewFrame.getModel().getDeath()) {
			this.closeWindow();
		}
	}
	
	public void closeWindow() {
		this.viewFrame.dispose();
	}
}
