package com.study.cafe.studycafe.global.common.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiListResponse<T> {
    private HttpStatus status;

    private List<T> data;
}
