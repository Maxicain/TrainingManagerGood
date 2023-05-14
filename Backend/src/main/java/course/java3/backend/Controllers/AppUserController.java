package course.java3.backend.Controllers;

import course.java3.backend.Entities.AppUser;
import course.java3.backend.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class AppUserController {
    @Autowired
    private AppUserService accountService;

    @PostMapping(path = "/users")
    public AppUser postUser(@RequestBody AppUser user){
        return accountService.addUser(user);
    }

    @PostMapping(path = "/auth/")
    public void loginWithUserAndPassword(@RequestBody AppUser user){

    }
}
