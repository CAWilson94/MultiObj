
public class Demo {

	public static void main(String[] args) {
		// Parse file First
		// Create population
		// Evaluate fitness
		FileParser fp = new FileParser();
		fp.parseFile();

		NRP nrp = fp.parseFile();

		for (Customer c : nrp.getCustomers()) {
			System.out.println(c.getReqList());
		}
	}
}
