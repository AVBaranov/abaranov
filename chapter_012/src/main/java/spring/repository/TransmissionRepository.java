package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Transmission;

/**
 * Created by Андрей on 06.06.2018.
 */
public interface TransmissionRepository extends CrudRepository<Transmission, Integer> {
}
