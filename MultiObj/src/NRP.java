/**
 * NRP instance to be generated
 * 
 * @author Charlotte Wilson
 *
 */
public class NRP {
	
	private int reqLevel = 0;
	private int numReq = 0;
	private int reqCost = 0;
	
	public NRP(int reqLevel, int numReq, int reqCost){
		
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

}
