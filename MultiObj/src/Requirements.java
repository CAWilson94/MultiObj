import java.util.ArrayList;
import java.util.List;

public class Requirements {

	private int numReq = 0;
	private List<String> costs = new ArrayList<String>();
	private int level = 0;

	/**
	 * To aid my laziness
	 */
	public Requirements() {

	}

	public Requirements(int numReq, List<String> costs, int level) {
		this.numReq = numReq;
		this.costs = costs;
		this.level = level;
	}

	public int getNumReq() {
		return numReq;
	}

	public void setNumReq(int numReq) {
		this.numReq = numReq;
	}

	public List<String> getCosts() {
		return costs;
	}

	public void setCosts(List<String> costs) {
		this.costs = costs;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
