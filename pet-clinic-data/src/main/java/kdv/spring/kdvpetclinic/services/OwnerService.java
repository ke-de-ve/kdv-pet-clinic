package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
