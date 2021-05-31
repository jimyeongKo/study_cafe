package com.study.cafe.studycafe.domain.user.persistence;

import com.study.cafe.studycafe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
