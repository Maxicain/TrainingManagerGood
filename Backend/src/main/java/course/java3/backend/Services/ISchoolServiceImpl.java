package course.java3.backend.Services;

import course.java3.backend.Entities.*;

import java.util.List;

public interface ISchoolServiceImpl {
    //Trouver toutes les villes
    public List<Ville> FindAllVille();
    //Trouver tous les établissements par l'id d'une ville
    public List<Etablissement> FindEtablissementByVilleId(Long id);
    //Trouver toutes les salles par l'id d'un établissement donné
    public List<Salle> FindSalleByEtablissementId(Long id);
    //Trouver une liste de présentations par l'id d'une salle
    public List<Presentation> FindPresentationBySalleId(Long salleId);
    //Trouver une liste des coupons pour une présentation donnée
    public List<Coupon> FindCouponsByPresentation_Id(Long presId);
    //Trouver un coupon par son id
    public Coupon FindCouponById(Long id);
    //Enregistrement d'un coupon dans la base de données
    public Coupon saveCoupon(Coupon coupon);
}
