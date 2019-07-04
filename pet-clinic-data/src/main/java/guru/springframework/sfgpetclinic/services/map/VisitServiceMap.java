package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by gs on 2019-07-04
 */
@Service
@Profile({"default","map"})
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

        String errorMessage = "";

        if (object.getPet() == null ||
            object.getPet().getId() == null ||
            object.getPet().getOwner() == null ||
            object.getPet().getOwner().getId() == null) {

            if (object.getPet() == null) {
                errorMessage = errorMessage + " [object.getPet() is null] ";
            } else if (object.getPet().getId() == null ) {
                errorMessage = errorMessage + " [object.getPet().getID is null] ";
            }

            if (object.getPet().getOwner() == null) {
                errorMessage = errorMessage + " [ object.getPet().getOwner() is null ]";
            } else if (object.getPet().getOwner().getId() == null ) {
                errorMessage = errorMessage + " [ object.getPet().getOwner().getId() is null ]";
            }

            throw new RuntimeException("Invalid Visit Visiting " + errorMessage);
        }

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
