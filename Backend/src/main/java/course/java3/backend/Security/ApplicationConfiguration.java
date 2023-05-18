package course.java3.backend.Security;

import course.java3.backend.Repositories.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
    private final IAppUserRepository userRepo;

    //Fonction qui retourne un objet de type UserDetailsService par le fetch d'un utilisateur Spring Security selon son nom d'usager
    @Bean
    public UserDetailsService userDetailsService() {
        try {
            return userRepo::findByUsername;
        } catch (UsernameNotFoundException e){
            System.out.println(e);
            return null;
        }
    }

    //Fonction qui retourne un objet de type AuthenticationProvider par la création d'un entité de type DaoAuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    //Fonction qui retourne l'AuthenticationManager d'une AuthentificationConfiguration donnée en paramètre
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    //Méthode qui encrypte le mot de passe des utilisateurs Spring Security
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
