package lld.splitwise;
import java.util.*;

public class TransactionServiceImpl implements TransactionService {
	private UpdateService updateService = UpdateService.getService();
	private Map<String,TransactionStrategy> strategyList = new HashMap<>();
	private static TransactionServiceImpl service;
	
	private TransactionServiceImpl() {
	}
	
	public static TransactionServiceImpl getService	() {
		if(service == null) service = new TransactionServiceImpl();
		return service;
	}
	
	public void resolveExpense(Expense expense) {
		List<AtomicTransaction> atomicList = processExpense(expense);
		updateDirectory(expense,atomicList);
	}
	
	public void addTransactionStrategy(String billType, TransactionStrategy strategy) {
		strategyList.put(billType,strategy);
	}
	
	private List<AtomicTransaction> processExpense(Expense expense) {
		TransactionStrategy strategy = strategyList.get(expense.getBillType());
		return strategy.process(expense);
	}
		
	private void updateDirectory(Expense expense, List<AtomicTransaction> listOfTransactions){
		updateService.updateDirectory(expense,listOfTransactions);
	}

}
