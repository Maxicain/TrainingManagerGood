package course.java3.backend.Repositories;

import course.java3.backend.Entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {
}
