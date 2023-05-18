package course.java3.backend.Repositories;

import course.java3.backend.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    //Fetch d'un user Spring Security par son nom d'usager (le nom est unique)
    AppUser findByUsername(String username);
}
