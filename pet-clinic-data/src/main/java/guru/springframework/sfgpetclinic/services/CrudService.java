package guru.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * Created by gs on 2019-06-26
 *
 * We are refactoring out the common services into a common interface
 * similar to the way Spring Crud Repository through generics works
 *
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
