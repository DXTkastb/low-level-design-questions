package lld.snakeandladder;

import java.lang.Math;

public abstract class GameDice implements CustomDice {
	private final int number;
	public GameDice(int number) {
		this.number = number;
	}
		
	public int rollDiceAndGetNumber() {
		return (int)((Math.random() * 100)%number) + 1;
	}
}
