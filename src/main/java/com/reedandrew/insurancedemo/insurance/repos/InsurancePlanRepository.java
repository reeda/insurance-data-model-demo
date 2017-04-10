package com.reedandrew.insurancedemo.insurance.repos;

import com.reedandrew.insurancedemo.insurance.model.InsurancePlan;
import org.springframework.data.repository.CrudRepository;

/**
 * @author reeda.
 */
public interface InsurancePlanRepository extends CrudRepository<InsurancePlan, Integer> {
}
