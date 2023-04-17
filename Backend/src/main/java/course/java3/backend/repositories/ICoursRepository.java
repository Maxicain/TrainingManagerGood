package course.java3.backend.repositories;

import course.java3.backend.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoursRepository extends JpaRepository<Cours, Long> {
}
