
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.genotype.BooleanGenotype;

/**
 * Changes Boolean phenotype to a string phenotype
 * 
 * @author Charlotte Wilson
 *
 */
public class NRP_2Decoder implements Decoder<BooleanGenotype, String> {
	public String decode(BooleanGenotype genotype) {
		String phenotype = "";
		for (int i = 0; i < genotype.size(); i++) {
			// True for requirement is selected
			if (genotype.get(i) == true)
				phenotype += "1";
			else
				phenotype += "0";
		}
		return phenotype;
	}
}
