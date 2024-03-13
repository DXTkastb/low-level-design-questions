package lld.splitwise;
import java.lang.Math;
import java.util.*;

public class EqualTransactionStrategy implements TransactionStrategy {
	public List<AtomicTransaction> process(Expense expense) {
		double totalAmount = 0.0;
		Map<Integer,Double> payeeMembers = expense.getPayees();
		for(int payee : payeeMembers.keySet()) {
			totalAmount += payeeMembers.get(payee);
		}
		List<Integer> billMembers = expense.getBillMembers();
		Set<Integer> setOfbillMembers = new HashSet<>(billMembers);
		int totalBillMembers = billMembers.size();
		double equalAmount = (double)totalAmount/totalBillMembers;	
		
		
		List<AtomicTransaction> list = new ArrayList<>();

		PriorityQueue<TransactionMember> memberToPay = new PriorityQueue<>(
			(a,b) -> {
				return Double.compare(a.getAmount(),b.getAmount())*-1;
			}
		);
		PriorityQueue<TransactionMember> memberToTake = new PriorityQueue<>(
			(a,b) -> {
				return Double.compare(a.getAmount(),b.getAmount())*-1;
			}
		);	
			
		for(int billMember : billMembers) {
			double amountPaid = payeeMembers.getOrDefault(billMember,0.0);
			if(amountPaid >= equalAmount) continue;
			memberToPay.add(new TransactionMember(equalAmount - amountPaid,billMember));
		} 
		for(int payeeMember : payeeMembers.keySet()) {
			double amountPaid = payeeMembers.getOrDefault(payeeMember,0.0);
			if(amountPaid > equalAmount) {
				if(setOfbillMembers.contains(payeeMember))
					memberToTake.add(new TransactionMember(amountPaid - equalAmount,payeeMember));
				else {
					memberToTake.add(new TransactionMember(amountPaid,payeeMember));
				}
			} 		
		}
		boolean infinite = true;
		
		while(memberToPay.size() > 0 && memberToTake.size() > 0) {
			TransactionMember mpay = memberToPay.poll();
			TransactionMember mtake = memberToTake.poll();
			double amountTransferred = 0.0;
			if(mpay.getAmount() > mtake.getAmount()) {
			
				amountTransferred = mtake.getAmount();
				memberToPay.add(
				new TransactionMember(mpay.getAmount() - mtake.getAmount(),mpay.getId()));
			}
			else if(mpay.getAmount() < mtake.getAmount()) {
				amountTransferred = mpay.getAmount();
				memberToTake.add(new TransactionMember(mtake.getAmount() - mpay.getAmount(),mtake.getId()));
			}
			else {
				amountTransferred = mpay.getAmount();
			}
			list.add(AtomicTransaction.getAtomicTransaction(mpay.getId(),mtake.getId(),amountTransferred));	
		}
		
		return list;
	}
	
	
	// Implement NP Hard DFS for minimum transactions!!!

}

