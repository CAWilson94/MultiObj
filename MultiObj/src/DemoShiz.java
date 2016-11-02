import java.util.List;

import org.opt4j.core.genotype.BooleanGenotype;

public class DemoShiz {

	public void score() {

		/**
		 * Set of weights for each customer
		 * 
		 */

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
		
		}
		
	}

