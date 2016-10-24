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

	public static void main(String[] args) throws IOException {
		/*
		 * Basically, to read in the level of requirments you just read in the
		 * first line and store that number
		 */

		int numReq = 0; // Need this!
		BufferedReader br = null;
		String currentLine;
		int counter = 0;

		br = new BufferedReader(new FileReader(Constants.FILE_NAME));

		while ((currentLine = br.readLine()) != null) {
			counter++; // Skips line 0
			if (counter == 1) {
				System.out.println(currentLine + "Level of requirments");
			}
			if (counter == 2) {
				System.out.println(currentLine + "Num requirements in level one");
				int countMini = currentLine; // need to convert to int then loop through and save
			}
		}
		br.close();
	}

	/**
	 * Level of requirments will always be position 1 which will give back a
	 * value i, which you can use to go through num and cost requirements i times
	 * i.e. if level of requirments, from position 1, is 3 you know to increment
	 * three times to get the num and cost for the three levels after this.
	 */

}
