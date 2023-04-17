package course.java3.backend.controller;

import course.java3.backend.Entities.Etablissement;
import course.java3.backend.Entities.Ville;
import course.java3.backend.repositories.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SchoolAppController {

    @Autowired
    public SchoolServiceImpl schoolRepoImpl;

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    public List<Ville> VilleJSON(){
        return schoolRepoImpl.FindAllVille();
    }

    @RequestMapping(value = "/ville/{id}", method = RequestMethod.GET)
    public List<Etablissement> EtablissementsJSON(@PathVariable Long id){
        return schoolRepoImpl.FindEtablissementByVilleId(id);
    }
}
