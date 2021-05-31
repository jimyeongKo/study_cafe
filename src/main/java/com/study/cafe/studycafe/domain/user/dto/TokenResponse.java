package com.study.cafe.studycafe.domain.user.dto;

import com.study.cafe.studycafe.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private JoinResponse user;

    private String token;

    public TokenResponse(String token, final User user) {
        this.token = token;
        this.user = new JoinResponse(user);
    }
}
