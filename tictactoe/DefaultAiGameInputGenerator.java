package lld.tictactoe;
import java.io.*;

public class DefaultAiGameInputGenerator implements InputGenerationStrategy {

	
	@Override
	public Position getPosition(Game game) {
		/*
			Use recursive technique (game theory) for producing appropriate ai move.
		*/
		Integer row = 3;
		Integer column = 4;
		return new Position(row,column);
	}
}
