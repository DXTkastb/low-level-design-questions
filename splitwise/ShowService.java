package lld.splitwise;
import java.lang.Math;
import java.util.*;

class ShowService {
	private UserTransactionDirectoryInterface userDirectory = UserTransactionDirectoryImpl.getDirectoryInstance();
	private ShowService() {}
	private static ShowService service;
	
	public static ShowService getService() {
		if(service == null) service = new ShowService();
		return service;
	}
	
	public void showUserAmountData(int userId) {
		Map<Integer,Double> data = userDirectory.getUserData().get(userId).getAmountData();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int userID : data.keySet()) {
			double amount = data.get(userID);
			if(amount == 0.0) continue;
			String result = "";
			if(amount > 0.0)
				result = (userId + " owes " + userID + ":" + amount);
			else result = (userID + " owes " + userId + ":" + Math.abs(amount));
			System.out.println(result);
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	public void showUserExpenses(int userId) {
		List<Expense> data = userDirectory.getUserData().get(userId).getExpenses();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(Expense uniqueExpense : data) {
			System.out.println(uniqueExpense);
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");		
	}	
}
