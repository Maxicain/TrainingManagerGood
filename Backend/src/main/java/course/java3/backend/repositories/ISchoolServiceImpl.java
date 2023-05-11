package course.java3.backend.repositories;

import course.java3.backend.Entities.*;

import java.util.List;

public interface ISchoolServiceImpl {
    public List<Ville> FindAllVille();
    public List<Etablissement> FindEtablissementByVilleId(Long id);
    public List<Salle> FindSalleByEtablissementId(Long id);
    public List<Cours> FindCoursBySalleId(Long id);
    public Specialite FindSpecialiteByCoursID(Long id);
    public List<Presentation> FindPresentationBySalleId(Long salleId);

    public Sceance FindSceanceByPresentationId(Long id);
    public List<Coupon> FindAvailableCouponsBySceanceId(Long id);
    public Coupon FindPlaceByCouponId(Long id);
}
