import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
	HumanPlayer() {
		id = ++numberOfPlayers;
		board = new Board();
		battleships = new ArrayList<Battleship>();

		for (int i = 0; i < 5; i++) {
			battleships.add(new Battleship());
		}
	}

	public String attack(Player opponent) {
		Scanner input = new Scanner(System.in);
		System.out.print("player " + id + " attack: ");
		int row = input.nextInt() - 1;
		int column = input.nextInt() - 1;
		Board opponentBoard = opponent.getBoard();
		int[][] opponentGridInfo = opponentBoard.getGridInfo();
		int boardHeight = opponentBoard.getHeight();
		int boardWidth = opponentBoard.getWidth();

		while (0 > row || row >= boardHeight && 0 > column || column >= boardWidth) {
			System.out.println("Attack coordinates must be between row 1-" + boardHeight + " column 1-" + boardWidth + ".");
			System.out.print("player " + id + " attack again: ");
			row = input.nextInt() - 1;
			column = input.nextInt() - 1;
		}

		if (opponentGridInfo[row][column] == 0) {
			opponentBoard.setPlayerId(row, column, -1);
			return "miss";
		} else if (opponentGridInfo[row][column] > 0) {
			opponentBoard.setPlayerId(row, column, -1);

			for (int i = 0; i < boardHeight; i++) {
				for (int j = 0; j < boardWidth; j++) {
					if (opponentGridInfo[j][i] > 0) {
						i = boardHeight;
						break;
					} else if ((i + 1) == boardHeight && (j + 1) == boardWidth) {
						return "win";
					}			
				}
			}

			for (int i = 0; i < boardHeight; i++) {
				if (opponentGridInfo[i][column] > 0) {
					return "hit";
				} 
			}

			return "sunk";
		} else {
			return "already taken";
		}
	}

	public void placeShips() {
		int numberOfBattleships = battleships.size();
		int[] battleshipCoordinates = new int[numberOfBattleships];
		int battleshipLength = battleships.get(0).getHeight(); 
		System.out.print("Player " + id + " please enter " + numberOfBattleships + " ships beginning vertical coordinate: ");
		Scanner input = new Scanner(System.in);
		boolean correctCoordinates = false;	

		while (!correctCoordinates) {
			correctCoordinates = true;

			for (int i  = 0; i < numberOfBattleships; i++) {
				battleshipCoordinates[i] = input.nextInt() - 1;

				if (0 > battleshipCoordinates[i]) {
					correctCoordinates = false;
				} else if (battleshipCoordinates[i] + battleshipLength > board.getHeight()) {
					correctCoordinates = false;
				}
			}

			if (!correctCoordinates) {
				System.out.println("One or more coordinates places the ship outside the board.");
				System.out.println("Remember that the ships height is " +  battleshipLength + ".");
				System.out.println("Also, the board height is " + board.getHeight() + ".");
				System.out.print("Player " + id + " please reenter coordinates: ");
			}
		}

		for (int i = 0; i < numberOfBattleships; i++) {
			for(int j = 0; j <  battleshipLength; j++) {
				board.setPlayerId(battleshipCoordinates[i] + j, i, id);
			}
		}
	}
}
