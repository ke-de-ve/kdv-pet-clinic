package kdv.spring.kdvpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
public class Pet extends BaseEntity{

    private String Name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public Pet() {
        super();
    }

    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate) {
        super(id);
        Name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
