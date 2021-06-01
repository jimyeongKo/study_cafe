package com.study.cafe.studycafe.domain.user.dto;

import com.study.cafe.studycafe.domain.coupon.dto.CouponResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponResponse {
    private Long id;

    private String userName;

    private CouponResponse coupon;

    private LocalDateTime createAt;

    public UserCouponResponse
}
