package course.java3.backend.repositories;

import course.java3.backend.Entities.Sceance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISceanceRepository extends JpaRepository<Sceance, Long> {
}
