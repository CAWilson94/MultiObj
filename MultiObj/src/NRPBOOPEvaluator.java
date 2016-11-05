
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.Objective.Sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.opt4j.core.Objectives;
import org.opt4j.core.genotype.BooleanGenotype;

public class NRPBOOPEvaluator implements Evaluator<String> {

	FileParser fp = new FileParser();
	NRP nrp = fp.parseFile();

	@Override
	public Objectives evaluate(String phenotype) {

		Objectives objectives = new Objectives();
		objectives.add("Cost", Sign.MIN, individualCost(phenotype));
		objectives.add("Scores", Sign.MAX, individualScore(phenotype));
		return objectives;
	}

	/**
	 * Score of an indvidual
	 * 
	 * @param phenotype
	 * @param nrp
	 * @return int individual score
	 */
	public double individualScore(String phenotype) {
		double indiScore = 0;
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				System.out.println("position at : " + i);
				// Your score vector
				double score = 0;
				for (Customer n : nrp.getCustomers()) {
					if (n.getReqList().contains(i)) {
						double boop = n.getProfit();
						double totalpr = getTotalProfit(nrp);
						double profit = boop / totalpr;
						System.out.println("requirement: " + i + " actual profit: " + boop + " profit weighting: "
								+ profit + " value: " + customerValueOnRequirement(i, n.getReqList()));
						score += profit * customerValueOnRequirement(i, n.getReqList());
					}
				}
				System.out.println("score is: " + score);
				indiScore = score;
			}
		}
		return indiScore;
	}

	/**
	 * 
	 * @param phenotype
	 * @param nrp
	 * @return
	 */
	public int individualCost(String phenotype) {
		int cost = 0;
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				cost += nrp.getAllCosts().get(i);
				System.out.println("boop" + nrp.getDependancies());
				System.out.println("cost is: " + nrp.getAllCosts().get(i) + " position : " + i);
			}
		}
		System.out.println("cost");
		System.out.println(cost);
		return cost;
	}

	/**
	 * Get the profit of all customers
	 * 
	 * @param nrp
	 * @return
	 */
	private int getTotalProfit(NRP nrp) {
		int totalProfit = 0;
		for (Customer profit : nrp.getCustomers()) {
			totalProfit += profit.getProfit();
		}
		System.out.println("total pro: " + totalProfit);
		return totalProfit;
	}

	/**
	 * Get value of a requirement for a single customer
	 * 
	 * @param requirement
	 * @param reqList
	 * @return
	 */
	public double customerValueOnRequirement(int requirement, List<Integer> reqList) {
		double value = 0;
		if (reqList.contains(requirement)) {
			value = reqList.size() - reqList.indexOf(requirement);
			return value;
		} else {
			value = 0;
			return value;
		}
	}

	public static void main(String[] args) {
		FileParser fp = new FileParser();
		NRP nrp = fp.parseFile();
		NRPBOOPEvaluator bop = new NRPBOOPEvaluator();
		NRPBOOPCreator create = new NRPBOOPCreator();
		// BooleanGenotype genotype = create.create();
		// NRPBOOPDecoder decode = new NRPBOOPDecoder();
		// String phenotype = decode.decode(genotype);

		String phenotype = "001";

		System.out.println("COST IS: " + bop.individualScore(phenotype));

	}

}
