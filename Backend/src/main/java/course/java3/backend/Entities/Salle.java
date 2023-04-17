package course.java3.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String nom;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etablissement etablissement;
    @OneToMany(mappedBy = "salle")
    private Set<Presentation> presentations;
}
