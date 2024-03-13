package lld.splitwise;
import java.util.*;

class UpdateService {
	private UserTransactionDirectoryInterface userDirectory = UserTransactionDirectoryImpl.getDirectoryInstance();
	private static UpdateService service;
	private UpdateService() {
	
	}
	
	public static UpdateService getService() {
		if(service == null) service = new UpdateService();
		return service;
	} 
	
	public void updateDirectory(Expense expense, List<AtomicTransaction> transactions) {
		for(AtomicTransaction transaction : transactions) {
			int user1 = transaction.getUser1();
			int user2 = transaction.getUser2();
			
			double amount = transaction.getAmount();
			UserExpenseData ued1 = userDirectory.getUserData().getOrDefault(user1,new UserExpenseData());
			UserExpenseData ued2 = userDirectory.getUserData().getOrDefault(user2,new UserExpenseData());
			
			ued1.getExpenses().add(expense);
			ued2.getExpenses().add(expense);			
			
			ued1.getAmountData().put(user2, ued1.getAmountData().getOrDefault(user2,0.0) + amount);
			ued2.getAmountData().put(user1, ued2.getAmountData().getOrDefault(user1,0.0) - amount);
			
			userDirectory.getUserData().put(user1,ued1);
			userDirectory.getUserData().put(user2,ued2);
		}
	}
	
	
}
