package course.java3.backend.repositories;

import course.java3.backend.Entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICouponRepository extends JpaRepository<Coupon, Long> {
    public List<Coupon> findAllByPresentation_Id(Long presentationId);
}
