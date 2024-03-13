package lld.splitwise;
import java.util.*;

public class Expense {
	private final Map<Integer,Double> payeeMembers;
	private final List<Integer> billMembers;
	private final String billType;
	private final List<Double> partitionData;
	
	public Expense(Map<Integer,Double> payees, List<Integer> billpayees, String type, List<Double> pData) {
		payeeMembers = payees;
		billMembers = billpayees;
		billType = type;
		partitionData = pData;	
	}
	
	public Map<Integer,Double> getPayees() {
		return payeeMembers;
	}
	
	public List<Integer> getBillMembers() {
		return billMembers;
	}
	
	public String getBillType() {
		return billType;
	}
	
	public List<Double> getPartitionData() {
		return partitionData;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int userID : payeeMembers.keySet()) {
			result = userID + " " + payeeMembers.get(userID) + " ";
		}	
		for(int userID : billMembers) result = result + userID + " ";
		result = result + billType + " ";
		for(double partition : partitionData) result = result + partition + " ";
		return result;
	}
}

