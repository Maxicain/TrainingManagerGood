package course.java3.backend.repositories;

import course.java3.backend.Entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IPresentationRepository extends JpaRepository<Presentation, Long> {
    List<Presentation> findAllBySalle_Numero(Long numero);
}
