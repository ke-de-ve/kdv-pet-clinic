package kdv.spring.kdvpetclinic.model;

import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
public class Owner extends Person {

    private String address;

    private String city;

    private String telephone;

    private Set<Pet> pets = new HashSet<>();;

    public Owner() {
        super();
    }

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = Objects.requireNonNullElseGet(pets, HashSet::new);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
