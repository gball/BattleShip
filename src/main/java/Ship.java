public abstract class Ship {
	protected int height;
	protected int width;
	protected int unitsRemaining;

	public void isHit() {
		--unitsRemaining;
	}

	public int getUnitsRemaining() {
		return unitsRemaining;
	}

	public int getHeight() {
		return height;
	}
}
