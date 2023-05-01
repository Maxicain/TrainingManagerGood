package course.java3.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private int nbrCredit;
    private int duree;
    @OneToMany(mappedBy = "cours")
    private List<Presentation> presentations;
    @OneToOne
    private Specialite specialite;
}
