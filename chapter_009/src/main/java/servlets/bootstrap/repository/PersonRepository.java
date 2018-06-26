package servlets.bootstrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servlets.bootstrap.models.Person;


/**
 * Created by Andrey on 25.06.2018.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
