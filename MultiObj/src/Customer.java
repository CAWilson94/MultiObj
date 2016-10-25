import java.util.ArrayList;
import java.util.List;

public class Customer {

	private int profit = 0;
	private int Numrequests = 0;
	private int customerLabel = 0;
	private List<Integer> reqList = new ArrayList<Integer>();

	/**
	 * Individual Customers
	 * 
	 * @param profit
	 * @param requests
	 * @param reqList
	 */
	public Customer(int profit, int Numrequests, List<Integer> reqList, int customerLabel) {
		this.setProfit(profit);
		this.setNumRequests(Numrequests);
		this.setReqList(reqList);
		this.setCustomerLabel(customerLabel);
	}

	/**
	 * Lazy wild constructor to accommodate all your lazy needs
	 */
	public Customer() {

	}

	public int getCustomerLabel() {
		return customerLabel;
	}

	public void setCustomerLabel(int customerLabel) {
		this.customerLabel = customerLabel;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getNumRequests() {
		return Numrequests;
	}

	public void setNumRequests(int requests) {
		this.Numrequests = requests;
	}

	public List<Integer> getReqList() {
		return reqList;
	}

	public void setReqList(List<Integer> reqList) {
		this.reqList = reqList;
	}
}
