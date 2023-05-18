package course.java3.backend.Repositories;

import course.java3.backend.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {
    //Fetch d'un rôle de Spring Security par nom (le nom est unique)
    AppRole findByRoleName(String roleName);
}
