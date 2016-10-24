import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

		BufferedReader br = null;
		String currentLine;
		int counter = 0;
		// Basic reader
		br = new BufferedReader(new FileReader(Constants.FILE_NAME));

		while ((currentLine = br.readLine()) != null) {

			counter++; // Skips line 0
			// Check out the level of requirements
			if (counter == 1) {
				System.out.println(currentLine + " Num requirements");
				int reqCounter = Integer.parseInt(currentLine) * 2;
				// go through cost and level for each requirement
				while (reqCounter != 0) {
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
				System.out.println(tokens[0] + " First ID");
				System.out.println(tokens[1] + " Second ID");
				words = 0;
			}
			// Now for number of customers
			if (words == 1) {
				System.out.println("number of customers is: " + currentLine);
			}
			// profit customer, num requests, req list
			while (words > 2) {
				System.out.println(currentLine);
				words = 0;
			}
		}
		br.close();
	}

	/**
	 * Level of requirments will always be position 1 which will give back a
	 * value i, which you can use to go through num and cost requirements i
	 * times i.e. if level of requirments, from position 1, is 3 you know to
	 * increment three times to get the num and cost for the three levels after
	 * this.
	 */

}
