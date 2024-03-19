package lld.tictactoe;

public class AiPlayer {
	public Player(String name, Character symbol) {
		super(name,symbol);
	}

	public Position getPlayerNextMovePosition(Game game) {
		Position position = game.getStrategy().getPosition(game);
		return position;
	}
	
	
}
