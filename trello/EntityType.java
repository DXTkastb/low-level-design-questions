package lld.trello;
import java.util.*; 

public enum EntityType {
	BOARD(1),
	PROJECT(2),
	MILESTONE(3),
	TASK(4),
	USER(5);
	
	private int priority;
	EntityType(int priority) {
		priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
