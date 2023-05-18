package course.java3.backend.Services;

import course.java3.backend.Entities.AppRole;
import course.java3.backend.Entities.AppUser;
import course.java3.backend.Entities.auth.AuthenticationRequest;
import course.java3.backend.Entities.auth.AuthenticationResponse;
import course.java3.backend.Entities.auth.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAppUserService extends UserDetailsService {
    //Fetch un appUser de l'application par son username
    AppUser loadUserByUsername(String username);

    //Fetch le retour de la réponse de l'application après l'inscription à Spring security
    AuthenticationResponse register(RegisterRequest request);

    //Fetch le retour de la réponse de l'application après la connexion à Spring Security
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
