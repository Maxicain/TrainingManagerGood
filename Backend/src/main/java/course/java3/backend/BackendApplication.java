package course.java3.backend;

import course.java3.backend.Entities.*;
import course.java3.backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
    @Autowired IVilleRepository vRepo;
    @Autowired IEtablissementRepository eRepo;
    @Autowired ISpecialiteRepository specRepo;
    @Autowired ICoursRepository cRepo;
    @Autowired ISalleRepository sRepo;
    @Autowired IPlaceRepository pRepo;
    @Autowired ISceanceRepository scRepo;
    @Autowired ICouponRepository couponRepo;
    @Autowired IPresentationRepository presRepo;

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
                new Etablissement(null, "Cegep du Vieux Montreal", mtlRepo),
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

        List<Specialite> specialites = Arrays.asList(
            new Specialite(null, "Computer Science", null),
            new Specialite(null, "Mathematics", null),
            new Specialite(null, "Langues", null)
        );
        specRepo.saveAll(specialites);

        Specialite cs = specRepo.findById(1l).get();
        Specialite math = specRepo.findById(2l).get();
        Specialite langues = specRepo.findById(3l).get();

        List<Cours> allCourses = Arrays.asList(
            new Cours(null, "Programmation Orientée Objet 1", "Programmation en Java et introduction aux concepts de l'orienté objet.",3,6,null, cs),
            new Cours(null, "Programmation Orientée Objet 2", "Programmation en Java et concepts avancés de l'orienté objet.",3,6,null, cs),
            new Cours(null, "Programmation Web Transactionnelle", "Programmation en Java d'applications serveurs.",3,6,null, cs),
            new Cours(null, "Calcul différentiel", "Apprendre comment dériver.",3,6,null, math),
            new Cours(null, "Calcul intégral", "Apprendre comment intégrer.",3,6,null, math),
            new Cours(null, "Algèbre linéaire", "Vecteurs et matrices.",3,6,null, math),
            new Cours(null, "Anglais 1", "Anglais de base.",3,6,null, langues),
            new Cours(null, "Anglais 2", "Anglais intermédiaire.",3,6,null, langues),
            new Cours(null, "Français 1", "Français de base.",3,6,null, langues),
            new Cours(null, "Français 2", "Français intermédiaire.",3,6,null, langues)
        );
        cRepo.saveAll(allCourses);

        cs.setCours(allCourses.subList(0,2));
        math.setCours(allCourses.subList(3,5));
        langues.setCours(allCourses.subList(6,9));

        specRepo.saveAll(specialites);

        List<Salle> salles = Arrays.asList(
            new Salle(null,"A-100", EtabMontreal.get(0), null),
            new Salle(null,"A-200", EtabMontreal.get(0), null),
            new Salle(null,"B-100", EtabMontreal.get(1), null),
            new Salle(null,"B-200", EtabMontreal.get(1), null),
            new Salle(null,"C-100", EtabToronto.get(0), null),
            new Salle(null,"C-200", EtabToronto.get(0), null),
            new Salle(null,"D-100", EtabToronto.get(1), null),
            new Salle(null,"D-200", EtabToronto.get(1), null)
        );
        sRepo.saveAll(salles);

        List<Place> places = Arrays.asList(
            new Place(null,"R1-01",salles.get(0),null),
            new Place(null,"R1-02",salles.get(0),null),
            new Place(null,"R1-03",salles.get(0),null),
            new Place(null,"R1-04",salles.get(0),null),
            new Place(null,"R1-05",salles.get(0),null),
            new Place(null,"R2-01",salles.get(0),null),
            new Place(null,"R2-02",salles.get(0),null),
            new Place(null,"R2-03",salles.get(0),null),
            new Place(null,"R2-04",salles.get(0),null),
            new Place(null,"R2-05",salles.get(0),null),
            new Place(null,"R3-01",salles.get(0),null),
            new Place(null,"R3-02",salles.get(0),null),
            new Place(null,"R3-03",salles.get(0),null),
            new Place(null,"R3-04",salles.get(0),null),
            new Place(null,"R3-05",salles.get(0),null),
            new Place(null,"R4-01",salles.get(0),null),
            new Place(null,"R4-02",salles.get(0),null),
            new Place(null,"R4-03",salles.get(0),null),
            new Place(null,"R4-04",salles.get(0),null),
            new Place(null,"R4-05",salles.get(0),null),
            new Place(null,"R1-01",salles.get(1),null),
            new Place(null,"R1-02",salles.get(1),null),
            new Place(null,"R1-03",salles.get(1),null),
            new Place(null,"R1-04",salles.get(1),null),
            new Place(null,"R1-05",salles.get(1),null),
            new Place(null,"R2-01",salles.get(1),null),
            new Place(null,"R2-02",salles.get(1),null),
            new Place(null,"R2-03",salles.get(1),null),
            new Place(null,"R2-04",salles.get(1),null),
            new Place(null,"R2-05",salles.get(1),null),
            new Place(null,"R3-01",salles.get(1),null),
            new Place(null,"R3-02",salles.get(1),null),
            new Place(null,"R3-03",salles.get(1),null),
            new Place(null,"R3-04",salles.get(1),null),
            new Place(null,"R3-05",salles.get(1),null),
            new Place(null,"R4-01",salles.get(1),null),
            new Place(null,"R4-02",salles.get(1),null),
            new Place(null,"R4-03",salles.get(1),null),
            new Place(null,"R4-04",salles.get(1),null),
            new Place(null,"R4-05",salles.get(1),null)
        );
        pRepo.saveAll(places);

        List<Sceance> sceances = Arrays.asList(
            new Sceance(null,"9h",null),
            new Sceance(null,"13h",null),
            new Sceance(null,"16h",null)
        );
        scRepo.saveAll(sceances);

        List<Coupon> coupons = Arrays.asList(
            new Coupon(null, null, 5d, null, false, null, places.get(0)),
            new Coupon(null, "Robert", 5d, null, true, null, places.get(1)),
            new Coupon(null, "Jean", 5d, null, true, null, places.get(2)),
            new Coupon(null, null, 5d, null, false, null, places.get(3)),
            new Coupon(null, null, 5d, null, false, null, places.get(4)),
            new Coupon(null, null, 5d, null, false, null, places.get(5)),
            new Coupon(null, null, 5d, null, false, null, places.get(6)),
            new Coupon(null, null, 5d, null, false, null, places.get(7)),
            new Coupon(null, null, 5d, null, false, null, places.get(8)),
            new Coupon(null, null, 5d, null, false, null, places.get(9)),
            new Coupon(null, null, 5d, null, false, null, places.get(10)),
            new Coupon(null, null, 5d, null, false, null, places.get(11)),
            new Coupon(null, null, 5d, null, false, null, places.get(12)),
            new Coupon(null, null, 5d, null, false, null, places.get(13)),
            new Coupon(null, null, 5d, null, false, null, places.get(14)),
            new Coupon(null, null, 5d, null, false, null, places.get(15)),
            new Coupon(null, null, 5d, null, false, null, places.get(16)),
            new Coupon(null, null, 5d, null, false, null, places.get(17)),
            new Coupon(null, null, 5d, null, false, null, places.get(18)),
            new Coupon(null, null, 5d, null, false, null, places.get(19)),
            new Coupon(null, null, 5d, null, false, null, places.get(0)),
            new Coupon(null, null, 5d, null, false, null, places.get(1)),
            new Coupon(null, null, 5d, null, false, null, places.get(2)),
            new Coupon(null, null, 5d, null, false, null, places.get(3)),
            new Coupon(null, null, 5d, null, false, null, places.get(4)),
            new Coupon(null, null, 5d, null, false, null, places.get(5)),
            new Coupon(null, null, 5d, null, false, null, places.get(6)),
            new Coupon(null, null, 5d, null, false, null, places.get(7)),
            new Coupon(null, null, 5d, null, false, null, places.get(8)),
            new Coupon(null, null, 5d, null, false, null, places.get(9)),
            new Coupon(null, null, 5d, null, false, null, places.get(10)),
            new Coupon(null, null, 5d, null, false, null, places.get(11)),
            new Coupon(null, null, 5d, null, false, null, places.get(12)),
            new Coupon(null, null, 5d, null, false, null, places.get(13)),
            new Coupon(null, null, 5d, null, false, null, places.get(14)),
            new Coupon(null, null, 5d, null, false, null, places.get(15)),
            new Coupon(null, null, 5d, null, false, null, places.get(16)),
            new Coupon(null, null, 5d, null, false, null, places.get(17)),
            new Coupon(null, null, 5d, null, false, null, places.get(18)),
            new Coupon(null, null, 5d, null, false, null, places.get(19)),
            new Coupon(null, null, 5d, null, false, null, places.get(0)),
            new Coupon(null, null, 5d, null, false, null, places.get(1)),
            new Coupon(null, null, 5d, null, false, null, places.get(2)),
            new Coupon(null, null, 5d, null, false, null, places.get(3)),
            new Coupon(null, null, 5d, null, false, null, places.get(4)),
            new Coupon(null, null, 5d, null, false, null, places.get(5)),
            new Coupon(null, null, 5d, null, false, null, places.get(6)),
            new Coupon(null, null, 5d, null, false, null, places.get(7)),
            new Coupon(null, null, 5d, null, false, null, places.get(8)),
            new Coupon(null, null, 5d, null, false, null, places.get(9)),
            new Coupon(null, null, 5d, null, false, null, places.get(10)),
            new Coupon(null, null, 5d, null, false, null, places.get(11)),
            new Coupon(null, null, 5d, null, false, null, places.get(12)),
            new Coupon(null, null, 5d, null, false, null, places.get(13)),
            new Coupon(null, null, 5d, null, false, null, places.get(14)),
            new Coupon(null, null, 5d, null, false, null, places.get(15)),
            new Coupon(null, null, 5d, null, false, null, places.get(16)),
            new Coupon(null, null, 5d, null, false, null, places.get(17)),
            new Coupon(null, null, 5d, null, false, null, places.get(18)),
            new Coupon(null, null, 5d, null, false, null, places.get(19))
        );
        couponRepo.saveAll(coupons);
        var couponsPres1 = new ArrayList<>(couponRepo.findAll().subList(0, 20));
        var couponsPres2 = new ArrayList<>(couponRepo.findAll().subList(20, 40));
        var couponsPres3 = new ArrayList<>(couponRepo.findAll().subList(40, 60));

        List<Presentation> presentations = Arrays.asList(
            new Presentation(null, LocalDate.of(2023, 3, 20),3, allCourses.get(0),  null , sceances.get(0), couponsPres1),
            new Presentation(null, LocalDate.of(2023, 3, 22),3, allCourses.get(0),  null , sceances.get(0), couponsPres2),
            new Presentation(null, LocalDate.of(2023, 3, 25),3, allCourses.get(0),  null , sceances.get(0), couponsPres3),
            new Presentation(null, LocalDate.of(2023, 3, 25),3, allCourses.get(0),  null , sceances.get(1), null)
        );
        presRepo.saveAll(presentations);

        var sallesVieuxMTL = sRepo.findAllByEtablissement_Id(1L);
        for (var salle : sallesVieuxMTL) {
            salle.setPresentations(presentations.subList(0,2));
            sRepo.save(salle);
        }

        var placesA100 = pRepo.findAll().subList(0,19);;
        int i = 0;
        for (var place : placesA100) {
            if (i < 20){
                place.setCoupon(couponRepo.findAll().get(i));
                i++;
                pRepo.save(place);
            } else return;
        }

        var presRepoData = presRepo.findAll();
        for (var p: presRepoData) {
            p.setSalle(salles.get(0));
            presRepo.save(p);
        }
    }
}
