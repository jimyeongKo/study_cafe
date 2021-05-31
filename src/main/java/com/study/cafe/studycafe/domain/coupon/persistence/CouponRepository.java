package com.study.cafe.studycafe.domain.coupon.persistence;

import com.study.cafe.studycafe.domain.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
