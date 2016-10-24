import java.util.ArrayList;
import java.util.List;

public class Customer {

	int profit = 0;
	int requests = 0;
	List<Integer> reqList = new ArrayList<Integer>();

	/**
	 * Individual Customers
	 * 
	 * @param profit
	 * @param requests
	 * @param reqList
	 */
	public Customer(int profit, int requests, List<Integer> reqList) {
		this.profit = profit;
		this.requests = requests;
		this.reqList = reqList;
	}
}
