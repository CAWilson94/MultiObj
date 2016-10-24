/**
 * NRP instance to be generated
 * 
 * The predefined budget bound is calculated as the cost ratio multiplied the
 * sum of all the requirements costs.
 * 
 * i.e. int preDefBudget = Constants.COST_RATIO * sum(reqCost)
 * 
 * @author Charlotte Wilson
 *
 */
public class NRP {

	private int reqLevel = 0;
	private int numReq = 0;
	private int reqCost = 0;
	private int dependancies = 0;
	private int numCustomers = 0;

	public NRP(int reqLevel, int numReq, int reqCost, int dependancies, int numCustomers) {

	}

	public int getReqLevel() {
		return reqLevel;
	}

	public void setReqLevel(int reqLevel) {
		this.reqLevel = reqLevel;
	}

	public int getNumReq() {
		return numReq;
	}

	public void setNumReq(int numReq) {
		this.numReq = numReq;
	}

	public int getReqCost() {
		return reqCost;
	}

	public void setReqCost(int reqCost) {
		this.reqCost = reqCost;
	}

	public int getDependancies() {
		return dependancies;
	}

	public void setDependancies(int dependancies) {
		this.dependancies = dependancies;
	}

	public int getNumCustomers() {
		return numCustomers;
	}

	public void setNumCustomers(int numCustomers) {
		this.numCustomers = numCustomers;
	}

}
