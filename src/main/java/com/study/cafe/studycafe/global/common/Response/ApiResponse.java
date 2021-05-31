package com.study.cafe.studycafe.global.common.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private HttpStatus status;

    private T data;
}
