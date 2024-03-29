package com.movieHam.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVO, Long> {
    Optional<UserVO> findById(Long id);
}
