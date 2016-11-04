
import java.util.Random;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.genotype.BooleanGenotype;

/**
 * Create instances of a solution
 * 
 * @author Charelotte Wilson
 *
 */
public class NRP_2Creator implements Creator<BooleanGenotype> {
	Random random = new Random();

	public BooleanGenotype create() {
		BooleanGenotype genotype = new BooleanGenotype();
		/**
		 * Need to change this to the same number of requirements?
		 */
		genotype.init(random, 140); //
		return genotype;
	}
}