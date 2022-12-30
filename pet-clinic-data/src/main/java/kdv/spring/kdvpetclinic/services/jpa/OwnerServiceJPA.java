package kdv.spring.kdvpetclinic.services.jpa;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.repositories.OwnerRepository;
import kdv.spring.kdvpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class OwnerServiceJPA implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceJPA(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);
        // ownerRepository.findAll().forEach(owner -> owners.add(owner));

        return owners;
    }

    @Override
    public Owner findBiId(Long id) {
        return ownerRepository.findById(id).orElse(null);
        // same as following...
        //  if (ownerRepository.findById(id).isPresent()) {
        //       return ownerRepository.findById(id).get();
        //  } else {
        //       return null;
        //  }
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
