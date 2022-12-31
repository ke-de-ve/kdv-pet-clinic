package kdv.spring.kdvpetclinic.repositories;

import kdv.spring.kdvpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
