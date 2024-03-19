package lld.tictactoe;
import java.util.*;

class DefaultGameMechanism implements GameMechanism {
	public void playGame(Game game) {
		List<Player> playerList = game.getPlayers();
		int listSize = playerList.size();
		for( int index = 0;;) {
			if(checkIfmatchTied(game)) {
				System.out.println("game tied!");
				break;
			}
			displayGrid(game);
			Player player = playerList.get(index);
			Position position = player.getPlayerNextMovePosition(game);
			if(!checkIfPositionValid(game,position)) {
				System.out.println("position is already filled. please enter a new position!");
				continue;
			}
			fillPosition(game,position,player);
			if(checkWinner(game,player)) {
				System.out.println("Player Won! : "+player.getName());
				displayGrid(game);
				break;
			}
			 index++;
			 index = index%listSize;			
		}
	}
	
	public boolean checkIfmatchTied(Game game) {
		Grid grid = game.getGrid();
		char[][] map = grid.getGridMap();	
		int counter = 0;
		int size = grid.getSize();
		for(int index = 0 ; index < size ; index++) {
			for(int jindex = 0 ; jindex < size ; jindex++) {
				if(map[index][jindex] == '\u0000') counter++;
			}
		}
		return counter == 0;		
	}
	
	public boolean checkWinner(Game game, Player player) {
		Grid grid = game.getGrid();
		char[][] map = grid.getGridMap();
		char symbol = player.getSymbol();
		int size = grid.getSize();
		int counter = 0;
		for(int index = 0 ; index < size ; index++) {
			for(int jindex = 0 ; jindex < size ; jindex++) {
				if(map[index][jindex] == symbol) counter++;
			}
			if(counter == size) return true;
		}
		for(int index = 0 ; index < size ; index++) {
			counter = 0;
			for(int jindex = 0 ; jindex < size ; jindex++) {
				if(map[jindex][index] == symbol) counter++;
			}
			if(counter == size) return true;
		}
		counter = 0;
		for(int index = 0 ; index < size ; index++) {
			if(map[index][index] == symbol) counter++;
		}
		if(counter == size) return true;
		return false;
	}
	
	public boolean checkIfPositionValid(Game game, Position position) {
		Grid grid = game.getGrid();
		int row = position.getRow();
		int col = position.getColumn();
		return (grid.getGridMap())[row][col] == '\u0000';
	}
	
	public void fillPosition(Game game, Position position,Player player) {
		Grid grid = game.getGrid();
		int row = position.getRow();
		int col = position.getColumn();
		(grid.getGridMap())[row][col] = player.getSymbol();
	}
	
	private void displayGrid(Game game) {
		System.out.println(game.getGrid());
	}
	
	
}
