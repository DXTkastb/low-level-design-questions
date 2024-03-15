package lld.trello;
import java.util.*; 

public class ShowService {
	
	private StoreService storeService = StoreService.getService();
	
	private static ShowService service;
	
	private ShowService() {
	
	}
	
	public static ShowService getService() {
		if(service == null) service = new ShowService();
		return service;
	}
		
	private void triggerDfsShow(ProjectEntity entity){
		System.out.println(entity);
		if(entity.getType() == EntityType.USER) {}
		else {
			for(int subEntityId : entity.getSubEntities()) {
				ProjectEntity entity1 = storeService.getProjectEntity(subEntityId);
				if(entity1 != null) {
					triggerDfsShow(entity1);
				}
			}
		}
	}
	
	public void showProjectEntity(int id) {
		System.out.println("---------------------------");
		ProjectEntity entity = storeService.getProjectEntity(id);
		if(entity != null) System.out.println(entity);
		else System.out.println("incorrect id");
		System.out.println("---------------------------");
	}
	
	public void showProjectEntityVerbose(int id) {
		System.out.println("---------------------------");
	    ProjectEntity entity = storeService.getProjectEntity(id);
		if(entity != null) triggerDfsShow(entity);
		else System.out.println("incorrect id");
		System.out.println("---------------------------");
	}
	
}
