package com.study.cafe.studycafe.domain.coupon.dto;

import com.study.cafe.studycafe.domain.coupon.domain.Coupon;
import com.study.cafe.studycafe.domain.coupon.model.CouponType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {

    private Long id;

    private String title;

    private int time;

    private String content; // 설명

    private CouponType type;

    public CouponResponse(Coupon coupon) {
        this.id = coupon.getId();
        this.title = coupon.getTitle();
        this.time = coupon.getTime();
        this.content = coupon.getContent();
        this.type = coupon.getType();
    }
}
