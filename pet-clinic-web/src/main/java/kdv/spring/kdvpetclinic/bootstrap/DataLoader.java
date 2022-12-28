package kdv.spring.kdvpetclinic.bootstrap;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.model.Pet;
import kdv.spring.kdvpetclinic.model.PetType;
import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.OwnerService;
import kdv.spring.kdvpetclinic.services.PetService;
import kdv.spring.kdvpetclinic.services.PetTypeService;
import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType savedDogPetType = PetType.builder().name("Dog").build();
        petTypeService.save(savedDogPetType);
        PetType savedCatPetType = PetType.builder().name("Cat").build();
        petTypeService.save(savedCatPetType);
        System.out.println("Loaded PetTypes.");

        Owner owner1 = Owner.builder().firstName("John").lastName("Doe").address("123 Some Str").city("Miami").telephone("123-456-7890").build();
        Pet sharik = Pet.builder().name("Sharik").owner(owner1).petType(savedDogPetType).birthDate(LocalDate.now()).build();
//        petService.save(sharik);
        Pet boots = Pet.builder().name("Boots").owner(owner1).petType(savedCatPetType).birthDate(LocalDate.now()).build();
//        petService.save(boots);
        owner1.getPets().add(sharik);
        owner1.getPets().add(boots);
        ownerService.save(owner1);

        Owner owner2 = Owner.builder().firstName("Jane").lastName("Doe").address("321 Other Str").city("Boston").telephone("321-654-0987").build();
        Pet murka = Pet.builder().name("Murka").owner(owner2).petType(savedCatPetType).birthDate(LocalDate.now()).build();
//        petService.save(murka);
        owner2.getPets().add(murka);
        ownerService.save(owner2);
        System.out.println("Loaded Owners.");

        ;

        vetService.save(Vet.builder().firstName("Mary").lastName("Vets").build());
        vetService.save(Vet.builder().firstName("Sammy").lastName("Vets").build());
        System.out.println("Loaded Vets.");
    }
}