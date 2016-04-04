public class Game {
	HumanPlayer player1;
	HumanPlayer player2;

	Game() {
		player1 = new HumanPlayer();
		player2 = new HumanPlayer();
	}

	public void playGame() {
		player1.placeShips();
		player2.placeShips();
		boolean hasGameEnded = false;
		boolean player1Turn = true;

		while (!hasGameEnded) {
			if (player1Turn) {
				String attackResult = player1.attack(player2);
				System.out.println(attackResult); 
				if (attackResult == "win") {
					hasGameEnded = true;
				}

				player1Turn = false;
			} else {
				String attackResult = player2.attack(player1);
				System.out.println(attackResult);
				if (attackResult == "win") {
					hasGameEnded = true;
				}

				player1Turn = true;
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();
	}
}
