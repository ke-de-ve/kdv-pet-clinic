package kdv.spring.kdvpetclinic.repositories;

import kdv.spring.kdvpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
