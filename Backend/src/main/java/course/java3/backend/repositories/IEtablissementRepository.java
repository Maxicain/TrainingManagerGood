package course.java3.backend.repositories;

import course.java3.backend.Entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEtablissementRepository extends JpaRepository<Etablissement, Long> {
    List<Etablissement> findAllByVille_Id(Long id);
}
