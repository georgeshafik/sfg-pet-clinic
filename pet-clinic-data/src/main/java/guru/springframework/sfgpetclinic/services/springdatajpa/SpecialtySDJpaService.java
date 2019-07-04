package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repository.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gs on 2019-07-04
 */
// Remember we need to set this as an active profile for it to be used. Currently it will use
// SpecialtyServiceMap by default if we deactivate SpecialtySDJpaService by introducing the @Profile
// Recap: we have two services defined for SpecialtyService
// 1. SpecialtyServiceMap
// 2. SpecialtySDJpaService
// Only one pet type service can be used at runtime.
// Using a profile ensures we activate or de-active a given Specialty service ensuring only one is used.
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
