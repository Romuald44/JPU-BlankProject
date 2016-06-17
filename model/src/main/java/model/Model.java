package model;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IMobile;
import contract.IModel;
import contract.IMotionLess;
import model.element.Element;
import model.element.mobile.Demons;
import model.element.mobile.Fireball;
import model.element.mobile.Lorann;
import model.element.mobile.Mobile;
import model.element.mobile.MonsterFour;
import model.element.mobile.MonsterOne;
import model.element.mobile.MonsterThree;
import model.element.mobile.MonsterTwo;
import model.element.motionless.Gate;
import model.element.motionless.MotionlessElement;
import model.element.motionless.MotionlessElements;
import model.element.motionless.Purse;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
	
	public MotionlessElement elements[][];
	public final ArrayList<IMobile> mobiles;
	private int width;
	private int	height;
	private Map map;
	private Thread threadFireball;
	private Thread threadLorann;
	
	private boolean finish = false;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.mobiles = new ArrayList<IMobile>();
	}
	
	public void startThreadFireball(Fireball fireball) {
		this.threadFireball = new Thread(fireball);
		this.threadFireball.start();
	}
	
	public void startThreadLorann(Lorann lorann) {
		this.threadLorann = new Thread(lorann);
		this.threadLorann.start();
	}
	
	public void moveUp() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveUp()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	public void moveDown() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveDown()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	public void moveLeft() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveLeft()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	public void moveRight() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveRight()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	public void moveUpLeft() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveUpLeft()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	public void moveUpRight() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveUpRight()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	public void moveDownLeft() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveDownLeft()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	public void moveDownRight() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveDownRight()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	public void launchFireball() {
		if(!this.getLorann().getFireball().getActive()) {
			this.getLorann().launchFireball();
		}
		else {
			this.getLorann().deviateFireball();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public Map getMap() {
		return this.map;
	}
	
	public void addElement(final IMotionLess element, final int x, final int y) {
		this.elements[x][y] = (MotionlessElement) element;
		if (element != null) {
			((Element) element).setModel(this);
		}
		if(x == 19 && y == 11) {
			this.setChanged();
			this.notifyObservers(this.elements);
		}
	}
	
	public void replaceLand(final int x, final int y) {
		/*if(this.elements[x][y] instanceof Purse) {
			((Purse)this.elements[x][y]).setPoints(650);
		}
		else if(this.elements[x][y] instanceof CrystalBall) {
			this.getGate().open();
		}*/
		this.elements[x][y] = MotionlessElements.LAND;
		this.setChanged();
		this.notifyObservers(this.elements);
	}
	
	public int getScore() {
		return this.getPurse().points;
	}
	
	public void setPointsPurse() {
		this.getPurse().setPoints(650);
	}
	
	public void setTheEnd(boolean finish) {
		this.finish = finish;
	}
	
	public boolean getTheEnd() {
		return this.finish;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public MotionlessElement getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}
	
	public MotionlessElement[][] getArrayElement() {
		return this.elements;
	}
	
	public void removeMobile(int indice) {
		this.mobiles.remove(indice);
	}
	
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}
	
	public void openTheDoor() {
		this.getGate().open();	
	}
	
	public Lorann getLorann() {
		for(IMobile lorann : mobiles) {
			if(lorann instanceof Lorann) {
				return (Lorann) lorann;
			}
		}
		return null;
	}
	
	public Purse getPurse() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.elements[x][y] instanceof Purse) {
					return (Purse) this.elements[x][y];
				}
			}
		}
		return null;
	}
	
	private Gate getGate() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.elements[x][y] instanceof Gate) {
					return (Gate) this.elements[x][y];
				}
			}
		}
		return null;
	}
	
	public void addMobile(final Mobile mobile) {
		this.mobiles.add(mobile);
	}
	
	public void loadMap(final int id) {
		try {
			final DAOMap Map = new DAOMap(DBConnection.getInstance().getConnection());
			map = Map.find(id);
			String Maptostring = map.getMap();
			this.width = map.getWidth();
			this.height = map.getHeight();
			int numLine = 0;
			this.elements = new MotionlessElement[width][height];
			
			for (int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					System.out.print(Maptostring.charAt(numLine+x));
					switch(Maptostring.charAt(numLine+x)) {
					case 'l':
						this.addMobile(new Lorann(x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '1':
						this.addMobile(new Demons(new MonsterOne(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '2':
						this.addMobile(new Demons(new MonsterTwo(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '3':
						this.addMobile(new Demons(new MonsterThree(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '4':
						this.addMobile(new Demons(new MonsterFour(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					default:
						this.addElement(MotionlessElements.getFromSymbol(Maptostring.charAt(numLine+x)), x, y);
						break;
					}
				}
				numLine+=20;
				System.out.println("");
			    //System.out.println(numLine);
			}
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
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
