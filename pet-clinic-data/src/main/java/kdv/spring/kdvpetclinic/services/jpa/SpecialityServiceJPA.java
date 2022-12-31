package kdv.spring.kdvpetclinic.services.jpa;

import kdv.spring.kdvpetclinic.model.Speciality;
import kdv.spring.kdvpetclinic.repositories.SpecialityRepository;
import kdv.spring.kdvpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class SpecialityServiceJPA implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceJPA(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findBiId(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality entity) {
        return specialityRepository.save(entity);
    }

    @Override
    public void delete(Speciality entity) {
        specialityRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
