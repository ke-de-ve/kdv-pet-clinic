package kdv.spring.kdvpetclinic.bootstrap;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.model.PetType;
import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.OwnerService;
import kdv.spring.kdvpetclinic.services.PetTypeService;
import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType savedDogPetType = PetType.builder().name("Dog").build();
        petTypeService.save(savedDogPetType);
        PetType savedCatPetType = PetType.builder().name("Cat").build();
        petTypeService.save(savedCatPetType);
        System.out.println("Loaded PetTypes.");

        ownerService.save(Owner.builder().firstName("John").lastName("Doe").build());
        ownerService.save(Owner.builder().firstName("Jane").lastName("Doe").build());
        System.out.println("Loaded Owners.");

        vetService.save(Vet.builder().firstName("Mary").lastName("Vets").build());
        vetService.save(Vet.builder().firstName("Sammy").lastName("Vets").build());
        System.out.println("Loaded Vets.");
    }
}