package course.java3.backend.Controllers;

import course.java3.backend.Entities.*;
import course.java3.backend.Services.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SchoolAppController {

    @Autowired
    public SchoolServiceImpl schoolRepoImpl;

    @RequestMapping(value = "/villes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ville> getVilleJSON(){
        return schoolRepoImpl.FindAllVille();
    }

    @RequestMapping(value = "/etablissement/{villeId}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Etablissement> getEtablissementsJSON(@PathVariable Long villeId){
        return schoolRepoImpl.FindEtablissementByVilleId(villeId);
    }

    @RequestMapping(value = "/salle/{etabId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salle> getSallesJson(@PathVariable Long etabId){
        return schoolRepoImpl.FindSalleByEtablissementId(etabId);
    }

    @RequestMapping(value = "/presentations/{salleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Presentation> getPresentationsJson(@PathVariable Long salleId){
        return schoolRepoImpl.FindPresentationBySalleId(salleId);
    }

    @RequestMapping(value = "/coupons/{presentationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coupon> getCouponsJson(@PathVariable Long presentationId){
        return schoolRepoImpl.FindCouponsByPresentation_Id(presentationId);
    }

    @RequestMapping(value = "/reserve/{couponId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Coupon reserveCoupon(@PathVariable Long couponId, @RequestBody Coupon newCoupon){
        var coupon = schoolRepoImpl.FindCouponById(couponId);
        coupon.setNomClient(newCoupon.getNomClient());
        coupon.setReserve(newCoupon.isReserve());
        coupon.setCodePaiement(Coupon.generateBarcode(12));
        return schoolRepoImpl.saveCoupon(coupon);
    }
}
