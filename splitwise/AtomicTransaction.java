package lld.splitwise;

class AtomicTransaction {
	private int user1ID;
	private int user2ID;
	// amount user1ID has to pay to user2ID
	private double amount;
	public AtomicTransaction(int u1, int u2, double amount) {
		this.user1ID = u1;
		this.user2ID = u2;
		this.amount = amount;
	}
	public int getUser1() {
		return user1ID;
	}
	public int getUser2() {
		return user2ID;
	}
	public double getAmount() {
		return amount;
	}
	
	public static AtomicTransaction getAtomicTransaction(int u1, int u2, double amount) {
		return new AtomicTransaction(u1,u2,amount);
	}
	
	@Override
	public String toString() {
		return user1ID + ":"+user2ID+":"+amount;
	}
}
