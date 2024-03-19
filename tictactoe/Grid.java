package lld.tictactoe;

class Grid {
	private int gridSize;
	private final char[][] gridMap;
	public Grid(int size) {
		this.gridSize = size;
		this.gridMap = new char[size][size];
	}
	public int getSize() {
		return gridSize;
	}
	
	public char[][] getGridMap() {
		return gridMap;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int size = gridSize;
		for(int index = 0 ; index < size ; index++) {
			for(int index2 = 0 ; index2 < size ; index2++) {
				builder.append(gridMap[index][index2]);
				if(index2 != size -1) builder.append("|");
			}
			builder.append("\n");
			for(int index2 = 0 ; index2 < 2*size - 1 && index != size - 1; index2++) {
				builder.append("_");
			}
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
