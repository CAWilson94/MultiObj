
import org.opt4j.core.problem.ProblemModule;

public class NRPBOOPModule extends ProblemModule {
	protected void config() {
		bindProblem(NRPBOOPCreator.class, NRPBOOPDecoder.class, NRPBOOPEvaluator.class);
	}
}
