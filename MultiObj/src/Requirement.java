
public class Requirement {

	// The level of each individual req !total number of levels
	private int level = 0;
	// Number requirements per individual level (as above)
	private int numReq = 0;
	// Cost of requirements per individual level (as above)
	private int costReq = 0;

	/**
	 * Individual Requirements
	 * 
	 * @param level
	 * @param numReq
	 * @param costReq
	 */
	public Requirement(int level, int numReq, int costReq) {
		this.setLevel(level);
		this.setNumReq(numReq);
		this.setCostReq(costReq);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumReq() {
		return numReq;
	}

	public void setNumReq(int numReq) {
		this.numReq = numReq;
	}

	public int getCostReq() {
		return costReq;
	}

	public void setCostReq(int costReq) {
		this.costReq = costReq;
	}
}
