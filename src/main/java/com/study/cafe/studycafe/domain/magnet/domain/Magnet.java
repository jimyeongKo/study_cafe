package com.study.cafe.studycafe.domain.magnet.domain;

import com.study.cafe.studycafe.domain.magnet.dto.MagnetRequest;
import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Magnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MagnetType title;

    private String num;

    private Boolean isAvailable;

    public static Magnet create(MagnetRequest request) {
        return Magnet.builder()
                .title(request.getTitle())
                .num(request.getNum())
                .isAvailable(false)
                .build();
    }
}
