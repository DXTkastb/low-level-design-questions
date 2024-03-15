package lld.trello;
import java.util.*; 

class EntityComparator implements Comparator<EntityType>{
	private static EntityComparator entityComparator;
	private EntityComparator() {
	
	}
	public static EntityComparator getComparator() {
		if(entityComparator == null) entityComparator = new EntityComparator();
		return entityComparator;
	}
	@Override
	public int compare(EntityType e1 , EntityType e2) {
		return (e1.getPriority() - e2.getPriority() == 1) ? 1 : -1; 
	}
}
