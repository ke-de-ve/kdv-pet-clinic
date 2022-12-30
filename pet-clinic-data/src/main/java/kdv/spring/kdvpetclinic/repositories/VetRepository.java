package kdv.spring.kdvpetclinic.repositories;

import kdv.spring.kdvpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}