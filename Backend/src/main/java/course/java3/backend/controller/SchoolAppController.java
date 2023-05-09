package course.java3.backend.controller;

import course.java3.backend.Entities.Etablissement;
import course.java3.backend.Entities.Presentation;
import course.java3.backend.Entities.Salle;
import course.java3.backend.Entities.Ville;
import course.java3.backend.repositories.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SchoolAppController {

    @Autowired
    public SchoolServiceImpl schoolRepoImpl;

    @RequestMapping(value = "/villes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ville> getVilleJSON(){
        return schoolRepoImpl.FindAllVille();
    }

    @RequestMapping(value = "/etablissement/{villeId}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Etablissement> getEtablissementsJSON(@PathVariable Long villeId){
        return schoolRepoImpl.FindEtablissementByVilleId(villeId);
    }

    @RequestMapping(value = "/salle/{etabId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salle> getSallesJson(@PathVariable Long etabId){
        return schoolRepoImpl.FindSalleByEtablissementId(etabId);
    }

    @RequestMapping(value = "/presentations/{salleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Presentation> getPresentationsJson(@PathVariable Long salleId){
        var pres = schoolRepoImpl.FindPresentationBySalleId(salleId);
        return pres;
    }
}
