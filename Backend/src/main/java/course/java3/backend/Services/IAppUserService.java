package course.java3.backend.Services;

import course.java3.backend.Entities.AppRole;
import course.java3.backend.Entities.AppUser;

import java.util.List;

public interface IAppUserService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
