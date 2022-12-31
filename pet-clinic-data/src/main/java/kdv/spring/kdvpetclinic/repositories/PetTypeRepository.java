package kdv.spring.kdvpetclinic.repositories;

import kdv.spring.kdvpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
