package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findBiId(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
