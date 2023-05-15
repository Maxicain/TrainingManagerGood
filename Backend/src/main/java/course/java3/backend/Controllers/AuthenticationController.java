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

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));

    }
}
