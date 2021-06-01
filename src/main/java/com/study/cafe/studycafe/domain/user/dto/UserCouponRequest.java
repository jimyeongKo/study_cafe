package com.study.cafe.studycafe.domain.user.dto;

import com.study.cafe.studycafe.domain.coupon.domain.Coupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponRequest {

    private Long coupon;

    private LocalDateTime createTime;
}
