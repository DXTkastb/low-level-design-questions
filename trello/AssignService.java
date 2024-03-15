package lld.trello;
import java.util.*; 

public class AssignService {
	
	/*
		Improve Assign functionality by adding parent id variable to ProjectEntity. This way detaching child from parent Entity will be easier. 
		Making unassign, assign better.
	*/
	
	private StoreService storeService = StoreService.getService();
	private EntityComparator entityComparator = EntityComparator.getComparator();
	private static AssignService service;
	
	private AssignService() {
	}
	
	public static AssignService getService() {
		if(service == null) service = new AssignService();
		return service;
	}
	
	public void assign(int id1, int id2) {
		ProjectEntity entity1 = storeService.getProjectEntity(id1);
		ProjectEntity entity2 = storeService.getProjectEntity(id2);
	
		if(doChecks(entity1,entity2)) {
			return;
		}
		else {
			entity2.getSubEntities().add(entity1.getID());
			System.out.println("ASSIGN SUCCESSFUL!");
		}
	}
	
	public void unassign(int id1, int id2) {
		ProjectEntity entity1 = storeService.getProjectEntity(id1);
		ProjectEntity entity2 = storeService.getProjectEntity(id2);
	
		if(doChecks(entity1,entity2)) {
			return;
		}
		else {
			entity2.getSubEntities().remove(entity1.getID());
			System.out.println("UNASSIGN SUCCESSFUL!");
		}
	}
	
	private boolean doChecks(ProjectEntity entity1, ProjectEntity entity2) {
		return checkIfExist(entity1,entity2) && checkIfSubEntity(entity1,entity2);
	}
	
	private boolean checkIfExist(ProjectEntity entity1, ProjectEntity entity2) {
		boolean result = (entity1 != null && entity2 != null);
		if(!result) System.out.println("one of the id is incorrect");	
		return result;
	}
	
	private boolean checkIfSubEntity(ProjectEntity entity1, ProjectEntity entity2) {
		boolean result = (entityComparator.compare(entity1.getType(),entity2.getType()) == 1);
		if(!result) System.out.println("entity1 is not a sub entity of entity2");	
		return result;
	}
	
}
