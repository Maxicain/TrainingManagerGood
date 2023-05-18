package course.java3.backend.Services;

import course.java3.backend.Entities.*;
import course.java3.backend.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//@Component("schoolRepoImpl")
public class SchoolServiceImpl implements ISchoolServiceImpl {

    @Autowired
    private IVilleRepository vRepo;
    @Autowired
    private IEtablissementRepository eRepo;
    @Autowired
    private ISalleRepository salleRepo;
    @Autowired
    private IPresentationRepository presRepo;
    @Autowired
    private ICouponRepository coupRepo;

    //Trouve et retourne toutes les villes
    @Override
    public List<Ville> FindAllVille() {
        return vRepo.findAll(Sort.by(Sort.Direction.ASC, "nom"));
    }

    //Trouve et retourne une liste d'établissements pour l'id d'une ville donnée en paramètre
    @Override
    public List<Etablissement> FindEtablissementByVilleId(Long id) {
        return eRepo.findAllByVille_Id(id);
    }

    //Trouve et retourne une liste de salles selon l'id un établissement donné en paramètres
    @Override
    public List<Salle> FindSalleByEtablissementId(Long id) {
        return salleRepo.findAllByEtablissement_Id(id);
    }

    //Trouve et retourne une liste de présentations pour l'id d'une salle donné en paramètre
    @Override
    public List<Presentation> FindPresentationBySalleId(Long salleId) {
        return presRepo.findAllBySalle_Numero(salleId);
    }

    //Trouve et retourne une liste de coupons par l'id d'une présentation donné en paramètres
    @Override
    public List<Coupon> FindCouponsByPresentation_Id(Long presentationId){
        return coupRepo.findAllByPresentation_Id(presentationId);
    }

    //Trouve et retourne un coupon par son id
    @Override
    public Coupon FindCouponById(Long id) {
        return coupRepo.findById(id).orElse(null);
    }

    //Enregistre un coupon dans la base de données et le retourne
    @Override
    public Coupon saveCoupon(Coupon coupon){
        coupRepo.save(coupon);
        return coupon;
    }
}
