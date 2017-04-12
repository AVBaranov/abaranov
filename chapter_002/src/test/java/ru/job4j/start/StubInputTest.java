package ru.job4j.start;

import org.junit.Test;
//import ru.job4j.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Andrey Baranov
 * @version $Id$
 * @since 0.1
 */
public class StubInputTest {
    /**
     * Test add item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new ValidStubInput(new String[]{"0", "testname", "testdesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("testname"));
        assertThat(tracker.findAll()[0].getDescription(), is("testdesc"));
    }
    /**
     * Test add item.
     */
    @Test
    public void whenUserUpdateItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new ValidStubInput(new String[]{"0", "testname", "testdesc", "2", "testdesctestname", "newtestname", "newtestdesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("newtestname"));
        //assertThat(tracker.findAll()[0].getDescription(), is("testdesc"));
    }
    /**
     * Test add item.
     */
    @Test
    public void whenUserDeleteItemThenSecondItemBecomesFirstItem() {
        Tracker tracker = new Tracker();
        Input input = new ValidStubInput(new String[]{"0", "testname", "testdesc", "0", "testname2", "testdesc2", "3", "testname", "testdesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("testname2"));
        //assertThat(tracker.findAll()[0].getDescription(), is("testdesc"));
    }

}
