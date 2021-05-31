package com.study.cafe.studycafe.domain.user.api;

import com.study.cafe.studycafe.domain.user.application.JoinService;
import com.study.cafe.studycafe.domain.user.dto.JoinRequest;
import com.study.cafe.studycafe.domain.user.dto.JoinResponse;
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
@RequestMapping("join")
@Slf4j
public class JoinApi {

    private final JoinService joinService;

    @PostMapping
    public ApiResponse<JoinResponse> join(@RequestBody JoinRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, joinService.joinUser(request));
    }
}
