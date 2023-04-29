package course.java3.backend.repositories;

import course.java3.backend.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public List<Cours> FindCoursBySalleId(Long id) {
        return null;
    }

    @Override
    public Specialite FindSpecialiteByCoursID(Long id) {
        return null;
    }

    @Override
    public List<Presentation> FindPresentationByCoursAndSalleId(Long coursId, Long salleId) {
        return null;
    }

    @Override
    public Sceance FindSceanceByPresentationId(Long id) {
        return null;
    }

    @Override
    public List<Coupon> FindAvailableCouponsBySceanceId(Long id) {
        return null;
    }

    @Override
    public Coupon FindPlaceByCouponId(Long id) {
        return null;
    }
}
