package com.study.cafe.studycafe.domain.user.api;

import com.study.cafe.studycafe.domain.user.application.LoginService;
import com.study.cafe.studycafe.domain.user.dto.LoginRequest;
import com.study.cafe.studycafe.domain.user.dto.TokenResponse;
import com.study.cafe.studycafe.global.common.Response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
@Slf4j
public class LoginApi {

    private final LoginService service;

    @PostMapping
    public ApiResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        return new ApiResponse<>(HttpStatus.OK, service.login(request));
    }
}
