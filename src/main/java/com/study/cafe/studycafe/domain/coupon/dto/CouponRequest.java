package com.study.cafe.studycafe.domain.coupon.dto;

import com.study.cafe.studycafe.domain.coupon.model.CouponType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CouponRequest {

    private String title;

    private int time;

    private String content; // 설명

    private CouponType type;
}
