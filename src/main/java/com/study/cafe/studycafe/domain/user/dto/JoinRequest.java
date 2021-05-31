package com.study.cafe.studycafe.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {

    @NonNull
    @Min(10)
    @Max(11)
    private String phoneNum;

    @NonNull
    @Min(2)
    private String name;

    @NonNull
    @Min(8)
    @Max(10)
    private String password;

    @NonNull
    @NotBlank
    private int age;
}
