package com.boutique.repository;

import com.boutique.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Register, Long> {
    Optional<Register> findByUsername(String username);
}