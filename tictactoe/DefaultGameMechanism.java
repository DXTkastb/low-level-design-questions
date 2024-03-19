package lld.tictactoe;
import java.util.*;

class DefaultGameMechanism implements GameMechanism {
	public void playGame(Game game) {
		List<Player> playerList = game.getPlayers();
		int listSize = playerList.size();
		for( int index = 0; index < listSize; index++) {
			Player player = playerList.get(index);
			Position position = player.getPlayerNextMovePosition(game);
			if(!checkIfPositionValid(game,position)) {
				System.out.println("position is already filled. please enter a new position!");
				index--;
				continue;
			}
			fillPosition(game,position);
			if(checkWinner(game)) {
				System.out.println("Player Won! : "+player.getName());
				break;
			}
						
		}
	}
	
	public boolean checkWinner(Game game) {
		return true;
	}
	public boolean checkIfPositionValid(Game game, Position position) {
		return true;
	}
	public void fillPosition(Game game, Position position) {
		
	}
	
	private void displayGrid(Game game) {
		// display grid
	}
}
