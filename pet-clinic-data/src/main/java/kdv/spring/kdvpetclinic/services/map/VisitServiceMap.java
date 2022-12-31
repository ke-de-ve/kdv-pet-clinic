package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Visit;
import kdv.spring.kdvpetclinic.repositories.VisitRepository;
import kdv.spring.kdvpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("map")
public class VisitServiceMap extends BaseMapService<Visit, Long> implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceMap(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getId() == null ||
            visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit data");
        }
        return visitRepository.save(visit);
    }

    @Override
    public Visit findBiId(Long id) {
        return visitRepository.findById(id).orElse(null);
    }
}
