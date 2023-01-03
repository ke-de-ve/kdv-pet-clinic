package kdv.spring.kdvpetclinic.services.map;

import kdv.spring.kdvpetclinic.model.Owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Set;


class OwnerServiceMapTest {

    private static final Long OWNER_ID = 1L;
    private static final String OWNER_LAST_NAME = "Last1234";
    private static final String OWNER_FIRST_NAME = "First4321";
    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder()
                .id(OWNER_ID).lastName(OWNER_LAST_NAME).firstName(OWNER_FIRST_NAME).build());
    }

    @Test
    void findAll() {
        final Set<Owner> owners = ownerServiceMap.findAll();

        Assertions.assertEquals(1, owners.size());
        Assertions.assertEquals(OWNER_ID, owners.iterator().next().getId());
        Assertions.assertEquals(OWNER_FIRST_NAME, owners.iterator().next().getFirstName());
        Assertions.assertEquals(OWNER_LAST_NAME, owners.iterator().next().getLastName());
    }

    @Test
    void findBiId() {
        Owner owner = ownerServiceMap.findBiId(OWNER_ID);

        Assertions.assertNotNull(owner);
        Assertions.assertEquals(OWNER_ID, owner.getId());
        Assertions.assertEquals(OWNER_FIRST_NAME, owner.getFirstName());
        Assertions.assertEquals(OWNER_LAST_NAME, owner.getLastName());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = ownerServiceMap.save(Owner.builder().id(2L).build());
        Owner owner2Saved = ownerServiceMap.save(owner2);

        Assertions.assertNotNull(owner2Saved);
        Assertions.assertEquals(2L, owner2Saved.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = ownerServiceMap.save(Owner.builder().lastName("12345").build());
        Owner owner2Saved = ownerServiceMap.save(owner2);

        Assertions.assertNotNull(owner2Saved);
        Assertions.assertNotNull(owner2Saved.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(OWNER_ID);

        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findBiId(OWNER_ID));

        Assertions.assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(OWNER_LAST_NAME);

        Assertions.assertNotNull(owner);
        Assertions.assertEquals(OWNER_LAST_NAME, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("FOO");

        Assertions.assertNull(owner);
    }
}