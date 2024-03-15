package lld.trello;
import java.util.*; 

public abstract class ProjectEntity extends Entity {

	private	final Set<Integer> subEntities = new HashSet<>();
	
	public ProjectEntity(String entityName, int ID, EntityType type) {
		super(entityName,ID, type);
	}
	
	public Set<Integer> getSubEntities() {
		return subEntities;
	}
	
	public void addEntity(Integer entityId) {
		subEntities.add(entityId);
	}	
}
