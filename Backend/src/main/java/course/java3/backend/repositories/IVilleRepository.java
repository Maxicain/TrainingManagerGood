package course.java3.backend.repositories;

import course.java3.backend.Entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVilleRepository extends JpaRepository<Ville, Long> {
}
