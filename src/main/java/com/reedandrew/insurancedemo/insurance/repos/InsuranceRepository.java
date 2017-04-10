package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.Insurance;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {
}
