package ru.job4j.start;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.models.Item;

/**
 * Test.
 *
 * @author Andrey Baranov
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
	/**
	 * Test max first parameter.
	 */
	@Test
	public void whenAddNewItemThenTrackerHasTheSameItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "testdesc", 123L);
		tracker.add(item);
		assertThat(tracker.findAll()[0], is(item));
	}
}