package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends BaseMapService<Vet, Long> implements VetService{

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
    public Vet save(Vet entity) {
        return super.save(entity);
    }
}
