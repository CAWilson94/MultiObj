
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.Objective.Sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.opt4j.core.Objectives;

public class NRPBOOPEvaluator implements Evaluator<String> {

	@Override
	public Objectives evaluate(String phenotype) {

		FileParser fp = new FileParser();
		NRP nrp = fp.parseFile();

		Objectives objectives = new Objectives();
		objectives.add("Cost", Sign.MIN, individualCost(phenotype, nrp));
		objectives.add("Scores", Sign.MAX, individualScore(phenotype, nrp));
		return objectives;
	}

	public double individualScore(String phenotype, NRP nrp) {
		double indiScore = 0;
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				// Your score vector
				double score = 0;
				for (Customer n : nrp.getCustomers()) {
					if (n.getReqList().contains(i)) {
						double boop = n.getProfit();
						double totalpr = getTotalProfit(nrp);
						double profit = boop / totalpr;
						System.out.println("profit weighting: " + profit);
						score += profit * customerValueOnRequirement(i, n.getReqList());
					}
				}
				System.out.println(score);
				indiScore = score;
			}
		}
		System.out.println("indiScore");
		System.out.println(indiScore);
		return indiScore;

	}

	/**
	 * TODO: change this so duplicates work..
	 * 
	 * @param phenotype
	 * @param nrp
	 * @return
	 */
	public int individualCost(String phenotype, NRP nrp) {
		int cost = 0;
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				cost += nrp.getAllCosts().get(i);
				System.out.println("cost is: " + nrp.getAllCosts().get(i) + " position : " + i);
				// cost = huntforCost(i, nrp);
			}
		}
		System.out.println("cost");
		System.out.println(cost);
		return cost;
	}

	/**
	 * Gets the customer value placed on a requirement
	 * 
	 * @param requirement
	 * @param reqList
	 * @return
	 */
	public int customerValueOnReq(int requirement, List<Integer> reqList) {
		// TODO: write a version of this that works for the realistic data set
		int weight = 0;
		int fraction = 100 / reqList.size();
		int reqPos = reqList.indexOf(requirement);
		weight = 100 - (reqPos * fraction);
		return weight;
	}

	private double customerValueOnRequirement(int requirement, List<Integer> reqList) {
		double value = 0;
		value = reqList.size() - reqList.indexOf(requirement);
		return value;

	}

	private int getTotalProfit(NRP nrp) {
		int totalProfit = 0;
		for (Customer profit : nrp.getCustomers()) {
			totalProfit += profit.getProfit();
		}

		System.out.println("total pro: " + totalProfit);
		return totalProfit;
	}
}
