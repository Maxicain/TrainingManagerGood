package course.java3.backend.Repositories;

import course.java3.backend.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISalleRepository extends JpaRepository<Salle, Long> {
    //Fetch des salles par l'id d'un établissement
    List<Salle> findAllByEtablissement_Id(Long id);
}
