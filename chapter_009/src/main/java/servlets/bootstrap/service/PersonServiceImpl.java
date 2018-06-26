package servlets.bootstrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlets.bootstrap.models.Person;
import servlets.bootstrap.repository.PersonRepository;

import java.util.List;

/**
 * Created by Andrey on 25.06.2018.
 */
public class PersonServiceImpl implements PersonService<Person> {


    private PersonRepository repository;
    private ApplicationContext context;

    public PersonServiceImpl() {
        this.context = new ClassPathXmlApplicationContext("spring.xml");
        this.repository = this.context.getBean(PersonRepository.class);
    }

    @Override
    public void create(Person person) {
        repository.save(person);
    }

    @Override
    public List<Person> read() {
        return repository.findAll();
    }
}
