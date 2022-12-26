package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.Person;
import kdv.spring.kdvpetclinic.model.Vet;

public interface VetService<V extends Person, L extends Number> extends CrudService<Vet, Long> {

}
