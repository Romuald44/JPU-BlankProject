package model.element.motionless;

public abstract class MotionlessElements {
	public static final MotionlessElement PURSE = new Purse();
	public static final MotionlessElement CRYSTALBALL = new CrystalBall();
	public static final MotionlessElement LAND = new Land();
	public static final MotionlessElement GATE = new Gate();
	public static final MotionlessElement BONEPAT = new BonePat();
	public static final MotionlessElement BONEHORIZ = new BoneHoriz();
	public static final MotionlessElement BONEVERT = new BoneVert();
	public static final MotionlessElement	ESCAPE								= new Escape();

	private static MotionlessElement			motionlessElements[]	= { CAMP, FOREST, LAND, MONASTERY, STONE, TOWN, WATER, DOOR, WALL, FLOOR, EXIT, ESCAPE };

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return LAND;
	}
}