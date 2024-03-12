package lld.snakeandladder;

class Driver {
	public static void main(String[] args) {
		Board board = new GameBoard(100);
		GameStrategy gameStrategy = new GameStrategy1();
		CustomDice dice = new Dice6();
		Game game = new Game(board,dice,gameStrategy);
		game.playGame();
	}
}
