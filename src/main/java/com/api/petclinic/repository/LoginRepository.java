package com.api.petclinic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.petclinic.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByName(String name);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

	Optional<Login> findByEmail(String email);
}
