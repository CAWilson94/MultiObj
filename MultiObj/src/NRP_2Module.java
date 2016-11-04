
import org.opt4j.core.problem.ProblemModule;

public class NRP_2Module extends ProblemModule {
	protected void config() {
		bindProblem(NRP_2Creator.class, NRP_2Decoder.class, NRP_2Evaluator.class);
	}
}
