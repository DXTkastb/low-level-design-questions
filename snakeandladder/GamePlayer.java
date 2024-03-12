package lld.snakeandladder;

class GamePlayer implements Player {
	private final String playerName;
	private int position;
	public GamePlayer(String name) {
		this.playerName = name;
		position = 0;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int newPosition){
		this.position = newPosition;
	}
	
	public String getName() {
		return playerName;
	}
}
