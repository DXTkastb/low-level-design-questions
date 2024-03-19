package lld.tictactoe;

public interface GameMechanism {
	public void playGame(Game game);
	public boolean checkWinner(Game game, Player player);
	public boolean checkIfPositionValid(Game game, Position position);
	public void fillPosition(Game game, Position position, Player player);
}
