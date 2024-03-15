package lld.trello;

public class Project extends ProjectEntity {
	private String projectDescription;
	public Project(String projectName, int ID, String description) {
		super(projectName,ID,EntityType.PROJECT);
		this.projectDescription = description;
	}
	public String getDescription() {
		return projectDescription;
	}	
	public void setDescription(String description) {
		this.projectDescription = description;
	}
	
		@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " +  this.getID();
	}
}
