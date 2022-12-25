package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findBiId(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
