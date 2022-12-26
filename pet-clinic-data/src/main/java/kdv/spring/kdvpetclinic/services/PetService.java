package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.BaseEntity;
import kdv.spring.kdvpetclinic.model.Pet;

public interface PetService<P extends BaseEntity, L extends Number> extends CrudService<Pet, Long> {

}
