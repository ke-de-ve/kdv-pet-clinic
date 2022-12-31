package kdv.spring.kdvpetclinic.bootstrap;

import kdv.spring.kdvpetclinic.model.*;
import kdv.spring.kdvpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    private void LoadData() {
        Speciality radiology = specialityService.save(new Speciality("Radiology"));
        Speciality surgery   = specialityService.save(new Speciality("Surgery"));
        Speciality dentistry = specialityService.save(new Speciality("Dentistry"));

        PetType savedDogPetType = PetType.builder().name("Dog").build();
        petTypeService.save(savedDogPetType);
        PetType savedCatPetType = PetType.builder().name("Cat").build();
        petTypeService.save(savedCatPetType);
        System.out.println("Loaded PetTypes.");

        Owner owner1 = Owner.builder().firstName("John").lastName("Doe").address("123 Some Str").city("Miami").telephone("123-456-7890").build();
        Pet sharik = Pet.builder().name("Sharik").owner(owner1).petType(savedDogPetType).birthDate(LocalDate.now()).build();
        petService.save(sharik);
        Pet boots = Pet.builder().name("Boots").owner(owner1).petType(savedCatPetType).birthDate(LocalDate.now()).build();
        petService.save(boots);
        owner1.getPets().add(sharik);
        owner1.getPets().add(boots);
        ownerService.save(owner1);

        Owner owner2 = Owner.builder().firstName("Jane").lastName("Doe").address("321 Other Str").city("Boston").telephone("321-654-0987").build();
        Pet murka = Pet.builder().name("Murka").owner(owner2).petType(savedCatPetType).birthDate(LocalDate.now()).build();
        murka = petService.save(murka);
        owner2.getPets().add(murka);
        ownerService.save(owner2);
        System.out.println("Loaded Owners.");


        Visit murkaVisit = new Visit();
        murkaVisit.setPet(murka);
        murkaVisit.setDate(LocalDate.now());
        murkaVisit.setDescription("Sneeze Kitty");
        // Visit.builder().pet(murka).date(LocalDate.now()).description("Sneeze Kitty").build();
        petService.findAll().forEach(pet -> System.out.println(pet.toString()));
        visitService.save(murkaVisit);

        Vet vet1 = Vet.builder().firstName("Mary").lastName("Vets").build();
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = Vet.builder().firstName("Sammy").lastName("Vets").build();
        vet1.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3 = Vet.builder().firstName("Barney").lastName("Vets").build();
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet3);

        System.out.println("Loaded Vets.");
    }

    @Override
    public void run(String... args) throws Exception {

        if(petService.findAll().size() == 0) {
            LoadData();
        }
    }

}