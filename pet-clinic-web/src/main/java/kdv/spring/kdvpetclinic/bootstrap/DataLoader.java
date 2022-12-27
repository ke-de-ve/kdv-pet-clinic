package kdv.spring.kdvpetclinic.bootstrap;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.model.Vet;
import kdv.spring.kdvpetclinic.services.OwnerService;
import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading owners ...");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        ownerService.save(owner2);

        System.out.println("Loaded  owners.");
        System.out.println("Loading vets ...");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Johnny");
        vet1.setLastName("Vets");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Mary");
        vet2.setLastName("Vets");
        vetService.save(vet2);

        System.out.println("Loaded vets.");
    }
}