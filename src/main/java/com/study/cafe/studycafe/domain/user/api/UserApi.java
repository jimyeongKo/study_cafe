package com.study.cafe.studycafe.domain.user.api;


import com.study.cafe.studycafe.domain.user.application.UserService;
import com.study.cafe.studycafe.domain.user.domain.User;
import com.study.cafe.studycafe.domain.user.dto.TokenResponse;
import com.study.cafe.studycafe.global.common.Response.ApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Slf4j
public class UserApi {

    private final UserService service;

    @GetMapping
    public ApiResponse<TokenResponse> me(@AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, service.me(user));
    }
}
