package lld.trello;

public class Task extends ProjectEntity {
	private String taskDescription;
	public Task(String taskName, int ID, String description) {
		super(taskName,ID,EntityType.TASK);
		this.taskDescription = description;
	}
	public String getDescription() {
		return taskDescription;
	}	
	public void setDescription(String description) {
		this.taskDescription = description;
	}
		@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " +  this.getID();
	}
}
