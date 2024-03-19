package lld.tictactoe;
import java.io.*;

public class HumanInputGenerator implements InputGenerationStrategy {
	private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static HumanInputGenerator service;
	
	private HumanInputGenerator() {
		
	}
	
	public static HumanInputGenerator getService() {
		if(service == null) service = new HumanInputGenerator();
		return service;
	}
	
	@Override
	public Position getPosition(Game game) {
		Integer row = -1, column = -1;
		try { row = Integer.parseInt(reader.readLine());
		column = Integer.parseInt(reader.readLine());
		}
		catch(Exception e) {
			System.out.println("some error occurred");
		}
		return new Position(row,column);
	}
	
	@Override
	protected void finalize() throws Throwable {
    	reader.close();
    	super.finalize();             
    }
}
