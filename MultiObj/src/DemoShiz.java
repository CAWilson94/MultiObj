import org.opt4j.core.genotype.BooleanGenotype;

public class DemoShiz {

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
	}
}
