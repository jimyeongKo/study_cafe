package com.study.cafe.studycafe.domain.user.application;

import com.study.cafe.studycafe.domain.user.domain.User;
import com.study.cafe.studycafe.domain.user.dto.JoinRequest;
import com.study.cafe.studycafe.domain.user.dto.JoinResponse;
import com.study.cafe.studycafe.domain.user.exception.PhoneNumDuplicationException;
import com.study.cafe.studycafe.domain.user.persistence.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class JoinService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public JoinResponse joinUser(JoinRequest request) {
        phoneDuplication(request.getPhoneNum());

        User user = User.create(request, passwordEncoder.encode(request.getPassword()));

        return new JoinResponse(userRepository.save(user));
    }

    private void phoneDuplication(String phoneNum) {
        User user = userRepository.findByPhoneNum(phoneNum);

        if (user != null) {
            throw new PhoneNumDuplicationException(phoneNum);
        }
    }
}
