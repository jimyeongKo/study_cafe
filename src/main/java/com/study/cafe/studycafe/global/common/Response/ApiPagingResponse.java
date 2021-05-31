package com.study.cafe.studycafe.global.common.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiPagingResponse<T> {
    private HttpStatus status;

    private PageResponse<T> data;
}
