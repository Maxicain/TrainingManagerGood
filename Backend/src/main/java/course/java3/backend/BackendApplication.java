package course.java3.backend;

import course.java3.backend.Entities.*;
import course.java3.backend.repositories.ICoursRepository;
import course.java3.backend.repositories.IEtablissementRepository;
import course.java3.backend.repositories.ISpecialiteRepository;
import course.java3.backend.repositories.IVilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
    @Autowired
    public IVilleRepository vRepo;
    @Autowired
    public IEtablissementRepository eRepo;
    @Autowired
    public ISpecialiteRepository specRepo;
    @Autowired
    public ICoursRepository cRepo;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Ville mtl = new Ville(null, "Montreal", null);
        Ville tto = new Ville(null, "Toronto", null);

        vRepo.save(mtl);
        vRepo.save(tto);

        Ville mtlRepo = vRepo.findById(1l).get();
        Ville ttoRepo = vRepo.findById(2l).get();

        List<Etablissement> EtabMontreal = Arrays.asList(
                new Etablissement(null, "Cegep du vieux Montreal", mtlRepo),
                new Etablissement(null, "UQAM", mtlRepo)
        );
        List<Etablissement> EtabToronto = Arrays.asList(
                new Etablissement(null, "University of Toronto", ttoRepo),
                new Etablissement(null, "York University", ttoRepo)
        );

        mtl.setEtablissements(EtabMontreal);
        tto.setEtablissements(EtabToronto);
        eRepo.saveAll(EtabMontreal);
        eRepo.saveAll(EtabToronto);

        Specialite compSci = new Specialite(null, "Computer Science", null);
        Specialite math = new Specialite(null, "Mathematics", null);
        Specialite langues = new Specialite(null, "Langues", null);
        specRepo.save(compSci);
        specRepo.save(math);
        specRepo.save(langues);

        Cours java1 = new Cours(null, "Programmation Orientée Objet 1", "Programmation en Java et introduction aux concepts de l'orienté objet.",3,6,null, compSci);
        Cours java2 = new Cours(null, "Programmation Orientée Objet 2", "Programmation en Java et concepts avancés de l'orienté objet.",3,6,null, compSci);
        Cours java3 = new Cours(null, "Programmation Web Transactionnelle", "Programmation en Java d'applications serveurs.",3,6,null, compSci);
        Cours calcul1 = new Cours(null, "Calcul différentiel", "Apprendre comment dériver.",3,6,null, math);
        Cours calcul2 = new Cours(null, "Calcul intégral", "Apprendre comment intégrer.",3,6,null, math);
        Cours calcul3 = new Cours(null, "Algèbre linéaire", "Vecteurs et matrices.",3,6,null, math);
        Cours anglais1 = new Cours(null, "Anglais 1", "Anglais de base.",3,6,null, langues);
        Cours anglais2 = new Cours(null, "Anglais 2", "Anglais intermédiaire.",3,6,null, langues);
        Cours francais1 = new Cours(null, "Français 1", "Français de base.",3,6,null, langues);
        Cours francais2 = new Cours(null, "Français 2", "Français intermédiaire.",3,6,null, langues);

        var allCourses = new ArrayList<Cours>();
        allCourses.add(java1);
        allCourses.add(java2);
        allCourses.add(java3);
        allCourses.add(calcul1);
        allCourses.add(calcul2);
        allCourses.add(calcul3);
        allCourses.add(anglais1);
        allCourses.add(anglais2);
        allCourses.add(francais1);
        allCourses.add(francais2);

        compSci.setCours(Set.copyOf(allCourses.subList(0,2)));
        math.setCours(Set.copyOf(allCourses.subList(3,5)));
        langues.setCours(Set.copyOf(allCourses.subList(6,9)));
//        cRepo.saveAll(allCourses);

//        specRepo.save(compSci);
//        specRepo.save(math);
//        specRepo.save(langues);


//        Presentation p1 = new Presentation(LocalDate.of(2023, 3, 25),3, java1, null , null, null);
    }
}
