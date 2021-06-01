package com.study.cafe.studycafe.domain.magnet.dto;

import com.study.cafe.studycafe.domain.magnet.domain.Magnet;
import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MagnetResponse {

    private Long id;

    private MagnetType title;

    private String num;

    private Boolean isAvailable;

    public MagnetResponse(Magnet magnet) {
        this.id = magnet.getId();
        this.title = magnet.getTitle();
        this.num = magnet.getNum();
        this.isAvailable = magnet.getIsAvailable();
    }
}
