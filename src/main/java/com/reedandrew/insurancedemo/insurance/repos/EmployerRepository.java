package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.Employer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
