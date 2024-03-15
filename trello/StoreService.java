package lld.trello;
import java.util.*; 

public class StoreService {
	
	private Map<Integer,ProjectEntity> store = new HashMap<>();
	private static StoreService service;
	
	private StoreService() {
	
	}
	
	public static StoreService getService() {
		if(service == null) service = new StoreService();
		return service;
	}
	
	public boolean saveProjectEntity(int id, ProjectEntity entity) {
		store.put(id,entity);
		return true;
	}
	
	public ProjectEntity getProjectEntity(int id) {
		return store.get(id);
	}
	
	public void removeProjectEntity(int id) {
		store.remove(id);
	}
	
}
