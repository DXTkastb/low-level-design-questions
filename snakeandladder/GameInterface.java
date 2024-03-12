package lld.snakeandladder;

import java.util.*;

public interface GameInterface {
	public void playGame();
	public List<Player> getPlayers();
	public CustomDice getDice();
	public Board getBoard();
}
