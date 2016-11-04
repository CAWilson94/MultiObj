
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

/**
 * 
 * @author charl
 *
 *         Contains fitness functions for the two objectives:
 * 
 *         (1) Number of tests - min
 * 
 *         (2) Profit - max
 * 
 *         Both counts, not normalised to fall into range of 0 -1 Loaded into
 *         Objectives object with a label and indication to say if they should
 *         be minimised or maximised.
 * 
 */
public class NRP_2Evaluator implements Evaluator<String> {
	FileParser fp = new FileParser();
	NRP nrp = fp.parseFile();

	@Override
	public Objectives evaluate(String phenotype) {
		Objectives objectives = new Objectives();
		DemoShiz ds = new DemoShiz();
		objectives.add("TestSize", Sign.MIN, ds.individualScore(phenotype, nrp));
		objectives.add("Requirements Profit", Sign.MAX, evaluateFaultCovFitness(phenotype));
		return objectives;
	}

	public double evaluateFaultCovFitness(String phenotype) {
		int count = 0;
		return count;
	}
}
