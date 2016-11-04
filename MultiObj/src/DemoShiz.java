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

	public void finalScore(String phenotype, NRP nrp) {
		List<Integer> finalScores = new ArrayList<Integer>();
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				// Your score vector
				finalScores.add(huntforReqScore(i, nrp));
			}
		}
		System.out.println(finalScores.toString());
	}

	public int individualScore(String phenotype, NRP nrp) {
		int indiScore = 0;
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				// Your score vector
				indiScore = huntforReqScore(i, nrp);
			}
		}
		System.out.println(indiScore);
		return 0;

	}

	/**
	 * Hunts for all scores from all customers for one requirement
	 * 
	 * @param position
	 * @param nrp
	 * @return List<Integer> current batch of scores from that requirement
	 */
	private int huntforReqScore(int position, NRP nrp) {
		List<Customer> customerList = nrp.getCustomers();
		int i = 0;
		int score = 0;
		int scoresCurrent = 0;
		for (Customer n : customerList) {
			if (n.getReqList().contains(position)) {

				if (Constants.DEBUG_SCORES == true) {
					System.out.println("r: " + position + " wc: " + n.getProfit() + " v: "
							+ customerValueOnReq(position, n.getReqList()));
				}
				// TODO: check this is right
				score += n.getProfit() * customerValueOnReq(position, n.getReqList());
				// TODO: Need to get the duplicates and sum the score of them
				// all together!
			}
			i++;
		}

		scoresCurrent = score;
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
		int fraction = 100 / reqList.size();
		int reqPos = reqList.indexOf(requirement);
		weight = 100 - (reqPos * fraction);
		return weight;
	}

	public static void main(String[] args) {
		FileParser fp = new FileParser();
		NRP nrp = fp.parseFile();

		NRP_2Creator c = new NRP_2Creator();
		NRP_2Decoder d = new NRP_2Decoder();
		BooleanGenotype boop = c.create();
		// System.out.println(boop);
		String booping = d.decode(boop);
		// System.out.println(booping);

		DemoShiz d1 = new DemoShiz();
		System.out.println("now for scores: ");
		// d1.finalScore(booping, nrp);
		System.out.println(d1.huntforReqScore(128, nrp));
	}

}
