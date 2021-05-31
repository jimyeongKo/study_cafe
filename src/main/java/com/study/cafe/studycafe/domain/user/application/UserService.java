package com.study.cafe.studycafe.domain.user.application;

import com.study.cafe.studycafe.domain.user.domain.User;
import com.study.cafe.studycafe.domain.user.dto.TokenResponse;
import com.study.cafe.studycafe.domain.user.persistence.UserRepository;
import com.study.cafe.studycafe.global.common.Response.ApiResponse;
import com.study.cafe.studycafe.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;

    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse me(User user) {
        User me = repository.findById(user.getId()).orElse(null);

        String token = jwtTokenProvider.createToken(String.valueOf(me.getId()), me.getRoles());

        return new TokenResponse(token, me);
    }
}
