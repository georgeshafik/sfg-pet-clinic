package guru.springframework.sfgpetclinic.repository;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gs on 2019-07-04
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
