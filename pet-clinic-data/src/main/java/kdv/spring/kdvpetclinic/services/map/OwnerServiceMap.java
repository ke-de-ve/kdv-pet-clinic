package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.model.Pet;
import kdv.spring.kdvpetclinic.services.OwnerService;
import kdv.spring.kdvpetclinic.services.PetService;
import kdv.spring.kdvpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends BaseMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null && owner.getPets().size() > 0) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required!");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public Owner findBiId(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        //TODO: implement findByLastName !
        return null;
    }
}