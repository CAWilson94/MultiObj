import java.util.ArrayList;
import java.util.List;

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
	private int totalProfit = 0;
	// Requirements list for A column
	private List<Integer> IDReqA = new ArrayList<Integer>();
	// Requirements list for B column
	private List<Integer> IDReqB = new ArrayList<Integer>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Requirements> requirements = new ArrayList<Requirements>();
	private List<Integer> allCosts = new ArrayList<Integer>();

	/**
	 * Basically I am lazy and would like the option to make this in any
	 * destructive manner I wish
	 */
	public NRP() {

	}

	/**
	 * NRP with all attributes specified
	 * 
	 * @param reqLevel
	 * @param numReq
	 * @param reqCost
	 * @param dependancies
	 * @param numCustomers
	 */
	public NRP(int reqLevel, int numReq, int reqCost, int dependancies, int numCustomers) {

	}

	/**
	 * Get requirement level max i.e. total
	 * 
	 * @return int reqLevel
	 */
	public int getReqLevel() {
		return reqLevel;
	}

	/**
	 * Set requirement level: should never need this...
	 * 
	 * @param reqLevel
	 */
	public void setReqLevel(int reqLevel) {
		this.reqLevel = reqLevel;
	}

	/**
	 * Get number of requirements
	 * 
	 * @return int numReq
	 */
	public int getNumReq() {
		return numReq;
	}

	/**
	 * Set number of requirements: should never need this..
	 * 
	 * @param numReq
	 */
	public void setNumReq(int numReq) {
		this.numReq = numReq;
	}

	/**
	 * Get cost for a given requirement
	 * 
	 * @return int reqCost
	 */
	public int getReqCost() {
		return reqCost;
	}

	/**
	 * Set cost for a given requirement: should never need this..
	 * 
	 * @param reqCost
	 */
	public void setReqCost(int reqCost) {
		this.reqCost = reqCost;
	}

	/**
	 * Get number of dependencies for overall NRP file
	 * 
	 * @return int dependencies
	 */
	public int getDependancies() {
		return dependancies;
	}

	/**
	 * Set the number of dependencies: shouldn't need this unless testing .. or
	 * you are just wild
	 * 
	 * @param dependancies
	 */
	public void setDependancies(int dependancies) {
		this.dependancies = dependancies;
	}

	/**
	 * Get number of customers
	 * 
	 * @return int numCustomers
	 */
	public int getNumCustomers() {
		return numCustomers;
	}

	/**
	 * Set number customers: usual warning..
	 * 
	 * @param numCustomers
	 */
	public void setNumCustomers(int numCustomers) {
		this.numCustomers = numCustomers;
	}

	/**
	 * Get the ID's for column A of file
	 * 
	 * @return List<Integer> IDReqA
	 */
	public List<Integer> getIDReqA() {
		return IDReqA;
	}

	/**
	 * Set ID's for column A of file: usual warning..
	 * 
	 * @param iDReqA
	 */
	public void setIDReqA(List<Integer> iDReqA) {
		IDReqA = iDReqA;
	}

	/**
	 * Get the ID's for column B of file
	 * 
	 * @return List<Integer> IDReqB
	 */
	public List<Integer> getIDReqB() {
		return IDReqB;
	}

	/**
	 * Set ID's for column A of file: usual warning..
	 * 
	 * @param iDReqB
	 */
	public void setIDReqB(List<Integer> iDReqB) {
		IDReqB = iDReqB;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirements> level) {
		this.requirements = level;
	}

	public List<Integer> getAllCosts() {
		return allCosts;
	}

	public void setAllCosts(List<Integer> allCosts) {
		this.allCosts = allCosts;
	}

}
