package kdv.spring.kdvpetclinic.model;

import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Vet() {
        super();
    }

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = Objects.requireNonNullElseGet(specialities, HashSet::new);
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
