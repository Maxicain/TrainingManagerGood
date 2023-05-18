package course.java3.backend.Repositories;

import course.java3.backend.Entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEtablissementRepository extends JpaRepository<Etablissement, Long> {
    //Fetch des établissements par l'id d'une ville
    List<Etablissement> findAllByVille_Id(Long id);
}
