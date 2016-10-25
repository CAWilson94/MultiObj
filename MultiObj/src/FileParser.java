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

	/**
	 * May need to put each different object into different methods Still need
	 * to add every parsed bit into customer objects and such and also link the
	 * correct attributes to each other
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		NRP nrp = new NRP();

		BufferedReader br = null;
		String currentLine;
		int counter = 0;
		int customerCount = 0;
		List<Customer> customersList = new ArrayList<Customer>();
		// Basic reader
		br = new BufferedReader(new FileReader(Constants.FILE_NAME));

		while ((currentLine = br.readLine()) != null) {

			counter++; // Skips line 0
			// Check out the level of requirements
			if (counter == 1) {
				System.out.println(currentLine + " Num requirements");
				nrp.setReqLevel(Integer.parseInt(currentLine));
				int reqCounter = Integer.parseInt(currentLine) * 2;
				// go through cost and level for each requirement
				while (reqCounter != 0) {

					/**
					 * if words > 1: count how many there are and that is equal
					 * to cost - Add this to cost of requirement
					 * 
					 * Else, one word is the number of requirements
					 */

					counter++; // original counter
					System.out.println(br.readLine());
					reqCounter--; // requirements counter
				}
				System.out.println("counter is now at.. " + counter);
				System.out.println("should be num dependancies.. " + br.readLine());
			}
			// Go through all the ID's
			int words = 0;
			words += currentLine.split("\\s+").length;
			while (words == 2) {
				System.out.println(currentLine);
				String[] tokens = currentLine.split("\\s+");
				// Need to add to ID A list in NRP
				System.out.println(tokens[0] + " First ID");
				// Need to add to ID B list in NRP
				System.out.println(tokens[1] + " Second ID");
				words = 0;
			}
			// Now for number of customers
			if (words == 1) {
				System.out.println("number of customers is: " + currentLine);
				// Add customer numbers to nrp object attribute
				nrp.setNumCustomers(Integer.parseInt(currentLine));
			}
			// profit customer, num requests, req list
			while (words > 2) {
				customerCount++;
				System.out.println(customerCount + "customer count");
				// Just to keep track of the right things..
				Customer customer = new Customer();
				customer.setCustomerLabel(customerCount);
				/**
				 * Need to split into three profit: single variable Num
				 * requests: single variable Req list: a list.. ofc
				 */
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
				words = 0;
			}
			nrp.setCustomers(customersList);
		}
		br.close();
		System.out.println(nrp.getReqLevel() + " in the object yoooo");
		System.out.println(nrp.getNumCustomers() + " is num customers in object");

		System.out.println("customers list: ");
		for (Customer c : nrp.getCustomers()) {
			System.out.println(c.getCustomerLabel());
		}
	}

}
