package lld.splitwise;
import java.lang.Math;

public class TransactionMember {
	private double amount = 0;
	private	int userId;
	TransactionMember(double amount, int id) {
		this.amount = amount;
		this.userId = id;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getId() {
		return userId;
	}
	
}

