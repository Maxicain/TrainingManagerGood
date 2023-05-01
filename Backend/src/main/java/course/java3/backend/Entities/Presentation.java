package course.java3.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
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
    private List<Coupon> coupons;
}
