package kdv.spring.kdvpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by jt on 7/29/18.
 */
@Entity
@Table(name = "visits")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Override
    public String toString() {
        return "Visit{ id=" + getId() +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", pet=" + pet +
                '}';
    }
}
