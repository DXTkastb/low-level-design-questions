package lld.tictactoe;
import java.util.*;

public class App {
	public static void main(String[] args) {
		Player player1 = new HumanPlayer("Mark",'y');
		Player player2 = new HumanPlayer("Henry",'n');
		Game.GameBuilder builder = new Game.GameBuilder();
		builder.addHumanPlayers(List.of(player1,player2));
		Game game = builder.build();
		game.playGame();
	}
}
