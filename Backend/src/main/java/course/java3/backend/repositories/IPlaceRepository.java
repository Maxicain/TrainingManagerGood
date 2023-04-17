package course.java3.backend.repositories;

import course.java3.backend.Entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaceRepository extends JpaRepository<Place, Long> {
}
