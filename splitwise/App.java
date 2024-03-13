package lld.splitwise;
import java.util.*;
public class App {

	private final ShowService showService = ShowService.getService();
	private final TransactionService transactionService = TransactionServiceImpl.getService();
	
	public static void main(String[] args) {
		App app = new App();
		app.makeTransaction();
		app.showUserData(1);
		app.showUserExpenses(1);
	}
	
	public void makeTransaction() {
		TransactionStrategy transactionStrategy = new EqualTransactionStrategy();
		transactionService.addTransactionStrategy("EQUAL",transactionStrategy);
		Map<Integer,Double> payees = new HashMap<>();
		payees.put(1,300.0);
		List<Integer> billpayees = new ArrayList<>();
		billpayees.add(2);billpayees.add(3);
		String type = "EQUAL";
		List<Double> paidData = Arrays.asList(0.0,50.0);
		Expense expense = new Expense(payees,billpayees,type,paidData);
		transactionService.resolveExpense(expense);	
	}
	
	public void showUserData(int userId) {
		showService.showUserAmountData(1);
		showService.showUserAmountData(2);
		showService.showUserAmountData(3);
	}
	
	public void showUserExpenses(int userId){
		
	}
	
}

