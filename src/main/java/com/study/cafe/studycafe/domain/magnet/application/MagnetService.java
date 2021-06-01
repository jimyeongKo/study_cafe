package com.study.cafe.studycafe.domain.magnet.application;

import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import com.study.cafe.studycafe.domain.magnet.domain.Magnet;
import com.study.cafe.studycafe.domain.magnet.dto.MagnetRequest;
import com.study.cafe.studycafe.domain.magnet.dto.MagnetResponse;
import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import com.study.cafe.studycafe.domain.magnet.persistence.MagnetRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MagnetService {

    private final MagnetRepository repository;

    public MagnetResponse create(MagnetRequest request) {
        Magnet magnet = Magnet.create(request);

        repository.save(magnet);

        return new MagnetResponse(magnet);
    }

    public List<MagnetResponse> findAll(MagnetType title) {
        if (title == null) {
            List<Magnet> magnet = repository.findAll();
            return magnet.stream().map(MagnetResponse::new).collect(Collectors.toList());
        }

        List<Magnet> magnets = repository.findByTitle(title);
        return magnets.stream().map(MagnetResponse::new).collect(Collectors.toList());
    }
}
