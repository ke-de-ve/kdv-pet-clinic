package kdv.spring.kdvpetclinic.model;

import lombok.Builder;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities;

    public Vet() {
        super();
    }

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
