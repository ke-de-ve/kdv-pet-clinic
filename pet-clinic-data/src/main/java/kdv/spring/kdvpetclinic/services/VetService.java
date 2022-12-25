package kdv.spring.kdvpetclinic.services;

import kdv.spring.kdvpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findBiId(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
