package lld.splitwise;
import java.util.*;

public class UserExpenseData {
	private List<Expense> expenses = new ArrayList<>();
	private Map<Integer,Double> amountData = new HashMap<>();
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	public Map<Integer,Double> getAmountData() {
		return amountData;
	}
}
