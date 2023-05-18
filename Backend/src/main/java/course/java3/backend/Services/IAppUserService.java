package course.java3.backend.Services;

import course.java3.backend.Entities.AppRole;
import course.java3.backend.Entities.AppUser;
import course.java3.backend.Entities.auth.AuthenticationRequest;
import course.java3.backend.Entities.auth.AuthenticationResponse;
import course.java3.backend.Entities.auth.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAppUserService extends UserDetailsService {
    AppUser loadUserByUsername(String username);

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
