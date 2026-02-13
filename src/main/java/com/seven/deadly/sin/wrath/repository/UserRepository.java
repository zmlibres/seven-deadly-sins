package com.seven.deadly.sin.wrath.repository;

import com.seven.deadly.sin.wrath.dto.common.enums.Status;
import com.seven.deadly.sin.wrath.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUserId(String userId);

    Optional<User> findUserByUsername(String username);

    Page<User> findAllByStatus(Status status, Pageable pageable);

}
