package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import model.element.mobile.Lorann;
import model.element.mobile.Mobile;
import model.element.motionless.MotionlessElement;
import model.element.motionless.MotionlessElements;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
	
	public MotionlessElement elements[][];
	public final ArrayList<Mobile> mobiles;
	private int width;
	private int	height;
	//private Lorann lorann;

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
	
	private void addElement(final MotionlessElement element, final int x, final int y) {
		this.elements[x][y] = element;
		if (element != null) {
			element.setModel(this);
		}
		this.setChanged();
	}
	/*
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
			String Maptostring = Map.find(id).getMap();
			this.width = Map.find(id).getWidth();
			this.height = Map.find(id).getHeight();
			int numLine = 0;
			this.elements = new MotionlessElement[width][height];
			for (int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					System.out.print(Maptostring.charAt(numLine+x));
					switch(Maptostring.charAt(numLine+x)) {
					case 'l':
						this.mobiles.add(new Lorann(x, y));
						this.addElement(MotionlessElements.LAND, x, y);
					case '1':
						this.mobiles.add(new Demons(new MonsterOne(), x, y));
						this.addElement(MotionlessElements.LAND, x, y);
					case '2':
						this.mobiles.add(new Demons(new MonsterTwo(), x, y));
						this.addElement(MotionlessElements.LAND, x, y);
					case '3':
						this.mobiles.add(new Demons(new MonsterThree(), x, y));
						this.addElement(MotionlessElements.LAND, x, y);
					case '4':
						this.mobiles.add(new Demons(new MonsterFour(), x, y));
						this.addElement(MotionlessElements.LAND, x, y);
					default:
						this.addElement(MotionlessElements.getFromSymbol(Maptostring.charAt(numLine+x)), x, y);
					}
				}
				numLine+=20;
				System.out.println("");
			    //System.out.println(numLine);
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
