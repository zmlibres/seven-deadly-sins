package com.seven.deadly.sin.wrath.repository;

import com.seven.deadly.sin.wrath.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUserId(String userId);

}
