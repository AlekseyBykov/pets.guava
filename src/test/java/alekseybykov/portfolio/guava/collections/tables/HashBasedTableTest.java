package alekseybykov.portfolio.guava.collections.tables;

import alekseybykov.portfolio.guava.PerformnceAuditorRule;
import com.google.common.collect.HashBasedTable;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

public class HashBasedTableTest {
	@Rule
	public PerformnceAuditorRule performnceAuditor = new PerformnceAuditorRule();

	private static HashBasedTable<Integer, Integer, String> table1;

	@BeforeClass
	public static void setup() {
		table1 = HashBasedTable.create();

		table1.put(0, 0, "row 0, column 0");
		table1.put(0, 1, "row 0, column 1");
		table1.put(0, 2, "row 0, column 2");

		table1.put(1, 0, "row 1, column 0");
		table1.put(1, 1, "row 1, column 1");
		table1.put(1, 2, "row 1, column 2");
	}

	@Test
	public void testCoreOperations() {
		HashBasedTable<Integer, Integer, String> table2 = HashBasedTable.create(table1);
		assertEquals(table1, table2);

		assertTrue(table1.contains(0, 0));
		assertTrue(table1.containsColumn(2));
		assertTrue(table1.containsRow(1));
		assertTrue(table1.containsValue("row 1, column 1"));

		assertEquals("row 0, column 2", table1.get(0, 2));

		table1.remove(0, 0);
		assertNull(table1.get(0, 0));
	}

	@Test
	public void testObtainRowValueMapping() {
		Map<Integer, String> column = table1.column(0);
		assertEquals(2, column.size());
		assertEquals(column.get(0), "row 0, column 0");
		assertEquals(column.get(1), "row 1, column 0");
	}

	@Test
	public void testObtainColumnValueMapping() {
		Map<Integer, String> row = table1.row(1);
		assertEquals(3, row.size());
		assertEquals(row.get(0), "row 1, column 0");
		assertEquals(row.get(1), "row 1, column 1");
		assertEquals(row.get(2), "row 1, column 2");
	}
}
