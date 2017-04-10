package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findByFirstNameAndMiddleInitialAndLastName(String firstName, String middleInitial, String lastName);
}
