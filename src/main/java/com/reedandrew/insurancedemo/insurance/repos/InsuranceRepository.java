package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.Employer;
import com.reedandrew.insurancedemo.insurance.model.Insurance;
import com.reedandrew.insurancedemo.insurance.model.InsurancePlan;
import com.reedandrew.insurancedemo.insurance.model.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

    Insurance findByPatientAndEmployerAndInsurancePlan(Patient patient, Employer employer, InsurancePlan insurancePlan);
}
