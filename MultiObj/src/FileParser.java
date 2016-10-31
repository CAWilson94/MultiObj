import java.io.BufferedReader;
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
	public List<Requirements> level = new ArrayList<Requirements>();

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
					nrp.setReqLevel(Integer.parseInt(currentLine));
					int reqCounter = Integer.parseInt(currentLine) * 2;
					// go through cost and level for each requirement
					int countBoop = 1;
					while (reqCounter != 0) {
						currentLine = br.readLine();
						String[] tokens = currentLine.split("\\s+");
						List<String> tokensList = new ArrayList<String>(Arrays.asList(tokens));
						if (tokens.length > 1) {
							// save as whatever
							System.out.println(currentLine + " is current line");
							System.out.println(tokensList.size() + " is size");
							Requirements r = new Requirements(tokensList.size(), tokensList, countBoop);
							level.add(r);
							countBoop++; // Just to add level to Requirements
											// object
						}
						reqCounter--;

					}
					nrp.setRequirements(level);
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
			nrp.setNumCustomers(customerCount);

			br.close();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		debug(); // Make sure everything has went into the correct objects
	}

	/**
	 * Extracting ID's from column A and column B and storing them in NRP object
	 */
	private void IDExtraction(String currentLine) {
		String[] tokens = currentLine.split("\\s+");
		// Need to add to ID A list in NRP
		IDReqA.add(Integer.parseInt(tokens[0]));
		// Need to add to ID B list in NRP
		IDReqB.add(Integer.parseInt(tokens[1]));
	}

	/**
	 * Extracting different customer attributes, saving each customer and adding
	 * customer list to NRP object
	 */
	private void customerAttributeExtraction(int customerCount, String currentLine) {
		// Just to keep track of the right things..
		Customer customer = new Customer();
		customer.setCustomerLabel(customerCount);

		// Split line into different attributes
		String[] tokens = currentLine.split("\\s+");
		customer.setProfit(Integer.parseInt(tokens[0]));
		customer.setNumRequests(Integer.parseInt(tokens[1]));
		String[] subTokens = Arrays.copyOfRange(tokens, 2, tokens.length);
		List<Integer> reqList = new ArrayList<Integer>();
		for (String s : subTokens) {
			reqList.add(Integer.parseInt(s));
		}
		customer.setReqList(reqList);
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
			System.out.println(nrp.getNumReq() + "is number requirements");

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

			System.out.println("requirements shit: ");
			for (Requirements n : nrp.getRequirements()) {
				System.out.println(n.getNumReq() + " : numReq ");
				System.out.println(n.getCosts() + " : Costs ");
				System.out.println(n.getLevel() + " : is level ");
			}

		}
	}

	/**
	 * Tokenise lines and get total number of numbers in there this is for the
	 * total cost of the level, can be used for other things..
	 * 
	 * @param currentLine
	 * @return
	 */
	public int tokenizeShit(String currentLine) {
		String[] tokens = currentLine.split("\\s+");
		int total = tokens.length;
		return total;
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
