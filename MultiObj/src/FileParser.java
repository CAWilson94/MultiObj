import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parsing in data files
 * 
 * @author Charlotte Wilson
 * 
 *         Get attributes of file into an NRP object :D
 * 
 *         1: Read in Req Level 2: Num and cost requirements in each level 3:
 *
 */
public class FileParser {

	NRP nrp = new NRP();
	public List<Customer> customersList = new ArrayList<Customer>();
	public List<Integer> IDReqA = new ArrayList<Integer>();
	public List<Integer> IDReqB = new ArrayList<Integer>();

	/**
	 * Parsing the file into something more useful
	 */
	public void parseFile() {

		BufferedReader br = null;
		String currentLine;
		int counter = 0;
		int customerCount = 0;

		try {
			br = new BufferedReader(new FileReader(Constants.FILE_NAME));
			while ((currentLine = br.readLine()) != null) {
				counter++; // Skips line 0
				if (counter == 1) {
					System.out.println(currentLine + " Num requirements");
					nrp.setReqLevel(Integer.parseInt(currentLine));
					int reqCounter = Integer.parseInt(currentLine) * 2;

					// go through cost and level for each requirement
					while (reqCounter != 0) {
						if (reqCounter % 2 == 0) {
							// save the num req for that specific requirement
						} else if (reqCounter % 2 != 0) {
							// save the cost for that specific requirement
						}
						System.out.println(br.readLine());
						reqCounter--; 
					}
					System.out.println("should be num dependancies.. " + br.readLine());
				}

				// Go through all the ID's
				int words = 0;
				words += currentLine.split("\\s+").length;
				while (words == 2) {
					IDExtraction(currentLine);
					words = 0;
				}
				nrp.setIDReqA(IDReqA);
				nrp.setIDReqB(IDReqB);

				// Customer attributes
				while (words > 2) {
					customerCount++;
					customerAttributeExtraction(customerCount, currentLine);
					words = 0;
				}
				nrp.setCustomers(customersList);
			}

			System.out.println("number of customers is: " + customerCount);
			nrp.setNumCustomers(customerCount);

			br.close();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		debug();

	}

	/**
	 * Extracting ID's from column A and column B and storing them in NRP object
	 */
	private void IDExtraction(String currentLine) {
		System.out.println(currentLine);
		String[] tokens = currentLine.split("\\s+");
		// Need to add to ID A list in NRP
		System.out.println(tokens[0] + " First ID");
		IDReqA.add(Integer.parseInt(tokens[0]));
		// Need to add to ID B list in NRP
		System.out.println(tokens[1] + " Second ID");
		IDReqB.add(Integer.parseInt(tokens[1]));
	}

	/**
	 * Extracting different customer attributes, saving each customer and adding
	 * customer list to NRP object
	 */
	private void customerAttributeExtraction(int customerCount, String currentLine) {
		System.out.println(customerCount + "customer count");
		// Just to keep track of the right things..
		Customer customer = new Customer();
		customer.setCustomerLabel(customerCount);

		// Split line into different attributes
		String[] tokens = currentLine.split("\\s+");

		System.out.print(" profit: " + tokens[0]);
		customer.setProfit(Integer.parseInt(tokens[0]));
		System.out.print(" num requests: " + tokens[1]);
		customer.setNumRequests(Integer.parseInt(tokens[1]));

		String[] subTokens = Arrays.copyOfRange(tokens, 2, tokens.length);
		System.out.println(" Request List: " + java.util.Arrays.toString(subTokens));
		List<Integer> reqList = new ArrayList<Integer>();
		for (String s : subTokens) {
			reqList.add(Integer.parseInt(s));
		}
		customer.setReqList(reqList);
		System.out.println("\n");
		customersList.add(customer);

	}

	/**
	 * Just some debugging ... nothing to see here
	 */
	private void debug() {

		// Testing all the things
		if (Constants.DEBUG == true) {
			System.out.println(nrp.getReqLevel() + " in the object yoooo");
			System.out.println(nrp.getNumCustomers() + " is num customers in object");

			System.out.println("customers list: ");
			for (Customer c : nrp.getCustomers()) {
				System.out.println(c.getCustomerLabel());
			}

			System.out.println("Requirements A list");
			for (Integer s : nrp.getIDReqA()) {
				System.out.println(s);
			}

			System.out.println("Requirements B list");
			for (Integer s : nrp.getIDReqB()) {
				System.out.println(s);
			}
		}
	}

	/**
	 * May need to put each different object into different methods Still need
	 * to add every parsed bit into customer objects and such and also link the
	 * correct attributes to each other
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileParser fp = new FileParser();
		fp.parseFile();

	}

}
