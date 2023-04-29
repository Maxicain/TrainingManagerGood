package course.java3.backend.repositories;

import course.java3.backend.Entities.Etablissement;
import course.java3.backend.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findAllByEtablissement_Id(Long id);
}
