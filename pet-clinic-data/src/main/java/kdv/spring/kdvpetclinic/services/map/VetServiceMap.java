package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Speciality;
import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.SpecialityService;
import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class VetServiceMap extends BaseMapService<Vet, Long> implements VetService{

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findBiId(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }
}
