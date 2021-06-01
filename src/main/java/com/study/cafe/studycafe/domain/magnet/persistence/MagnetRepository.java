package com.study.cafe.studycafe.domain.magnet.persistence;

import com.study.cafe.studycafe.domain.magnet.domain.Magnet;
import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagnetRepository extends JpaRepository<Magnet, Long> {
    List<Magnet> findByTitle(MagnetType title);
}
