public class Board {
	private int[][] gridInfo;
	private int height;
	private int width;

	Board() {
		gridInfo = new int[5][5];
		height = 5;
		width = 5;
	}

	public int[][] getGridInfo() {
		return gridInfo;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setPlayerId(int row, int column, int playerId) {
		gridInfo[row][column] = playerId;
	}
}
