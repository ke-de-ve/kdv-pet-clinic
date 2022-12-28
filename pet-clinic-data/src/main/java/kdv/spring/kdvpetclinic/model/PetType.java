package kdv.spring.kdvpetclinic.model;

import lombok.Builder;

public class PetType extends BaseEntity {

    private String name;

    @Builder
    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
