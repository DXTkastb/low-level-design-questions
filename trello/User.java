package lld.trello;

class User extends ProjectEntity {
	private String userEmail;
	
	public User(String entityName, int ID, String userEmail) {
		super(entityName,ID,EntityType.USER);
		this.userEmail = userEmail;
	}	
	
	public String getUserEmail() {
		return userEmail;
	}
	
		@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " +  this.getID();
	}
	
}
