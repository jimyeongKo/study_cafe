package com.study.cafe.studycafe.domain.coupon.application;

import com.study.cafe.studycafe.domain.coupon.domain.Coupon;
import com.study.cafe.studycafe.domain.coupon.dto.CouponRequest;
import com.study.cafe.studycafe.domain.coupon.dto.CouponResponse;
import com.study.cafe.studycafe.domain.coupon.exception.CouponNotFoundException;
import com.study.cafe.studycafe.domain.coupon.persistence.CouponRepository;
import com.study.cafe.studycafe.global.common.Response.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CouponsService {

    private final CouponRepository repository;

    public CouponResponse createCoupon(CouponRequest request) {
        return new CouponResponse(repository.save(Coupon.createCoupon(request)));
    }

    public PageResponse<CouponResponse> findAll(int page) {
        Page<Coupon> coupons = repository.findAll(PageRequest.of(page, 10, Sort.Direction.DESC, "time"));

        List<CouponResponse> data = coupons.getContent().stream().map(CouponResponse::new).collect(Collectors.toList());

        return new PageResponse<>(page, coupons.getTotalPages(), coupons.getTotalElements(), data);
    }

    public CouponResponse findOne(Long couponId) {
        Coupon coupon = repository.findById(couponId).orElse(null);
        if (coupon == null) {
            throw new CouponNotFoundException(couponId.toString());
        }
        return new CouponResponse(coupon);
    }

    public CouponResponse updateCoupon(Long couponId, CouponRequest request) {
        Coupon coupon = repository.findById(couponId).orElse(null);

        if (coupon == null) {
            throw new CouponNotFoundException(couponId.toString());
        }
        coupon.updateCoupon(request);

        return new CouponResponse(coupon);
    }

    public String deleteCoupon(Long couponId) {
        Coupon coupon = repository.findById(couponId).orElse(null);

        if (coupon == null) {
            throw new CouponNotFoundException(couponId.toString());
        }
        repository.delete(coupon);

        return "Y";
    }

}
