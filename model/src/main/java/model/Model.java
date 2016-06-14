package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import jpu2016.nettle.world.element.motionless.MotionlessElements;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
	
	/*public MotionlessElement elements[][];
	public final ArrayList<Mobile> mobiles;
	private int width;
	private int	height;
	private Lorann lorann;*/

	/** The message. */
	private String message;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}
	/*
	private void addElement(final MotionlessElement element, final int x, final int y) {
		this.elements[x][y] = element;
		if (element != null) {
			element.setNettleWorld(this);
		}
		this.setChanged();
	}

	@Override
	public void addMobile(final Mobile mobile, final int x, final int y) {
		this.mobiles.add(mobile);
		mobile.setModel(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void addMobile(final Lorann lorann, final int x, final int y) {
		this.setHero(lorann);
		this.addMobile((Mobile) lorann, x, y);
	}

	private void loadMap(final Map map) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int numLine = 0;
		line = buffer.readLine();
		this.width = Integer.parseInt(line);
		line = buffer.readLine();
		this.height = Integer.parseInt(line);
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
		while ((line = buffer.readLine()) != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
			}
			numLine++;
		}
		buffer.close();
		this.setChanged();
	}*/

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final int id) {
		try {
			final DAOMap Map = new DAOMap(DBConnection.getInstance().getConnection());
			String test = Map.find(id).getMap();
			for (int i = 0; i < test.length(); i++) {
				this.addElement(MotionlessElements.getFromFileSymbol(line.toCharArray()[x]), x, numLine);
			    System.out.println(test.charAt(i));
			}
			this.setChanged();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
