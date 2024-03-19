package lld.tictactoe;

public class HumanPlayer {

	public Player(String name, Character symbol) {
		super(name,symbol);
	}

	public Position getPlayerNextMovePosition(Game game) {
		Position position = HumanInputGenerator.getService().getPosition(game);
		return position;
	}
	
}
