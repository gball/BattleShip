BattleShip
__________

A command line game developed using Java.
I created an implementation of the Battleship game. The modified game consists of:

	● 2 Players.
	● Each Player has a 5 x 5 board.
	● Players will be given 5 ships that are 3 units long and 1 unit wide
	● For simplicity the pieces will be laid out such that all ships are vertical and there is 1 ship per a column.
	● The game takes as arguments two arrays of integers representing the ship placement on each player’s board.
	● Players will take turns choosing coordinates to attack.

The result of an attack can be one of:

	● A ‘hit’ if the opponent has a ship covering the coordinate
	● A ‘miss’ if there is no ship covering the coordinate
	● ‘already taken’ if the coordinate has previously been attacked
	● ‘sunk’ if all coordinates a ship covers have been hit
	● ‘win’ if all ships on the opponent's board have been sunk

The game ends when all of a player's ships have been sunk.
The text version of the game that looks like the following:

	Player 1 please enter 5 ships beginning vertical coordinate: 1 1 1 1 1
	Player 2 please enter 5 ships beginning vertical coordinate: 2 1 2 3 2
	Player 1 attack: 1 2 //hit coordinate (1,2)
	hit
	Player 2 attack: 2 5
	miss
	Player 1 attack: 1 6
	Attack coordinates must be between row 1-5 column 1-5.
	Player 1 please attack again: 1 2
	already taken
	...
	Player 1 attack: 2 3
	win

For the previous example the players boards would look like the following:

	Player 1:         Player 2:

		1 1 1 1 1          0 2 0 0 0     
		1 1 1 1 1          2 2 2 0 2
		1 1 1 1 1          2 2 2 2 2 
		0 0 0 0 0          2 0 2 2 2
 		0 0 0 0 0          0 0 0 2 0
