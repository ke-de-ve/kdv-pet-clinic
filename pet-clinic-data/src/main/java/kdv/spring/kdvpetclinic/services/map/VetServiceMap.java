package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.VetService;

import java.util.Set;

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
    public Vet save(Vet vet) {
        super.save(vet.getId(), vet);
        return vet;
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
