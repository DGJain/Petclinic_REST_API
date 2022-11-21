package com.api.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.petclinic.domain.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByName(String name);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

	List<Doctor> findByEmail(String email);
}
