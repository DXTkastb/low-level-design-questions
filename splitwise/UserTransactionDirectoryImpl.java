package lld.splitwise;
import java.util.*;

public class UserTransactionDirectoryImpl implements UserTransactionDirectoryInterface {
	private Map<Integer,UserExpenseData> usertransactionDirectory;
	private static UserTransactionDirectoryImpl directory;
	private	UserTransactionDirectoryImpl() {
		usertransactionDirectory = new HashMap<>();
	}
	
	public static UserTransactionDirectoryImpl getDirectoryInstance() {
		if(directory == null)
			directory = new UserTransactionDirectoryImpl();
		return directory;
	}
	
	public Map<Integer,UserExpenseData> getUserData() {
		return usertransactionDirectory;
	}
	
}
