package kdv.spring.kdvpetclinic.services.jpa;

import kdv.spring.kdvpetclinic.model.Pet;
import kdv.spring.kdvpetclinic.repositories.PetRepository;
import kdv.spring.kdvpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class PetServiceJPA implements PetService {

    private final PetRepository petRepository;

    public PetServiceJPA(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findBiId(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
