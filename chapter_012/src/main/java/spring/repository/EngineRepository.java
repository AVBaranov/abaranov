package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Engine;

/**
 * Created by Андрей on 06.06.2018.
 */
public interface EngineRepository extends CrudRepository<Engine, Integer> {
}
