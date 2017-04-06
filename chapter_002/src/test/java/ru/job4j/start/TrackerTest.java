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
	 * Test add item.
	 */
	@Test
	public void whenAddNewItemThenTrackerHasTheSameItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "testdesc", 123L);
		tracker.add(item);
		assertThat(tracker.findAll()[0], is(item));
	}
	/**
	 * Test delete item.
	 */
	@Test
	public void whenDeleteSecondElementOfArrayThenThirdElementMovesToTheLeft() {
		Tracker tracker = new Tracker();
		Item it1 = new Item("test1", "testdesc1", 123L);
		Item it2 = new Item("test2", "testdesc2", 234L);
		Item it3 = new Item("test3", "testdesc3", 345L);
		tracker.add(it1);
		tracker.add(it2);
		tracker.add(it3);
		Item temp = tracker.findAll()[2];
		tracker.delete(it2);
		assertThat(tracker.findAll()[1], is(temp));
	}
	/**
	 * Test delete item.
	 */
	@Test
	public void whenDeleteOneElementOfArrayThenNumberOfElementsDecreaseBeOne() {
		Tracker tracker = new Tracker();
		Item it1 = new Item("test1", "testdesc1", 123L);
		Item it2 = new Item("test2", "testdesc2", 234L);
		Item it3 = new Item("test3", "testdesc3", 345L);
		tracker.add(it1);
		tracker.add(it2);
		tracker.add(it3);
		int temp = tracker.findAll().length;
		tracker.delete(it2);
		assertThat(tracker.findAll().length, is(temp - 1));
	}
	/**
	 * Test find item by id.
	 */
	@Test
	public void whenWeKnowSomeIdThenWeCanFindItemByThisId() {
		Tracker tracker = new Tracker();
		Item it1 = new Item("test1", "testdesc1", 123);
		Item it2 = new Item("test2", "testdesc2", 234);
		Item it3 = new Item("test3", "testdesc3", 345);
		tracker.add(it1);
		tracker.add(it2);
		tracker.add(it3);
		Item excpectation = tracker.findAll()[1];
		assertThat(tracker.findById("234test2"), is(excpectation));
	}
	/**
	 * Test find all items by name.
	 */
	@Test
	public void whenWeKnowNameThenWeCanFindAllItemsByThisName() {
		Tracker tracker = new Tracker();
		Item it1 = new Item("test1", "testdesc1", 123);
		Item it2 = new Item("test2", "testdesc2", 234);
		Item it3 = new Item("test3", "testdesc3", 345);
		Item it4 = new Item("test1", "testdesc3", 345);
		tracker.add(it1);
		tracker.add(it2);
		tracker.add(it3);
		tracker.add(it4);
		Item[] excpectation = {it1, it4};
		assertThat(excpectation, is(tracker.findByName("test1")));
	}
}