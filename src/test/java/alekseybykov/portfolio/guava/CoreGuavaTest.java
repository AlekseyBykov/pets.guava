package alekseybykov.portfolio.guava;

import com.google.common.base.Function;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CoreGuavaTest {

	private static Function<Date, String> function;
	private static String datePattern = "yyyy-mm-dd";
	private static Date currentDate;

	@BeforeClass
	public static void setup() {
		currentDate = new Date();
		function = new Function<Date, String>() {
			@Override
			public String apply(Date date) {
				return new SimpleDateFormat(datePattern).format(date);
			}
		};
	}

	@Test
	public void testFormatDateWithFunctionalAndImperativeApproach() {
		assertEquals(function.apply(currentDate),
				new SimpleDateFormat(datePattern).format(currentDate));
	}
}
