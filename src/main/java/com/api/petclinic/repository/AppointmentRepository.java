package com.api.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.petclinic.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByPatientName(String name);

	Boolean existsByPatientName(String name);

	Boolean existsByPatientEmail(String email);

	List<Appointment> findByPatientEmail(String email);

	List<Appointment> findByDoctorname(String name);

	Boolean existsByDoctorname(String name);
}
