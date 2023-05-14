package course.java3.backend.Controllers;

import course.java3.backend.Entities.AppUser;
import course.java3.backend.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class AppUserController {
    @Autowired
    private AppUserService accountService;

    @GetMapping(value = "/hello")
    public String firstPage() {
        return "Hello World";
    }

    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return accountService.listUsers();
    }

    @PostMapping(path = "/users")
    public AppUser postUser(@RequestBody AppUser user){
        return accountService.addUser(user);
    }
}
