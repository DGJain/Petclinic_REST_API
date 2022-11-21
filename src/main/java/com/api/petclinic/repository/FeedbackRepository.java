package com.api.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.petclinic.domain.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	List<Feedback> findByName(String name);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

	List<Feedback> findByEmail(String email);
}
