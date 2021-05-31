package com.study.cafe.studycafe.domain.user.application;

import com.study.cafe.studycafe.domain.user.domain.User;
import com.study.cafe.studycafe.domain.user.dto.LoginRequest;
import com.study.cafe.studycafe.domain.user.dto.TokenResponse;
import com.study.cafe.studycafe.domain.user.exception.CheckUserInvalidException;
import com.study.cafe.studycafe.domain.user.exception.PasswordNotMatchException;
import com.study.cafe.studycafe.domain.user.persistence.UserRepository;
import com.study.cafe.studycafe.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse login(LoginRequest request) {
        User user = repository.findByPhoneNum(request.getPhoneNum());
        if (user == null) {
            throw new CheckUserInvalidException(request.getPhoneNum());
        }

        matchPassword(user.getPassword(), request.getPassword());

        String token = jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles());

        return new TokenResponse(token, user);
    }

    private void matchPassword(String encodePassword, String password) {
        if (!passwordEncoder.matches(password, encodePassword)) throw new PasswordNotMatchException(password);
    }
}
