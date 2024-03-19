package lld.tictactoe;
import java.io.*;

public class HumanInputGenerator implements InputGenerationStrategy {
	private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static UserInputService service;
	
	private HumanInputGenerator() {
		
	}
	
	public static HumanInputGenerator getService() {
		if(service == null) service = new HumanInputGenerator();
		return service;
	}
	
	@Override
	public Position getPosition(Game game) {
		Integer row = Integer.parseInt(reader.readLine());
		Integer column = Integer.parseInt(reader.readLine());
		return new Position(row,column);
	}
	
	@Override
	protected void finalize() throws Throwable {
    	reader.close();
    	super.finalize();             
    }
}
