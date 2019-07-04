package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gs on 2019-07-04
 */
// Remember we need to set this as an active profile for it to be used. Currently it will use
// PetTypeServiceMap by default if we deactivate PetTypeSDJpaService by introducing the @Profile
// Recap: we have two services defined for PetTypeService
// 1. PetTypeServiceMap
// 2. PetTypeSDJpaService
// Only one pet type service can be used at runtime.
// Using a profile ensures we activate or de-active a given pet type service ensuring only one is used.
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
