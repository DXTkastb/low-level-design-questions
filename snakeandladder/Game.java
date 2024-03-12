package lld.snakeandladder;

import java.util.*;
import java.io.*;

public class Game implements GameInterface {
	private final Board board;
	private final List<Player> players;
	private final CustomDice dice;
	private final GameStrategy gameStrategy;
	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	public Game(Board board, CustomDice dice, GameStrategy gameStrategy) {
		this.board = board;
		players = new ArrayList<>();
		this.dice = dice;
		this.gameStrategy = gameStrategy;
	}
		
	private void intializeGame() throws IOException {
		/*
		
		*/
		

		int numberOfSnakes = Integer.parseInt(bufferedReader.readLine());
		while(numberOfSnakes > 0) {
			int position1 = Integer.parseInt(bufferedReader.readLine());
			int position2 = Integer.parseInt(bufferedReader.readLine());
			board.getSnakeAndLadders().put(position1,position2);
			numberOfSnakes--;
		}
		int numberOfLadders = Integer.parseInt(bufferedReader.readLine());
		while(numberOfLadders > 0) {
			int position1 = Integer.parseInt(bufferedReader.readLine());
			int position2 = Integer.parseInt(bufferedReader.readLine());
			board.getSnakeAndLadders().put(position1,position2);
			numberOfLadders--;
		}		
		
		int numberOfPlayers = Integer.parseInt(bufferedReader.readLine());
		while(numberOfPlayers > 0) {
			String name = bufferedReader.readLine();
			players.add(new GamePlayer(name));
			numberOfPlayers--;
		}
				
	}
	
	private void restartGame()  throws IOException{
		intializeGame();
	}
	
	public void playGame() {
		try {
			restartGame();
		
			// playMore = 1 -> YES
			// playMore = Not 1 -> NO
			gameStrategy.playGameWithStrategy(this);
			int playMore = Integer.parseInt(bufferedReader.readLine());
			if(playMore == 1) restartGame();
			else stopGame();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void stopGame() throws IOException {
		bufferedReader.close();
	}
	
	public List<Player> getPlayers() {
		return players;
	}	
	
	public CustomDice getDice() {
		return dice;
	}
	
	public Board getBoard() {
		return board;
	}
}

