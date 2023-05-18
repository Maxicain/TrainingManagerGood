package course.java3.backend.Repositories;

import course.java3.backend.Entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaceRepository extends JpaRepository<Place, Long> {
}
