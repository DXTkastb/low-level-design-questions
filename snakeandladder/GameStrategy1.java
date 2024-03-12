package lld.snakeandladder;

import java.util.*;

public class GameStrategy1 implements GameStrategy {

	/*
		Can be improved by adding more methods to its interface!
	*/
	
	public void playGameWithStrategy(GameInterface game) {
		boolean gameOver = true;
		while(gameOver) {
			for(Player player : game.getPlayers()) {
				int rolledNumber = game.getDice().rollDiceAndGetNumber();
				System.out.println(player.getName()+": rolled :"+rolledNumber);
				int currentPosition = player.getPosition();
				int newPosition = currentPosition + rolledNumber;
				int positionAfterJumps = getFinalPositionAfterJumps(game.getBoard().getSnakeAndLadders(),newPosition);
				if(positionAfterJumps <= game.getBoard().getSize()) setPlayerNewPosition(player,positionAfterJumps);
				if(playerWonOrNot(positionAfterJumps,game.getBoard().getSize())) {
					declarePlayerWin(player);
					gameOver = false;
					break;
				}
			}
		}
	}
	
	private int getFinalPositionAfterJumps(Map<Integer,Integer> jumps, int position) {
		if(jumps.containsKey(position)) return getFinalPositionAfterJumps(jumps,jumps.get(position));
		return position;
	}
	
	private boolean playerWonOrNot(int position, int finalPosition) {
		return position == finalPosition;
	}
	
	private void declarePlayerWin(Player player) {
		System.out.println(player.getName()+" won !!");
	}
	
	private void setPlayerNewPosition(Player player, int position) {
		player.setPosition(position);
	}
	
	
}
