package lld.trello;
import java.util.*; 

public class IdGenerationService {
	
	private int currentId = 0; 
	private static IdGenerationService service;
	
	private IdGenerationService() {
	
	}
	
	public static IdGenerationService getService() {
		if(service == null) service = new IdGenerationService();
		return service;
	}
	
	public int generateId() {
		currentId = currentId + 1;
		return currentId;
	}
	
}
