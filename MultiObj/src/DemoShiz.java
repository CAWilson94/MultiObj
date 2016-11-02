import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opt4j.core.genotype.BooleanGenotype;

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

		d1.getWeightCustom(nrp.getCustomers());

		System.out.println("score testing");

		d1.score(booping);

	}

}
