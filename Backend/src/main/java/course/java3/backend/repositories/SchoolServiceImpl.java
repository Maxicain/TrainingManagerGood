package course.java3.backend.repositories;

import course.java3.backend.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
@Component("schoolRepoImpl")
public class SchoolServiceImpl implements ISchoolServiceImpl{

    @Autowired
    private IVilleRepository vRepo;
    @Autowired
    private IEtablissementRepository eRepo;
    @Autowired
    private ISalleRepository salleRepo;
    @Autowired
    private ICoursRepository coursRepo;
    @Autowired
    private ISpecialiteRepository specRepo;
    @Autowired
    private IPresentationRepository presRepo;
    @Autowired
    private ISceanceRepository sceaRepo;
    @Autowired
    private ICouponRepository coupRepo;
    @Autowired
    private IPlaceRepository placRepo;

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
