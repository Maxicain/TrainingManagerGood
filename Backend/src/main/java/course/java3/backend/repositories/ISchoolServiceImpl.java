package course.java3.backend.repositories;

import course.java3.backend.Entities.*;

import java.util.List;

public interface ISchoolServiceImpl {
    public List<Ville> FindAllVille();
    public List<Etablissement> FindEtablissementByVilleId(Long id);
    public List<Salle> FindSalleByEtablissementId(Long id);
    public List<Presentation> FindPresentationBySalleId(Long salleId);
    public List<Coupon> FindCouponsByPresentation_Id(Long presId);
    public Coupon FindCouponById(Long id);
    public Coupon saveCoupon(Coupon coupon);
}
