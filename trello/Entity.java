package lld.trello;

public abstract class Entity {
	private final EntityType entityType;
	private String name;
	private int ID;
	
	public Entity(String entityName, int entityID, EntityType type) {
		this.ID = entityID;
		this.name = entityName;
		this.entityType = type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID(){
		return ID;
	}
	
	public EntityType getType() {
		return entityType;
	}
}
