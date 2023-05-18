package course.java3.backend.Repositories;

import course.java3.backend.Entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICouponRepository extends JpaRepository<Coupon, Long> {
    //Fetch des coupons par l'id d'une présentation
    public List<Coupon> findAllByPresentation_Id(Long presentationId);
}
