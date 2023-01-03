package kdv.spring.kdvpetclinic.services.jpa;

import kdv.spring.kdvpetclinic.model.Owner;
import kdv.spring.kdvpetclinic.repositories.OwnerRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    @Mock
    private OwnerRepository ownerRepository;

    private static final Long OWNER_ID = 1L;
    private static final String OWNER_LAST_NAME = "Last1234";
    private static final String OWNER_FIRST_NAME = "First4321";

    @InjectMocks
    private OwnerServiceJPA ownerServiceJPA;
    private Owner owner;
    private Set<Owner> owners;

    @BeforeEach
    void setUp() {
        this.owner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).firstName(OWNER_FIRST_NAME).build();

        this.owners = new HashSet<>(1);
        this.owners.add(this.owner);
    }

    @Test
    void findAll() {
        Mockito
                .when(ownerRepository.findAll())
                .thenReturn(this.owners);

        Set<Owner> owners = ownerServiceJPA.findAll();

        Mockito.verify(ownerRepository, Mockito.times(1)).findAll();
        Assertions.assertIterableEquals(this.owners, owners);
    }

    @Test
    void findBiId() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.ofNullable(this.owner));

        Owner owner2 = ownerServiceJPA.findBiId(OWNER_ID);
        Mockito.verify(ownerRepository, Mockito.times(1)).findById(Mockito.anyLong());

        Assertions.assertNotNull(owner2);
        Assertions.assertEquals(owner, owner2);
    }

    @Test
    void findBiIdNotFound() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());

        Owner owner2 = ownerServiceJPA.findBiId(-111L);
        Mockito.verify(ownerRepository, Mockito.times(1)).findById(Mockito.anyLong());

        Assertions.assertNull(owner2);
    }

    @Test
    void save() {
        Mockito.when(ownerRepository.save(Mockito.any()))
                .thenReturn(owner);

        Owner owner2 = ownerServiceJPA.save(owner);
        Mockito.verify(ownerRepository, Mockito.times(1)).save(Mockito.any());

        Assertions.assertNotNull(owner2);
        Assertions.assertEquals(owner, owner2);
    }

    @Test
    void delete() {
        ownerServiceJPA.delete(this.owner);

        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        ownerServiceJPA.deleteById(OWNER_ID);

        Mockito.verify(ownerRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any()))
                .thenReturn(this.owner);

        Owner ownerFound = ownerServiceJPA.findByLastName(OWNER_LAST_NAME);
        Mockito.verify(ownerRepository, Mockito.times(1)).findByLastName(Mockito.any());

        Assertions.assertNotNull(ownerFound);
        Assertions.assertEquals(this.owner, ownerFound);
        Assertions.assertEquals(OWNER_LAST_NAME, ownerFound.getLastName());
    }
}