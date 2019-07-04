package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by gs on 2019-07-04
 */
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    // A Visit has a
    //  - description
    //  - pet
    //    A pet is a complex object, it belongs to an owner
    @Override
    public Visit save(Visit object) {

        if (object.getPet() == null ||
            object.getPet().getId() == null ||
            object.getPet().getOwner() == null ||
            object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
