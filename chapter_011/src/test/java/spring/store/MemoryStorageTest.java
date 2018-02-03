package spring.store;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 03.02.2018.
 */
public class MemoryStorageTest {
    @Test
    public void whenAddNewUserWithSpringThenGetThisUserFromSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ImportUser memory = context.getBean(ImportUser.class);
        memory.add(new User("1", "1", "1"));
        assertThat(memory.getAll().get(0).getLogin(), is("1"));
    }
}