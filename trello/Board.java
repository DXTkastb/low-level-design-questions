package lld.trello;

public class Board extends ProjectEntity {
	private Privacy privacyType = Privacy.PUBLIC;
	private final String url;
	
	public Board(String boardName, int ID, String url) {
		super(boardName,ID,EntityType.BOARD);
		this.url = url;
	}
	
	public String getURL() {
		return url;
	}
	
	public Privacy getPrivacy() {
		return privacyType;
	}
	
		@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " +  this.getID();
	}
	
}
