package com.reedandrew.insurancedemo;

import com.reedandrew.insurancedemo.insurance.model.Doctor;
import com.reedandrew.insurancedemo.insurance.model.MaritalStatus;
import com.reedandrew.insurancedemo.insurance.model.Patient;
import com.reedandrew.insurancedemo.insurance.model.Sex;
import com.reedandrew.insurancedemo.insurance.repos.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class InsuranceDemoApplication {

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return strings -> {
			Doctor doc1 = new Doctor(null, "John", "Doe", "123-123-1234");
			Patient patient1 = new Patient(null, "Test", "D", "Patient", "234-234-2345", Sex.MALE, MaritalStatus.MARRIED, doc1);

			patientRepository.save(patient1);

			patientRepository.findAll().iterator().forEachRemaining(p -> {
				System.out.println(p.getFirstName());
			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InsuranceDemoApplication.class, args);
	}
}
