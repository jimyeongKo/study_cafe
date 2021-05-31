package com.study.cafe.studycafe.domain.coupon.api;

import com.study.cafe.studycafe.domain.coupon.application.CouponsService;
import com.study.cafe.studycafe.domain.coupon.dto.CouponRequest;
import com.study.cafe.studycafe.domain.coupon.dto.CouponResponse;
import com.study.cafe.studycafe.global.common.Response.ApiPagingResponse;
import com.study.cafe.studycafe.global.common.Response.ApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("coupon")
public class CouponApi {

    private final CouponsService service;

    @PostMapping
    public ApiResponse<CouponResponse> createCoupon(@RequestBody CouponRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.createCoupon(request));
    }

    @GetMapping("/all")
    public ApiPagingResponse<CouponResponse> findAll(@RequestParam int page) {
        return new ApiPagingResponse<>(HttpStatus.OK, service.findAll(page));
    }

    @GetMapping("{couponId}")
    public ApiResponse<CouponResponse> findOne(@PathVariable Long couponId) {
        return new ApiResponse<>(HttpStatus.OK, service.findOne(couponId));
    }

    @PatchMapping("{couponId}/refresh")
    public ApiResponse<CouponResponse> update(@RequestBody CouponRequest request, @PathVariable Long couponId) {
        return new ApiResponse<>(HttpStatus.OK, service.updateCoupon(couponId, request));
    }

    @DeleteMapping("{couponId}")
    public ApiResponse<String> delete(@PathVariable Long couponId) {
        return new ApiResponse<>(HttpStatus.OK, service.deleteCoupon(couponId));
    }


}
