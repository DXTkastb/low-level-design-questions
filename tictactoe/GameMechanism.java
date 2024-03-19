package lld.tictactoe;

public interface GameMechanism {
	public void playGame(Game game);
	public boolean checkWinner(Game game);
	public boolean checkIfPositionValid(Game game, Position position);
	public void fillPosition(Game game, Position position);
}
