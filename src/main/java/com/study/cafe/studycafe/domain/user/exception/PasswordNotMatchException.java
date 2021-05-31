package com.study.cafe.studycafe.domain.user.exception;

import com.study.cafe.studycafe.global.error.ErrorCode;
import com.study.cafe.studycafe.global.error.InvalidValueException;

public class PasswordNotMatchException extends InvalidValueException {
    public PasswordNotMatchException(String value) {
        super(value, ErrorCode.PASSWORD_INPUT_INVALID);
    }
}
