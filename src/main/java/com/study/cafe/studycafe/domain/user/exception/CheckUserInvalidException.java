package com.study.cafe.studycafe.domain.user.exception;

import com.study.cafe.studycafe.global.error.ErrorCode;
import com.study.cafe.studycafe.global.error.InvalidValueException;

public class CheckUserInvalidException extends InvalidValueException {
    public CheckUserInvalidException(String value) {
        super(value, ErrorCode.CHECK_USER_INVALID);
    }

}
