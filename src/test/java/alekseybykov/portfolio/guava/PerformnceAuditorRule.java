package alekseybykov.portfolio.guava;

import com.google.common.base.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;

public class PerformnceAuditorRule extends TestWatcher {
	private Stopwatch stopwatch = Stopwatch.createUnstarted();

	@Override
	protected void starting(Description description) {
		stopwatch.start();
	}

	@Override
	protected void finished(Description description) {
		stopwatch.stop();
		long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		System.out.println(String.format("Performance tracking: %s, %d ms", description.getMethodName(), elapsed));
	}
}
