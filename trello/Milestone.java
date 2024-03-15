package lld.trello;

public class Milestone extends ProjectEntity {
	private String milestoneDescription;
	public Milestone(String milestoneName, int ID, String description) {
		super(milestoneName,ID,EntityType.MILESTONE);
		this.milestoneDescription = description;
	}
	public String getDescription() {
		return milestoneDescription;
	}	
	public void setDescription(String description) {
		this.milestoneDescription = description;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " +  this.getID();
	}
}
