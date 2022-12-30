package kdv.spring.kdvpetclinic.model;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column
    private String name;

    @Builder
    public PetType(String name) {
        this.name = name;
    }

    public PetType() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
