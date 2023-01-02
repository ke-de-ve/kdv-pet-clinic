package kdv.spring.kdvpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
@Getter
@Setter
@NoArgsConstructor
public class Speciality extends BaseEntity {

    private String description;

    public Speciality(String description) {
        this.description = description;
    }

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
