package course.java3.backend.Repositories;

import course.java3.backend.Entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPresentationRepository extends JpaRepository<Presentation, Long> {
    List<Presentation> findAllBySalle_Numero(Long numero);
}
