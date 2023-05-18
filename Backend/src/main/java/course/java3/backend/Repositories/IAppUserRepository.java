package course.java3.backend.Repositories;

import course.java3.backend.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
