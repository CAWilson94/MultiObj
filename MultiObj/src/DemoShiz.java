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
		List<Customer> dupReqs = new ArrayList<Customer>();
		for (int i = 0; i < phenotype.length(); i++) {
			if (phenotype.charAt(i) == '1') {
				huntforReq(i, nrp);
			}
		}
	}

	private Customer huntforReq(int position, NRP nrp) {
		List<Customer> customerList = nrp.getCustomers();
		int i = 0;
		for (Customer n : customerList) {
			if (n.getReqList().contains(position)) {
				System.out.println("found a requirement: " + i + " weight of customer is: " + n.getProfit()
						+ "with weight: " + getDatWeight(position, n.getReqList()));
			}
			// Store all into a temp array to work on after?
			i++;
		}
		return null;
	}

	private int getDatWeight(int requirement, List<Integer> reqList) {
		int weight = 0;
		int reqPos = reqList.indexOf(requirement);
		int[] weights = { 100, 75, 50, 25 };
		weight = weights[reqPos];
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

		for (Customer n : nrp.getCustomers()) {
			int j = 0;
			for (int i = 0; i < n.getReqList().size(); i++) {
				if (yermaw[j] == '0') {
					System.out.println("boop");
				}
				j++;
			}
		}

		System.out.println("\n now for weights\n");

		DemoShiz d1 = new DemoShiz();

		System.out.println("requirement hunting\n");
		d1.huntforReq(104, nrp);
	}

}
