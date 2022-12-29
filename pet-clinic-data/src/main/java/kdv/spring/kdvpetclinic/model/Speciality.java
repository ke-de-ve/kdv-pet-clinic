package kdv.spring.kdvpetclinic.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Speciality extends BaseEntity {

    private String description;

    public Speciality() {
        super();
    }

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
