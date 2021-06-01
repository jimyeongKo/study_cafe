package com.study.cafe.studycafe.domain.magnet.dto;

import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MagnetRequest {

    private MagnetType title;

    private String num;
}
