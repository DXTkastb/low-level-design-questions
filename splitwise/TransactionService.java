package lld.splitwise;

public interface TransactionService {
	public void addTransactionStrategy(String billType, TransactionStrategy strategy);
	public void resolveExpense(Expense expense);
	//	public void updateDirectory(List<AtomicTransaction> listOfTransactions);
	//	public List<AtomicTransaction> processExpense(Expense expense);
}
