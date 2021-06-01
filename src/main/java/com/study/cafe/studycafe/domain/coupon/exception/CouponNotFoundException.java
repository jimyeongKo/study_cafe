package com.study.cafe.studycafe.domain.coupon.exception;

import com.study.cafe.studycafe.global.error.ErrorCode;
import com.study.cafe.studycafe.global.error.InvalidValueException;

public class CouponNotFoundException extends InvalidValueException {

    public CouponNotFoundException(String value) {
        super(value, ErrorCode.COUPON_NOT_FOUND);
    }
}
