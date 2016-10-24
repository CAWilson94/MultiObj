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

		br = new BufferedReader(new FileReader(Constants.FILE_NAME));

		while ((currentLine = br.readLine()).length() == 1) {
			System.out.println(currentLine + " This should be saved in the nrp object");
		}
		br.close();

	}

}
