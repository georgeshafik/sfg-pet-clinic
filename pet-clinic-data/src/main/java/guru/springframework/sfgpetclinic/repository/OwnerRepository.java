package guru.springframework.sfgpetclinic.repository;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    // JPA functionality to provide this
    Owner findByLastName(String lastName);
}
