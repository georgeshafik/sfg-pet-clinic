package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repository.VetRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gs on 2019-07-04
 */
// Remember we need to set this as an active profile for it to be used. Currently it will use
// VetServiceMap by default if we deactivate VetSDJpaService by introducing the @Profile
// Recap: we have two services defined for VetService
// 1. VetServiceMap
// 2. VetSDJpaService
// Only one vet service can be used at runtime.
// Using a profile ensures we activate or de-active a given vet service ensuring only one is used.
@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyService specialtyService;

    public VetSDJpaService(VetRepository vetRepository, SpecialtyService specialtyService) {
        this.vetRepository = vetRepository;
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
