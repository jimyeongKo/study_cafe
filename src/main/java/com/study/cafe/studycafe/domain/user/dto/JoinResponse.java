package com.study.cafe.studycafe.domain.user.dto;

import com.study.cafe.studycafe.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinResponse {

    private Long id;

    private String phoneNum;

    private int age;

    private String name;

    public JoinResponse(User user) {
        this.id = user.getId();
        this.phoneNum = user.getPhoneNum();
        this.age = user.getAge();
        this.name = user.getName();
    }
}
