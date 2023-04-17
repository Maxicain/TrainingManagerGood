package course.java3.backend;

import course.java3.backend.Entities.Etablissement;
import course.java3.backend.Entities.Ville;
import course.java3.backend.repositories.IEtablissementRepository;
import course.java3.backend.repositories.IVilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
    @Autowired
    public IVilleRepository vRepo;
    @Autowired
    public IEtablissementRepository eRepo;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Etablissement> EtabMontreal = Arrays.asList(
                new Etablissement(null, "Cegep du vieux Montreal", null),
                new Etablissement(null, "UQAM", null)
        );
        List<Etablissement> EtabToronto = Arrays.asList(
                new Etablissement(null, "University of Toronto", null),
                new Etablissement(null, "York University", null)
        );
        eRepo.saveAll(EtabMontreal);
        eRepo.saveAll(EtabToronto);
        vRepo.save(new Ville(null, "Montreal", EtabMontreal));
        vRepo.save(new Ville(null, "Toronto", EtabToronto));
    }
}
