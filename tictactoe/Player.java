package lld.tictactoe;

public abstract class Player {
	private final String playerName;
	private final Character symbol;
	
	public Player(String name, Character symbol) {
		this.playerName = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return playerName;
	}
	
	public Character getSymbol() {
		return symbol;
	}
	
	public abstract Position getPlayerNextMovePosition(Game game);
	
}
