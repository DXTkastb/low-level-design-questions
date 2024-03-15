package lld.trello;

class TrelloApp {
	public static void main(String[] args) {
		AssignService asg = AssignService.getService();
		DeletionService del = DeletionService.getService();
		IdGenerationService idg = IdGenerationService.getService();
		ShowService service = ShowService.getService();
		ProjectEntity p1 = new Milestone("mp1",45,"OOFSDF");
		ProjectEntity p2 = new Board("b1",92,"asd");
		ProjectEntity p3 = new Task("tp1",1125,"OYYYYDF");		
		ProjectEntity p4 = new User("uu1",11,"User");
		ProjectEntity p46 = new User("uu1",221,"User");
		ProjectEntity p5 = new Project("p1",65,"SDFSDF");
		StoreService storeService = StoreService.getService();
		storeService.saveProjectEntity(221,p46);
		storeService.saveProjectEntity(45,p1);
		storeService.saveProjectEntity(92,p2);
		storeService.saveProjectEntity(1125,p3);
		storeService.saveProjectEntity(11,p4);
		storeService.saveProjectEntity(65,p5);
		
		asg.assign(221,1125);
		asg.assign(11,1125);
		asg.assign(1125,45); 
		asg.assign(45,65); 
		asg.assign(65,92);  
		
		service.showProjectEntity(92); service.showProjectEntityVerbose(45) ;
		service.showProjectEntity(42); service.showProjectEntityVerbose(92) ;
		
		del.deleteEntity(65);
		service.showProjectEntityVerbose(221) ;
// 		ProjectEntity p = new ();		92	
	}
}
