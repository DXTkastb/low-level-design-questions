package lld.splitwise;
import java.util.*;

public interface TransactionStrategy {
	public List<AtomicTransaction> process(Expense expense);
}
