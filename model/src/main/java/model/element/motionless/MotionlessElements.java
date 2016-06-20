package model.element.motionless;

public abstract class MotionlessElements {
	/**
	 * Instantiate Purse
	 */
	public static final MotionlessElement PURSE = new Purse();
	
	/**
	 * Instantiate CrystallBall
	 */
	public static final MotionlessElement CRYSTALBALL = new CrystalBall();
	
	/**
	 * Instantiate Land
	 */
	public static final MotionlessElement LAND = new Land();
	
	/**
	 * Instantiate Gate
	 */
	public static final MotionlessElement GATE = new Gate();
	
	/**
	 * Instantiate Bone Patella
	 */
	public static final MotionlessElement BONEPAT = new BonePat();
	
	/**
	 * Instantiate Bone Horizontal
	 */
	public static final MotionlessElement BONEHORIZ = new BoneHoriz();
	
	/**
	 * Instantiate Bone Vertical
	 */
	public static final MotionlessElement BONEVERT = new BoneVert();

	/**
	 * Array Motion Less Element
	 */
	private static MotionlessElement motionlessElements[] = { PURSE, CRYSTALBALL, LAND, GATE, BONEPAT, BONEHORIZ, BONEVERT };

	/**
	 * get symbol from Motion Less Element
	 * @param symbol
	 * @return MotionlessElement
	 */
	public static MotionlessElement getFromSymbol(final char symbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSymbol() == symbol) {
				return motionlessElement;
			}
		}
		return LAND;
	}
}