package course.java3.backend.repositories;

import course.java3.backend.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalleRepository extends JpaRepository<Salle, Long> {
}
