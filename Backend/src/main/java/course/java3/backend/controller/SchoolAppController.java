package course.java3.backend.controller;

import course.java3.backend.Entities.Etablissement;
import course.java3.backend.Entities.Ville;
import course.java3.backend.repositories.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SchoolAppController {

    @Autowired
    public SchoolServiceImpl schoolRepoImpl;

    @RequestMapping(value = "/villes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ville> VilleJSON(){
        return schoolRepoImpl.FindAllVille();
    }

    @RequestMapping(value = "/etablissement/{villeId}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Etablissement> EtablissementsJSON(@PathVariable Long villeId){
        return schoolRepoImpl.FindEtablissementByVilleId(villeId);
    }
}
