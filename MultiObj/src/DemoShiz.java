import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opt4j.core.genotype.BooleanGenotype;

/**
 * 
 * @author Charlotte Wilson
 * 
 *         To evaluate the score: Weight = profit from customer Value customer
 *         places on requirement = position of requirement in reqList
 * 
 *         Thus, you want to go through all customers and do : weight * value
 *         Then sum dat shit together
 *
 */

public class DemoShiz {

	public void halp(String phenotype, NRP nrp) {
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				huntforReqScore(i, nrp);
			}
		}
	}

	/**
	 * Hunts for all scores from all customers for one requirement
	 * 
	 * @param position
	 * @param nrp
	 * @return List<Integer> current batch of scores from that requirement
	 */
	private List<Integer> huntforReqScore(int position, NRP nrp) {
		List<Customer> customerList = nrp.getCustomers();
		int i = 0;
		int score = 0;
		List<Integer> scoresCurrent = new ArrayList<Integer>();
		for (Customer n : customerList) {
			if (n.getReqList().contains(position)) {
				if (Constants.DEBUG_SCORES == true) {
					System.out.println("r: " + position + " wc: " + n.getProfit() + " v: "
							+ customerValueOnReq(position, n.getReqList()) + " :  " + n.getCustomerLabel());
				}
				// TODO: check this is right
				score = n.getProfit() * customerValueOnReq(position, n.getReqList());
				scoresCurrent.add(score);
			}
			i++;
		}
		return scoresCurrent;
	}

	/**
	 * Gets the customer value placed on a requirement
	 * 
	 * @param requirement
	 * @param reqList
	 * @return
	 */
	private int customerValueOnReq(int requirement, List<Integer> reqList) {
		// TODO: write a version of this that works for the realistic data set
		int weight = 0;
		int fraction = reqList.size() + 1;
		int reqPos = reqList.indexOf(requirement);
		weight = 100 - reqPos * fraction;
		return weight;
	}

	public static void main(String[] args) {
		FileParser fp = new FileParser();
		NRP nrp = fp.parseFile();

		NRPCreator c = new NRPCreator();
		NRPDecoder d = new NRPDecoder();
		BooleanGenotype boop = c.create();
		// System.out.println(boop);
		String booping = d.decode(boop);
		// System.out.println(booping);

		DemoShiz d1 = new DemoShiz();
		System.out.println("now for scores: ");
		d1.halp(booping, nrp);
		// /d1.customerValueOnReq(85, nrp.getCustomers().get(0).getReqList());
		// TODO: seems to be fetching requirements list wrong
		/*
		 * for (Customer n : nrp.getCustomers()) { System.out.println(" wc: " +
		 * n.getProfit() + "	" + n.getReqList().toString()); }
		 */
	}

}
