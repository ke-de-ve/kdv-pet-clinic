package kdv.spring.kdvpetclinic.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "pets")
public class Pet extends BaseEntity{

    private String Name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
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
