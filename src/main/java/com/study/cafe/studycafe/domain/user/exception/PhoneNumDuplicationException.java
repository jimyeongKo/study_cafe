package com.study.cafe.studycafe.domain.user.exception;

import com.study.cafe.studycafe.global.error.ErrorCode;
import com.study.cafe.studycafe.global.error.InvalidValueException;

public class PhoneNumDuplicationException extends InvalidValueException {
    public PhoneNumDuplicationException(String value) {
        super(value, ErrorCode.PHONENUM_DUPLICATION);
    }
}
