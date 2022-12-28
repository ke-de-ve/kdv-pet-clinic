package kdv.spring.kdvpetclinic.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    private Long id;

    public BaseEntity() {
        super();
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
