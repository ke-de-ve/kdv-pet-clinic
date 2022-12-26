package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Pet;
import kdv.spring.kdvpetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends BaseMapService<Pet, Long> implements PetService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findBiId(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        super.save(pet.getId(), pet);
        return pet;
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
