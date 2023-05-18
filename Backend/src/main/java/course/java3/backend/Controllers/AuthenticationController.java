package course.java3.backend.Controllers;

import course.java3.backend.Entities.auth.AuthenticationRequest;
import course.java3.backend.Entities.auth.AuthenticationResponse;
import course.java3.backend.Entities.auth.RegisterRequest;
import course.java3.backend.Services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AppUserService service;

    // Méthode GET qui retourne un message de succès à la connexion à l'application
    @GetMapping("hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from UNSECURED WHITELISTED endpoint");
    }

    //Méthode POST d'inscription à l'application
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    //Méthode POST de connexion à l'application depuis JWT
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var response = service.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
