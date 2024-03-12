package lld.snakeandladder;

import java.util.*;

public class GameBoard implements Board {
	private final Map<Integer,Integer> snakeAndLadders = new HashMap<>();
	private final int size;
	
	public GameBoard(int size) {
		this.size = size;
	}
		
	public Map<Integer,Integer> getSnakeAndLadders() {
		return snakeAndLadders;
	}
	
	public int getSize() {
		return size;
	}
}
