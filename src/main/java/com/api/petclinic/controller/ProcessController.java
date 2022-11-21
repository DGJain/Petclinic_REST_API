package com.api.petclinic.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.petclinic.domain.Appointment;
import com.api.petclinic.domain.Doctor;
import com.api.petclinic.domain.Feedback;
import com.api.petclinic.payload.request.AppointmentRequest;
import com.api.petclinic.payload.request.FeedbackRequest;
import com.api.petclinic.payload.response.DoctorListResponse;
import com.api.petclinic.payload.response.MessageResponse;
import com.api.petclinic.repository.AppointmentRepository;
import com.api.petclinic.repository.DoctorRepository;
import com.api.petclinic.repository.FeedbackRepository;
import com.api.petclinic.repository.LoginRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/process/")
public class ProcessController {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	LoginRepository userRepository;

	@GetMapping("/alldoctors")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	public String adminAccess() {
		return "Admin Board.";
	}

	@PostMapping("/appointmentbooking")
	public ResponseEntity<?> appointmentBooking(@Valid @RequestBody AppointmentRequest appointmentRequest)
			throws ParseException {

		List<Appointment> appointmentFecth = appointmentRepository
				.findByPatientName(appointmentRequest.getPatientName());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		if (!appointmentFecth.isEmpty()) {
			for (Appointment appointment : appointmentFecth) {

				if (appointment.getDoctorname().equalsIgnoreCase(appointmentRequest.getDoctorname())) {

					Date appointmentDateReq = formatter.parse(appointmentRequest.getAppointmentDate());

					Calendar calReq = Calendar.getInstance();
					calReq.setTime(appointmentDateReq);
					Calendar calFetch = Calendar.getInstance();
					calFetch.setTime(appointment.getAppointmentDate());

					if (calReq.get(Calendar.DAY_OF_YEAR) == calFetch.get(Calendar.DAY_OF_YEAR)) {
						return ResponseEntity.badRequest()
								.body(new MessageResponse("Error: Patient for Doctor is already booked same day!"));
					}

				}

			}
		}

		appointmentFecth = appointmentRepository.findByDoctorname(appointmentRequest.getDoctorname());

		if (!appointmentFecth.isEmpty()) {
			for (Appointment appointment : appointmentFecth) {

				Date appointmentDateReq = formatter.parse(appointmentRequest.getAppointmentDate());

				Calendar calReq = Calendar.getInstance();
				calReq.setTime(appointmentDateReq);
				Calendar calFetch = Calendar.getInstance();
				calFetch.setTime(appointment.getAppointmentDate());

				if (calReq.get(Calendar.DAY_OF_YEAR) == calFetch.get(Calendar.DAY_OF_YEAR) && appointmentRequest
						.getAppointmentTime().equalsIgnoreCase(String.valueOf(appointment.getAppointmentTime())))
					return ResponseEntity.badRequest()
							.body(new MessageResponse("Error: Doctor is already booked same day at same slot!"));
			}

		}

		Date appointmentDateReq = formatter.parse(appointmentRequest.getAppointmentDate());

		// Create new appointment
		Appointment appointment = new Appointment();
		appointment.setPatientName(appointmentRequest.getPatientName());
		appointment.setPatientMobile(appointmentRequest.getPatientMobile());
		appointment.setPatientEmail(appointmentRequest.getPatientEmail());
		appointment.setUpdatedOn(new Date());

		appointment.setAppointmentDate(appointmentDateReq);
		appointment.setAppointmentTime(Time.valueOf(appointmentRequest.getAppointmentTime()));
		appointment.setDoctorname(appointmentRequest.getDoctorname());
		appointment.setSpecialization(appointmentRequest.getSpecialization());

		appointment.setPettype(appointmentRequest.getPettype());

		appointmentRepository.save(appointment);

		return ResponseEntity.ok(new MessageResponse("User appointment booked successfully!"));
	}

	@PostMapping("/feedbackdoctor")
	public ResponseEntity<?> feedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {

		// Create new feedback
		Feedback feedback = new Feedback();
		feedback.setName(feedbackRequest.getUsername());
		feedback.setReview(feedbackRequest.getReview());
		feedback.setEmail(feedbackRequest.getEmail());
		feedback.setUpdatedOn(new Date());
		feedback.setMobile(feedbackRequest.getMobile());

		feedbackRepository.save(feedback);

		return ResponseEntity.ok(new MessageResponse("User feedback received successfully!"));
	}

	@GetMapping("/availabledoctor")
	public ResponseEntity<?> availableDoctor() {

		List<Doctor> lstDoctor = doctorRepository.findAll();

		List<DoctorListResponse> retlstDoctorRes = new ArrayList<>();
		for (Doctor doctor : lstDoctor) {

			retlstDoctorRes.add(new DoctorListResponse(doctor.getId(), doctor.getName(), doctor.getEmail(),
					doctor.getMobile(), doctor.getSpecialization()));

		}
		return ResponseEntity.ok().body(retlstDoctorRes);

	}
}
