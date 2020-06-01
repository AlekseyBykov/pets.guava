package alekseybykov.portfolio.guava;

import com.google.common.base.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aleksey Bykov
 * @since 24.05.2020
 */
public class PerformnceAuditorRule extends TestWatcher {
	private static final Logger LOGGER = Logger.getLogger(PerformnceAuditorRule.class.getPackage().getName());
	private Stopwatch stopwatch = Stopwatch.createUnstarted();

	@Override
	protected void starting(Description description) {
		stopwatch.start();
	}

	@Override
	protected void finished(Description description) {
		stopwatch.stop();
		long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		LOGGER.log(Level.INFO, String.format("Performance tracking: %s, %d ms", description.getMethodName(), elapsed));
	}
}
