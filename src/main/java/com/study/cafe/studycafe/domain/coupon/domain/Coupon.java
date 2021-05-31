package com.study.cafe.studycafe.domain.coupon.domain;

import com.study.cafe.studycafe.domain.coupon.dto.CouponRequest;
import com.study.cafe.studycafe.domain.coupon.model.CouponType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int time;

    private String content; // 설명

    private CouponType type;

    public static Coupon createCoupon(CouponRequest request) {
        return Coupon.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .time(request.getTime())
                .type(request.getType())
                .build();
    }

    public void updateCoupon(CouponRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.time = request.getTime();
        this.type = request.getType();
    }
}
