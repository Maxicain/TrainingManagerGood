package course.java3.backend.repositories;

import course.java3.backend.Entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICouponRepository extends JpaRepository<Coupon, Long> {
}
