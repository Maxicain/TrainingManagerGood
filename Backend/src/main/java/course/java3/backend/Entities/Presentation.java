package course.java3.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presentation {
    @Id
    private Date date;
    private int duree;
    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @OneToOne
    private Sceance sceance;
    @OneToMany
    private Set<Coupon> coupons;
}
