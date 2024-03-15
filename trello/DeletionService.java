package lld.trello;
import java.util.*; 

public class DeletionService {
	
	private StoreService storeService = StoreService.getService();
	
	private static DeletionService service;
	
	private DeletionService() {
	
	}
	
	public static DeletionService getService() {
		if(service == null) service = new DeletionService();
		return service;
	}
	
	public void deleteEntity(int id1) {
		ProjectEntity entity1 = storeService.getProjectEntity(id1);
		if(entity1 != null) triggerDfsDelete(entity1);
	}
	
	private void triggerDfsDelete(ProjectEntity entity){
		if(entity.getType() == EntityType.USER) return;
		for(int subEntityId : entity.getSubEntities()) {
			ProjectEntity entity1 = storeService.getProjectEntity(subEntityId);
			if(entity1 != null) triggerDfsDelete(entity1);
		}
		storeService.removeProjectEntity(entity.getID());
	}
	
}
