package lld.tictactoe;

public class Position {
	private final int row;
	private final int column;
	
	public Position(int rowNum, int colNum) {
		this.row = rowNum;
		this.column = colNum;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
}
