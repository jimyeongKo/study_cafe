package com.study.cafe.studycafe.domain.user.domain;

import com.study.cafe.studycafe.domain.coupon.domain.Coupon;
import com.study.cafe.studycafe.domain.user.dto.UserCouponRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Coupon coupon;

    private LocalDateTime createTime;

    public static UserCoupon create(User user, Coupon coupon) {
        return UserCoupon.builder()
                .userId(user.getId())
                .coupon(coupon)
                .createTime(LocalDateTime.now())
                .build();
    }
}
