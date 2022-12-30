package kdv.spring.kdvpetclinic.repositories;

import kdv.spring.kdvpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
