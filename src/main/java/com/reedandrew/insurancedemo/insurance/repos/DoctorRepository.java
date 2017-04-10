package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    Doctor findByFirstNameAndLastName(String firstName, String lastName);
}
