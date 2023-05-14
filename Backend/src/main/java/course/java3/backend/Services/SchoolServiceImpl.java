package course.java3.backend.Services;

import course.java3.backend.Entities.*;
import course.java3.backend.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Component("schoolRepoImpl")
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

    @Override
    public List<Ville> FindAllVille() {
        return vRepo.findAll(Sort.by(Sort.Direction.ASC, "nom"));
    }

    @Override
    public List<Etablissement> FindEtablissementByVilleId(Long id) {
        return eRepo.findAllByVille_Id(id);
    }

    @Override
    public List<Salle> FindSalleByEtablissementId(Long id) {
        return salleRepo.findAllByEtablissement_Id(id);
    }

    @Override
    public List<Presentation> FindPresentationBySalleId(Long salleId) {
        return presRepo.findAllBySalle_Numero(salleId);
    }

    @Override
    public List<Coupon> FindCouponsByPresentation_Id(Long presentationId){
        return coupRepo.findAllByPresentation_Id(presentationId);
    }

    @Override
    public Coupon FindCouponById(Long id) {
        return coupRepo.findById(id).orElse(null);
    }

    @Override
    public Coupon saveCoupon(Coupon coupon){
        coupRepo.save(coupon);
        return coupon;
    }
}
