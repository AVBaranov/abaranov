package ru.job4j.start;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.models.Item;

import java.util.ArrayList;

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
		assertThat(tracker.findAll().get(0), is(item));
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
		Item temp = tracker.findAll().get(2);
		tracker.delete(it2);
		assertThat(tracker.findAll().get(1), is(temp));
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
		int temp = tracker.findAll().size();
		tracker.delete(it2);
		assertThat(tracker.findAll().size(), is(temp - 1));
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
		Item excpectation = tracker.findAll().get(1);
		assertThat(tracker.findById("testdesc2test2"), is(excpectation));
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
		ArrayList<Item> excpectation = new ArrayList<>();
		excpectation.add(it1);
		excpectation.add(it4);
		assertThat(excpectation, is(tracker.findByName("test1")));
	}
	/**
	 * Test find all items by name.
	 */
	@Test
	public void whenNeedToReplaceItemByIdThenEnterNewItem() {
		Tracker tracker = new Tracker();
		Item it1 = new Item("test1", "testdesc1", 123);
		Item it2 = new Item("test2", "testdesc2", 234);
		Item it3 = new Item("test3", "testdesc3", 345);
		Item it4 = new Item("test1", "testdesc3", 345);
		tracker.add(it1);
		tracker.add(it2);
		tracker.add(it3);
		tracker.add(it4);
		Tracker newtracker = new Tracker();
		Item newitem = new Item("newtest", "newtestdesc", 77777);
		newtracker.add(it1);
		newtracker.add(it2);
		newtracker.add(newitem);
		newtracker.add(it4);
		tracker.update(it3.getId(), newitem);
		assertThat(newtracker.findAll().get(2).getId(), is(tracker.findAll().get(2).getId()));
	}
}