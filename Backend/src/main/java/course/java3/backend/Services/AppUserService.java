package course.java3.backend.Services;

import course.java3.backend.Entities.AppRole;
import course.java3.backend.Entities.AppUser;
import course.java3.backend.Repositories.IAppRoleRepository;
import course.java3.backend.Repositories.IAppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class AppUserService implements IAppUserService{
    @Autowired
    private IAppUserRepository userRepository;
    @Autowired
    private IAppRoleRepository roleRepository;


    @Override
    public AppUser addUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
