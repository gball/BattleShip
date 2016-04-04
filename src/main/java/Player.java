import java.util.ArrayList;

public abstract class Player {
	protected static int numberOfPlayers = 0;
	protected int id;
	protected Board board;
	protected ArrayList<Battleship> battleships;

	public Board getBoard() {
		return board;
	}

	public int[][] getBoardInfo() {
		return board.getBoardInfo();
	}

	public ArrayList<Battleship> getShips() {
		return battleships;
	}

	public abstract String attack(Player opponent);
	public abstract void placeShips();
}
