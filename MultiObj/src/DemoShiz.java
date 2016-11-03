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

	public List<Integer> ints = new ArrayList<Integer>();

	public void score(String phenotype) {
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '0') {
				System.out.println("nawwwwwwwwwwwwww");
			}
		}
	}

	public void getWeightCustom(List<Customer> customers) {

		for (int i = 0; i < customers.size(); i++) {
			System.out.println("weight of customer is : " + i);
		}

	}

	public void scoreShit(String phenotype, NRP nrp) {

		int score = 0;
		int weight = 0;
		int value = 0;

		for (int k = 0; k < nrp.getCustomers().size(); k++) {
			int j = 0;
			for (int i = 0; i < nrp.getCustomers().get(k).getReqList().size(); i++) {
				if (phenotype.charAt(j) == '1') {
					System.out.println("phenotype pos is: " + phenotype.charAt(j));
					System.out.println("customer position is: " + i);
					System.out.println("Need to search all customers for " + j);
					weight = nrp.getCustomers().get(k).getProfit();
					score = weight * value; // Assuming this is correct
					System.out.println("score is: " + score);
				}
				j++;
			}
		}
	}

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
				// if (Constants.DEBUG == true) {
				System.out.println("found a requirement: " + i + " weight of customer is: " + n.getProfit()
						+ "with value of req: " + customerValueOnReq(position, n.getReqList()));
				// }
				// TODO: check this is right.
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
		System.out.println(reqPos);
		for (int n : reqList) {
			System.out.println(n);
		}
		weight = 100 - reqPos * fraction;
		return weight;
	}

	public static void main(String[] args) {
		FileParser fp = new FileParser();
		NRP nrp = fp.parseFile();

		NRPCreator c = new NRPCreator();
		NRPDecoder d = new NRPDecoder();
		BooleanGenotype boop = c.create();
		System.out.println(boop);
		String booping = d.decode(boop);
		System.out.println(booping);
		char[] yermaw = booping.toCharArray();

		System.out.println("test requirements list:");
		for (Customer n : nrp.getCustomers()) {
			int j = 0;
			for (int i = 0; i < n.getReqList().size(); i++) {
				System.out.println(n.getReqList().get(i));
				j++;
			}
		}
		DemoShiz d1 = new DemoShiz();
		System.out.println("now for scores: ");
		// d1.halp(booping, nrp);
		d1.customerValueOnReq(66, nrp.getCustomers().get(2).getReqList());
		// TODO: seems to be fetching requirements list wrong

	}

}
